import objectdraw.*;
import java.awt.Color; 


/**
 * DrawArc draws a circle at a given location.
 * upon started on as a thread, e.g.
 * Thread arc = new DrawArc(<params>);
 * arc.start();
 * the circle moves diagonally down and back up the screen.
 */
public class DrawArc extends Thread {
  private double x;
  private double y;
  private DrawingCanvas canvas;
  public FilledArc fa1;
  public FilledArc face;
  private final double ARC1_SIZE = 400;
  private final double ARC2_SIZE = 300;
  private final double START_ANGLE = 0;
  private final double ARC_ANGLE = 360;

  /**
   * @param x - x starting location for the arc
   * @param y - y starting location for the arc
   * @param canvas - the canvas to draw the arc in. Should be
   * provided by objectdraw
   */
  public DrawArc(double x, double y, DrawingCanvas canvas) {
    this.x = x;
    this.y = y;
    this.canvas = canvas;
    
    int color1 = 37;
    int color2 = 168;
    int color3 = 220;
    Color bigColor = new Color(color1, color2, color3);
    //draw the background
    fa1 = new FilledArc(x, y, ARC1_SIZE, ARC1_SIZE, START_ANGLE, 
      ARC_ANGLE, canvas);
    //set background color
    fa1.setColor(bigColor);
    //draw the face
    face = new FilledArc(x, y, ARC2_SIZE, ARC2_SIZE, START_ANGLE, 
      ARC_ANGLE, canvas);
    //set face color
    face.setColor(Color.BLACK);
  }
  
  

  /**
   * Executed when the thread starts and runs indefinitly, moving the arc
   * across the screen.
   */
  public void run() {
    int edge = 400;
    double downY=2;
    double downX=1;
    int moving = 53;

      for(int i = 0; i < moving; i++ ) {
        face.move(downX, downY);	
        Animate.catchSleep(1);
      }
  } 
}
