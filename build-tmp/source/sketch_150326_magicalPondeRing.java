import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_150326_magicalPondeRing extends PApplet {

float noiseOne, noiseTwo, noiseThree, interval, rotation;

public void setup() {
	size(512, 512);
	noiseOne = random(10);
	noiseTwo = random(10);
	noiseThree = random(10);
	interval = 0.008f;
	rotation = 0;
}

public void draw() {
	noStroke();
	fill(255, 10);
	rect(0, 0, width, height);

	for (int i = 0; i < 10; ++i) {
		pushMatrix();
		translate(width/2, height/2);
		rotate(radians(36*i)+rotation);
		noStroke();
		fill(255, 0, 0, 30);
		float noiseF = noise(noiseOne) * 150 + 50;
		ellipse(0, -noiseF, 100, 100);
		popMatrix();
	}
	for (int i = 0; i < 10; ++i) {
		pushMatrix();
		translate(width/2, height/2);
		rotate(-(radians(36*i)+rotation));
		noStroke();
		fill(0, 255, 0, 30);
		float noiseF = noise(noiseTwo) * 150 + 50;
		ellipse(0, -noiseF, 100, 100);
		popMatrix();
	}
	for (int i = 0; i < 10; ++i) {
		pushMatrix();
		translate(width/2, height/2);
		rotate(radians(36*i)+rotation);
		noStroke();
		fill(0, 0, 255, 30);
		float noiseF = noise(noiseThree) * 150 + 50;
		ellipse(0, -noiseF, 100, 100);
		popMatrix();
	}

	noiseOne += interval;
	noiseTwo += interval;
	noiseThree += interval;
	rotation += 0.01f;

	fill(255);
	rect(0, 0, 150, 20);
	fill(0);
	text("framerate"+frameRate, 10, 10);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_150326_magicalPondeRing" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
