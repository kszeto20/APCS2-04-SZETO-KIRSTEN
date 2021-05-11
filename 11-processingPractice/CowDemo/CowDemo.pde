ArrayList<Cow> particles;
void setup() {
  frameRate(60);
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 300; i++)
     particles.add(new Cow());
}
 
void draw() {
  background(200);
  for (Cow c : particles) {
    c.move();
    c.display();
    c.collide(particles);
  }
  fill(0);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}
 
void mousePressed() {
  //Read about mouseClicked()/mousePressed() and related methods in the documentation.
   //Right click: add a cow at the mouse location.
   //Left click: call the click of each cow 
  if (mouseButton == LEFT) {
    for (int i = 0; i < particles.size(); i++) {
      particles.get(i).click();
    }
  }
  if (mouseButton == RIGHT) {
    Cow toAdd = new Cow();
    particles.add(toAdd);
  }
}
 
void keyPressed() {
  //Read about keyPressed() in the documentation.
  //hint:
  //println(keyCode);
  if (key == ' ') {
    particles.clear();
  }
}
