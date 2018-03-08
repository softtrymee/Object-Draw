import objectdraw.*;

import java.lang.InterruptedException;

/**
 * @author: Shengkai He
 * about: This program uses the objectdraw library to create an animation.
 *        Pieces of shapes will show up on the canvas. Then they will start
 *        moving and make up a cute Kumamon. If you click his mouth, he will
 *        start talking to you!
 *
 * compile: javac -cp objectdraw.jar:. Animate.java
 * run: java -cp objectdraw.jar:. Animate
 */

public class Animate extends WindowController {
  final static int SIZE = 500; //size of the window for animation.
  final static int LINUX_MENU_BAR = 50; // account for menu bar on
                                        // linux systems
  private static int mouseX, mouseY;
  private static int OVAL_WIDTH = 50;

  /**
   * Program control automatically jumps to this method after executing
   * startController(). This is the method you'll want to use to draw
   * your animation or create threads. 
   */
  public void begin() {
    int startSleep = 1000;
    int start1 = 50;
    int start2 = 120;
    int start3 = 350;
    

      // The canvas variable is inherited. We'll talk about this later
      // in the class. For now, whenever the API asks for a canvas
      // as a parameter, use myCanvas
      DrawingCanvas myCanvas = canvas; 

      
      //Example thread creation to draw a circle 
      Thread t1 = new DrawArc(start1, start1, canvas);
      catchSleep(startSleep); //make the primary thread sleep
      Thread t2 = new DrawArc1(start2, start2, canvas);
      catchSleep(startSleep); //make the primary thread sleep
      Thread t3 = new DrawArc2(0, 0, canvas);
      catchSleep(startSleep); //make the primary thread sleep
      Thread t4 = new DrawOval1(0, 0, canvas);
      catchSleep(startSleep); //make the primary thread sleep
      Thread t5 = new Bubbles(start1, start1, canvas);
      catchSleep(startSleep); //make the primary thread sleep
      t1.start();
      t2.start();
      t3.start();
      t4.start();
      t5.start();
      
  }

  /**
   * Has the program pause for time miliseconds so animations can move
   * at a speed you'd like
   * @param time the time in miliseconds you want to sleep.
   */
  public static void catchSleep(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {}
  }
  
  /**
   * Recognize mouse click and call methods in DrawOval to determine
   * if the click is in the oval.
   * @param point
   */
  public void onMouseClick(Location point) {
	  Thread t6 = new MoveMouth(0, 0, canvas);
    t6.start(); 
  } 

  /**
  * executes and draw the Kumamon
  */
  public static void main(String[] args) {
    // start the animation. 
    new Animate().startController(SIZE,SIZE+LINUX_MENU_BAR);
  }
}
