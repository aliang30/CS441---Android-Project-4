package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Point;
import android.view.Display;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.MotionEvent;

import android.app.Activity;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;

public class Main2Activity extends AppCompatActivity {

    int i = 0;
    private Button button2;
    private ViewGroup mainLayout;
    private ImageView image;

    private TextView comment;
    private int xDelta;
    private int yDelta;

    private int screenWidth;
    private int screenHeight;

    private ImageView apple;
    private ImageView apple2;
    private ImageView rotton;

    //First apple
    private float appleX;
    private float appleY;

    //Second apple
    private float apple2X;
    private float apple2Y;

    private float rottonX;
    private float rottonY;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        mainLayout = (RelativeLayout) findViewById(R.id.main);

        image = findViewById(R.id.basket);
        apple = findViewById(R.id.apple);
        apple2 = findViewById(R.id.apple1);
        rotton = findViewById(R.id.rotton);
        comment = findViewById(R.id.comment);

        image.setOnTouchListener(onTouchListener());


        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;

        //Giving both apples initial coordinates
        apple.setX(80.0f);
        apple.setY(screenHeight + 80.0f);

        apple2.setX(80.0f);
        apple2.setY(screenHeight + 80.0f);

        rotton.setX(80.0f);
        rotton.setY(screenHeight + 80.0f);

        //Running ball movement
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        ballPos();
                    }
                });
            }
        }, 0, 20);

        //blinking text animation
        blinkingEffect();


    }

    public void openActivity2() {
        Intent intent = new Intent(getApplicationContext(), Result.class);
        intent.putExtra("SCORE", i);
        startActivity(intent);
    }


    //Apple movement
    public void ballPos() {

        //If either ball collision is detected
        if (hitDetect(appleX, appleY)) {
            //erase apple1
            i += 1;
            appleX = -100;

            comment.setTextColor(Color.WHITE);
            comment.setText("Score: " + i);

        }

        if (hitDetect(apple2X, apple2Y)) {
            //erase apple2
            i += 1;
            apple2X = -100;

            comment.setTextColor(Color.WHITE);
            comment.setText("Score: " + i);

        }

        if (hitDetect(rottonX, rottonY)) {
            //erase rotton apple

            i -= 5;
            comment.setTextColor(Color.WHITE);
            comment.setText("Score: " + i);

            rottonX = -100;
        }


        //apple speed
        appleY = appleY + 40;

        if(apple.getY() > screenHeight) {
            appleX = (float) Math.floor(Math.random() * (screenWidth - apple.getWidth()));
            appleY = -100.0f;
        }
        apple.setX(appleX);
        apple.setY(appleY);


        //apple2 speed
        apple2Y = apple2Y + 30;

        if(apple2.getY() > screenHeight) {
            apple2X = (float) Math.floor(Math.random() * (screenWidth - apple2.getWidth()));
            apple2Y = -100.0f;
        }
        apple2.setX(apple2X);
        apple2.setY(apple2Y);

        //rotton apple speed
        rottonY = rottonY + 30;

        if(apple2.getY() > screenHeight) {
            rottonX = (float) Math.floor(Math.random() * (screenWidth - rotton.getWidth()));
            rottonY = -100.0f;
        }
        rotton.setX(rottonX);
        rotton.setY(rottonY);
    }

    //returns true if ball hits the basket
    public boolean hitDetect(float x, float y) {
        if (image.getX() < x && x < (image.getX() + image.getWidth()) &&
                image.getY() < y && y < (image.getY() + image.getHeight())) {
            return true;
        }
        return false;
    }



    private OnTouchListener onTouchListener() {
        return new OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:
                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }

                mainLayout.invalidate();
                return true;
            }
        };
    }

    private void blinkingEffect() {
        final Handler handler = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //1000 millisecond = 1 second
                int blinkTime = 1000;

                try{Thread.sleep(blinkTime);}
                catch (Exception e) {}

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Finds text and makes it disappear
                        TextView text = findViewById(R.id.text);

                        if(text.getVisibility() == View.VISIBLE){
                            text.setVisibility(View.INVISIBLE);
                        }
                        else{
                            //Makes text reappear
                            text.setVisibility(View.VISIBLE);
                        }
                        blinkingEffect();
                    }
                });
            }
        }).start();
    }
}