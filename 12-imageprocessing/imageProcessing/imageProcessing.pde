class Kernel {
  float[][]kernel;
  /*Constructor takes the kernel that will be applied to the image*/
  public Kernel(float[][]init) {
    kernel = init;
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    return 0;
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
  }
  
  void setup(){
    size(1450,500);
    PImage car = loadImage("redcar.jpg");
    PImage output = car.copy();
    Kernel k = new Kernel( new float[][]    { {-1, -1, -1},
       {-1, 8, -1},
     {-1, -1, -1} } );
    k.apply(car,output);
    image(car,0,0);
    image(output,car.width,0);
  }
}
