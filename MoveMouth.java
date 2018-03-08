import objectdraw.*;
import java.awt.Color; 


/**
 * DrawArc draws a circle at a given location.
 * upon started on as a thread, e.g.
 * Thread arc = new DrawArc(<params>);
 * arc.start();
 * the circle moves diagonally down and back up the screen.
 */
public class MoveMouth extends Thread {
  private double x;
  private double y;
  private DrawingCanvas canvas;
  public static FilledOval smallmouth;
  private final double smallHeight = 45;
  private final double smallWidth = 30;

   /**
   * @param x - x starting location for the arc
   * @param y - y starting location for the arc
   * @param canvas - the canvas to draw the arc in. Should be
   * provided by objectdraw
   */
  public MoveMouth(double x, double y, DrawingCanvas canvas) {
    this.x = x;
    this.y = y;
    this.canvas = canvas;
    int start1 = 238;
    int start2 = 375;

    //draw another small mouth
    smallmouth = new FilledOval(start1, start2, smallWidth, 
      smallHeight, canvas);
    smallmouth.setColor(Color.BLACK);
}
  
  /**
   * Executed when the thread starts and runs indefinitly, moving the arc
   * across the screen.
   */
  public void run() {
  	DrawOval1.setWhite();//set the previous one invisible
  	//make the new one move
    int loop = 15;
    int time = 10;
    while (true) {
       for (int i = 0; i < loop; i++) {
         smallmouth.setSize(smallmouth.getWidth() 
          + 1, smallmouth.getHeight() - 1);
         Animate.catchSleep(time);
       }
       for (int i = 0; i < loop; i++) {
         smallmouth.setSize(smallmouth.getWidth() - 1, 
          smallmouth.getHeight() + 1);
         Animate.catchSleep(time);
       }
    

    } 
  }
}
