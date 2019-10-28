# CS441 - Android-Project 4
# Fall 2019 

Alan Liang
Android Studio Application 
Project 4 Description (README)

For the fourth android application, we were assigned to build a game that contains multiple screens while sharing some data between them. Each screen transitions to the next screen with different content. Content includes score page and instructions. I utilized Android Studio to develop a game that involves you taking the role of a basket. The objective of the game is quite simple and clear. You have to catch the apples while trying to avoid touching the rotten ones. Two apples fall from the top to the bottom of the screen and all you have to do is to drag the basket to catch the apples. When you catch the fresh apples, you will gain 1 point, whereas if you catch the rotten apples, you will lose 5 points. I also added a text blinking animation on the top of the screen that blinks for every 1 second with the use of a handler and some text functions. 

On the first screen (main activity), you can find yourself in the title and instruction page. This is where you can begin the game by pressing "PLAY". Then it transitions to the next screen which is the actual game, where you collect apples while dodging rotten ones. It keeps track of the score on the bottom of the screen. Under the score, you can choose to quit by pressing the "END THE GAME" button, and then it will transition you to the final screen or the "game over" screen. On that screen, it will display your score and on the bottom of the screen is where you see the button "GO BACK TO HOME" where clicking on it will take you back to the first screen.

-----------------------------------------------------------------------

- 10/14 - Planning
- 10/15 - First commit
- 10/16 - 10/19 (Replanning stage)
- 10/20 - Worked on developing multiple activities
- 10/21 - Fixed multiple activities problems
- 10/22 - Added features, functionalities, and graphics to make game work
- 10/25 - Fixed first and second activity layouts
- 10/26 - Modified layout (so everything looks organized)
- 10/27 - Game now has a game over screen where it successfully displays the correct score

-----------------------------------------------------------------------

Sources used:

- 【Game1】Android Studio Game Tutorial - Bonus#1 Move Images Vertically and Horizontally, https://www.youtube.com/watch?v=UxbJKNjQWD8
- 【Game2】Android Studio Game Tutorial - #5 Draw Blue Ball & Check Collision & Add Score, https://www.youtube.com/watch?v=dM5uo9fjQZk
- Tutorial How to Move a Picture in Android Studio - https://www.youtube.com/watch?v=jSXOypfZhxs
- How to Pass Data from One Activity to Another in Android Studio | Sanktips - https://www.youtube.com/watch?v=9u6FkCCflhc
- https://developer.android.com/reference/android/os/Handler
- https://developer.android.com/reference/android/view/WindowManager
- https://stackoverflow.com/questions/9294112/how-to-make-the-textview-blinking
