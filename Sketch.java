import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */

  int cx, cy;
  float secondsRadius;
  float minutesRadius;
  float hoursRadius;
  float clockDiameter;
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
   int radius = min(width, height) / 2;
   secondsRadius = radius * 1;
   minutesRadius = radius * 1;
   hoursRadius = radius * 1;
   clockDiameter = radius * 2;
  
    cx = width / 2;
    cy = height / 2;
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  
	// sample code, delete this stuff

  float ellipseX = random(0, width);
  float ellipseY = random(0, height);
  float rectangle = random(100,200);
  float rectangleD = rectangle/2;

  ellipse(ellipseX - rectangleD, ellipseY - rectangleD, rectangle,rectangle);

  fill(80);
  noStroke();
  ellipse(cx, cy, clockDiameter, clockDiameter);
  

  float s = map(second(), 0, 60, 0, TWO_PI) - HALF_PI;
  float m = map(minute() + norm(second(), 0, 60), 0, 60, 0, TWO_PI) - HALF_PI; 
  float h = map(hour() + norm(minute(), 0, 60), 0, 24, 0, TWO_PI * 2) - HALF_PI;
  

  stroke(255);
  strokeWeight(1);
  line(cx, cy, cx + cos(s) * secondsRadius, cy + sin(s) * secondsRadius);
  strokeWeight(2);
  line(cx, cy, cx + cos(m) * minutesRadius, cy + sin(m) * minutesRadius);
  strokeWeight(4);
  line(cx, cy, cx + cos(h) * hoursRadius, cy + sin(h) * hoursRadius);
  

  strokeWeight(2);
  beginShape(POINTS);
  for (int a = 0; a < 360; a+=6) {
    float angle = radians(a);
    float x = cx + cos(angle) * secondsRadius;
    float y = cy + sin(angle) * secondsRadius;
    vertex(x, y);
  }
  endShape();

  }
  
  // define other methods down here.
}