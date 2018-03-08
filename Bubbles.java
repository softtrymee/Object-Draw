import objectdraw.*;
import java.awt.Color; 
import java.util.Random;


/**
 * DrawArc Bubbles a circle at a given location.
 * upon started on as a thread, e.g.
 * Thread arc = new DrawArc(<params>);
 * arc.start();
 * the circle moves diagonally down and back up the screen.
 */
public class Bubbles extends Thread {
  private double x;
  private double y;
  private DrawingCanvas canvas;
  public static FramedArc bubble1;
  public static FramedArc bubble2;
  private final double START_ANGLE = 0;
  private final double ARC_ANGLE = 360;
  private final double bubbleSize = 100;
  private static int x1;
  private static int x2;
  private static int x3;
  private static int x4;
  Random randGen = new Random();

   /**
   * @param x - x starting location for the arc
   * @param y - y starting location for the arc
   * @param canvas - the canvas to draw the arc in. Should be
   * provided by objectdraw
   */
  public Bubbles(double x, double y, DrawingCanvas canvas) {
    this.x = x;
    this.y = y;
    this.canvas = canvas;
    int color1 = randGen.nextInt(256);
    int color2 = randGen.nextInt(256);
    int color3 = randGen.nextInt(256);
    int color4 = randGen.nextInt(256);
    int color5 = randGen.nextInt(256);
    int color6 = randGen.nextInt(256);
    Color bubbleColor1 = new Color(color1, color2, color3);
    Color bubbleColor2 = new Color(color4, color5, color6);

    //draw buble
    bubble1 = new FramedArc(x, y, bubbleSize, bubbleSize, 
      START_ANGLE, ARC_ANGLE, canvas);
    bubble1.setColor(bubbleColor1);
    bubble2 = new FramedArc(x + x, y + y, bubbleSize, bubbleSize, 
    START_ANGLE, ARC_ANGLE, canvas);
    bubble2.setColor(bubbleColor2);

}
  
  /**
   * Executed when the thread starts and runs indefinitly, moving the bubble
   * across the screen.
   */
  public void run() {

    int edge = 400;
  	//make the new one move
    x1 = 1;
    x2 = -1;
    x3 = -1;
    x4 = 1;
    int time = 20;
    while (true) {
      //if it touches left wall, bounce right
      if (bubble1.getX() == 0) {
        x1 = 1;
      }
      //if it touches right wall, bounce left
      if (bubble1.getX() == edge) {
        x1 = -1;
      }
      //if it touches ceiling, fall down
      if (bubble1.getY() == 0) {
        x2 = 1;
      }
      //if it touches ground, rise
      if (bubble1.getY() == edge) {
        x2 = -1;
      }
      if (bubble2.getX() == 0) {
        x3 = 1;
      }
      //if it touches right wall, bounce left
      if (bubble2.getX() == edge) {
        x3 = -1;
      }
      //if it touches ceiling, fall down
      if (bubble2.getY() == 0) {
        x4 = 1;
      }
      //if it touches ground, rise
      if (bubble2.getY() == edge) {
        x4 = -1;
      }
      bubble1.move(x1, x2);
      bubble1.show();
      bubble2.move(x3, x4);
      bubble2.show();
      Animate.catchSleep(time);

    } 
  }
}
