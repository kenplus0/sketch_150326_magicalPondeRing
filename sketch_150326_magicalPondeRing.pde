float noiseOne, noiseTwo, noiseThree, interval, rotation;

void setup() {
	size(512, 512);
	noiseOne = random(10);
	noiseTwo = random(10);
	noiseThree = random(10);
	interval = 0.008;
	rotation = 0;
}

void draw() {
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
	rotation += 0.01;

	fill(255);
	rect(0, 0, 150, 20);
	fill(0);
	text("framerate"+frameRate, 10, 10);
}
