import objectdraw.*;
import java.awt.Color; 


/**
 * DrawOval1 draws a circle at a given location.
 * upon started on as a thread, e.g.
 * Thread arc = new DrawArc(<params>);
 * arc.start();
 * the circle moves diagonally down and back up the screen.
 */
public class DrawOval1 extends Thread {
  private double x;
  private double y;
  private DrawingCanvas canvas;
  private FilledOval bigMouth;
  public static FilledOval smallmouth;
  private static FilledOval nose;
  private final double bigHeight = 130;
  private final double bigWidth = 150;
  private final double smallHeight = 45;
  private final double smallWidth = 30;
  private final double noseHeight = 40;
  private final double noseWidth = 45;
  private static boolean click = false;

  /**
   * @param x - x starting location for the arc
   * @param y - y starting location for the arc
   * @param canvas - the canvas to draw the arc in. Should be
   * provided by objectdraw
   */
  public DrawOval1(double x, double y, DrawingCanvas canvas) {
    this.x = x;
    this.y = y;
    this.canvas = canvas;
    
    //draw mouth and nose
    bigMouth = new FilledOval(x, y, bigWidth, bigHeight, canvas);
    bigMouth.setColor(Color.WHITE);
    smallmouth = new FilledOval(x, y, smallWidth, smallHeight, canvas);
    smallmouth.setColor(Color.BLACK);
    nose = new FilledOval(x, y, noseWidth, noseHeight, canvas);
    nose.setColor(Color.BLACK);
  }

  /**
  * name: setWhite
  * method set the small mouth white and invisible, then draw another
  * moving mouth in another class
  */
  public static void setWhite() {
    smallmouth.setColor(Color.WHITE);
  }
  
  

  /**
   * Executed when the thread starts and runs indefinitly, moving the arc
   * across the screen.
   */
  public void run() {
    int edge = 400;
    double downY1=6.1;
    double downX1=3.6;
    double downY2=7.5;
    double downX2=4.8;
    double downY3=6.2;
    double downX3=4.7;
    
    //moving mouth and nose to their positions
      for(int i = 0; i < 50; i++ ) {
        bigMouth.move(downX1, downY1);
        bigMouth.show();
        smallmouth.move(downX2, downY2);	
        smallmouth.show();
        nose.move(downX3, downY3);
        nose.show();
        Animate.catchSleep(10);
      }
    
  }
 
}
