import objectdraw.*;
import java.awt.Color; 


/**
 * DrawArc1 draws a circle at a given location.
 * upon started on as a thread, e.g.
 * Thread arc = new DrawArc(<params>);
 * arc.start();
 * the circle moves diagonally down and back up the screen.
 */
public class DrawArc1 extends Thread {
  private double x;
  private double y;
  private DrawingCanvas canvas;
  private FilledArc cheekLeft;
  private FilledArc cheekRight;
  private final double ARC_CHEEK = 80;
  private final double START_ANGLE = 0;
  private final double ARC_ANGLE = 360;

  /**
   * @param x - x starting location for the arc
   * @param y - y starting location for the arc
   * @param canvas - the canvas to draw the arc in. Should be
   * provided by objectdraw
   */
  public DrawArc1(double x, double y, DrawingCanvas canvas) {
    this.x = x;
    this.y = y;
    this.canvas = canvas;
    
    int color1 = 220;
    int color2 = 0;
    int color3 = 26;
    Color bigColor = new Color(color1, color2, color3);
    //drwa his cheeks and set them red.
    cheekLeft = new FilledArc(x, y, ARC_CHEEK, ARC_CHEEK, START_ANGLE, 
      ARC_ANGLE, canvas);
    cheekLeft.setColor(bigColor);
    cheekRight = new FilledArc(x, y, ARC_CHEEK, ARC_CHEEK, START_ANGLE, 
      ARC_ANGLE, canvas);
    cheekRight.setColor(bigColor);
  }
  
  

  /**
   * Executed when the thread starts and runs indefinitly, moving the arc
   * across the screen.
   */
  public void run() {
    int edge = 400;
    double downY1=3.7;
    double downX1=-0.7;
    double downY2= downY1;
    double downX2=4;
    cheekLeft.show();
    cheekRight.show();
    int moving = 53;
    int time = 10;
    //bring cheeks to their positions
      for(int i = 0; i < moving; i++ ) {
        cheekLeft.move(downX1, downY1);
        cheekLeft.show();
        cheekRight.move(downX2, downY2);	
        cheekLeft.show();
        Animate.catchSleep(time);
      }
  } 
}
