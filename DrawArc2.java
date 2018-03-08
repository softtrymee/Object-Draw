import objectdraw.*;
import java.awt.Color; 


/**
 * DrawArc2 draws a circle at a given location.
 * upon started on as a thread, e.g.
 * Thread arc = new DrawArc(<params>);
 * arc.start();
 * the circle moves diagonally down and back up the screen.
 */
public class DrawArc2 extends Thread {
  private double x;
  private double y;
  private DrawingCanvas canvas;
  private static FilledArc leftBigEar;
  private static FilledArc leftSmallEar;
  private static FilledArc rightBigEar;
  private static FilledArc rightSmallEar;
  private static FilledArc leftBigEye;
  public static FilledArc leftSmallEye;
  private static FilledArc rightBigEye;
  public static FilledArc rightSmallEye;
  private final double bigEarSize = 70;
  private final double smallEarSize = 30;
  private final double bigEyeSize = 65;
  private final double smallEyeSize = 24;
  private final double START_ANGLE = 0;
  private final double ARC_ANGLE = 360;
  /**
   * @param x - x starting location for the arc
   * @param y - y starting location for the arc
   * @param canvas - the canvas to draw the arc in. Should be
   * provided by objectdraw
   */
  public DrawArc2(double x, double y, DrawingCanvas canvas) {
    this.x = x;
    this.y = y;
    this.canvas = canvas;
    
    int color1 = 220;
    int color2 = 0;
    int color3 = 26;
    Color bigColor = new Color(color1, color2, color3);
    //drwa his ears and eyes
    leftBigEar = new FilledArc(x, y, bigEarSize, bigEarSize, START_ANGLE, 
      ARC_ANGLE, canvas);
    leftBigEar.setColor(Color.BLACK);
    leftSmallEar = new FilledArc(x, y, smallEarSize, smallEarSize, START_ANGLE,
     ARC_ANGLE, canvas);
    leftSmallEar.setColor(Color.WHITE);
    rightBigEar = new FilledArc(x, y, bigEarSize, bigEarSize, START_ANGLE,
     ARC_ANGLE, canvas);
    rightBigEar.setColor(Color.BLACK);
    rightSmallEar = new FilledArc(x, y, smallEarSize, smallEarSize, START_ANGLE,
     ARC_ANGLE, canvas);
    rightSmallEar.setColor(Color.WHITE);
    leftBigEye = new FilledArc(x, y, bigEyeSize, bigEyeSize, START_ANGLE,
     ARC_ANGLE, canvas);
    leftBigEye.setColor(Color.WHITE);
    leftSmallEye = new FilledArc(x, y, smallEyeSize, smallEyeSize, START_ANGLE,
     ARC_ANGLE, canvas);
    leftSmallEye.setColor(Color.BLACK);
    rightBigEye = new FilledArc(x, y, bigEyeSize, bigEyeSize, START_ANGLE,
     ARC_ANGLE, canvas);
    rightBigEye.setColor(Color.WHITE);
    rightSmallEye = new FilledArc(x, y, smallEyeSize, smallEyeSize, START_ANGLE,
     ARC_ANGLE, canvas);
    rightSmallEye.setColor(Color.BLACK);
  }
  

  /**
   * Executed when the thread starts and runs indefinitly, moving the arc
   * across the screen.
   */
  public void run() {
    double downY1=3;
    double downX1=2;
    double downY2=3.2;
    double downX2=2.2;
    double downY3=3;
    double downX3=6.7;
    double downY4=3.2;
    double downX4=7.25;
    double downY5=4.5;
    double downX5=3;
    double downY6=4.5;
    double downX6=3.2;
    double downY7=4.5;
    double downX7=5.8;
    double downY8=5.2;
    double downX8=6.5;
    int moving = 50;
    int time = 10;
    int eyeballmoving = 41;

      for(int i = 0; i < moving; i++ ) {
        leftBigEar.move(downX1, downY1);
        leftBigEar.show();
        leftSmallEar.move(downX2, downY2);	
        leftSmallEar.show();
        rightBigEar.move(downX3, downY3);
        rightBigEar.show();
        rightSmallEar.move(downX4, downY4);
        rightSmallEar.show();
        leftBigEye.move(downX5, downY5);
        leftBigEye.show();
        leftSmallEye.move(downX6, downY6);
        leftSmallEye.show();
        rightBigEye.move(downX7, downY7);
        rightBigEye.show();
        rightSmallEye.move(downX8, downY8);
        rightSmallEye.show();
        Animate.catchSleep(time);
      }
      //move eyeballs
      while (true) {
      for (int i = 0; i < eyeballmoving; i++) {
         leftSmallEye.move(1,1);
         rightSmallEye.move(-1, -1);
         Animate.catchSleep(time);
      }
      for (int i = 0; i < eyeballmoving; i++) {
         leftSmallEye.move(-1,-1);
         rightSmallEye.move(1, 1);
         Animate.catchSleep(time);
      }
    }
  }

}
