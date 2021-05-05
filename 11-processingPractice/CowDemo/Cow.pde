public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding;
  boolean selected;
 
  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));
  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
  }
  void display() {
    if (colliding) {
      stroke(0);
      fill(225, 0, 34, 225);
    }
    else {
      stroke(0);
      fill(c);
    }
    ellipse(x, y, radius*2, radius*2);
    if (selected) {
      stroke(225);
      fill(#FCF2F2);
      circle((float)(this.x - this.radius / 2), (float)(this.y - this.radius / 2), 10);
      circle((float)(this.x + this.radius / 2), (float)(this.y - this.radius / 2), 10);
      line(this.x - 10, this.y - 5, this.x - 5, this.y + 10);
      line(this.x - 5, this.y + 10, this.x + 5, this.y + 10);
      line(this.x + 5, this.y + 10, this.x + 10, this.y - 5);
      //selected = false;
    }
  }
 
  void click(){
    //if the mouseX and mouseY are touching this cow, change the cow somehow.
    if ((mouseX < x + radius && mouseX > x - radius) && (mouseY < y + radius && mouseY > y - radius)) {
      if (selected) {
        selected = false;
      } else {
        selected = true;
      }
      c = color(#E3AEA9);
    }
  }
  
  void collide(ArrayList<Cow> others) {
    for (Cow comp : others) {
      if (this == comp) {
      } else {
        
        if (
         ((this.y + this.radius < comp.y - comp.radius) ||
         (this.y - this.radius > comp.y + comp.radius)) &&
         ((this.x + radius < comp.x - comp.radius) || 
         (this.x - radius > comp.x + comp.radius)
         )) {
         colliding = false;
         }
         else {
           colliding = true;
         }
      }
     }
   }
}
