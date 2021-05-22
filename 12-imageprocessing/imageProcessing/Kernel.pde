public class Kernel {
  float[][] kernel;
  
  public Kernel(float[][] init) {
    kernel = init;
  }
  
  color calcNewColor(PImage img, int x, int y) {
    if (x == 0 || x == img.width - 1) {
      return color(0);
    }
    if (y == 0 || y == img.height - 1) {
      return color(0);
     }
     else {
       float Rcount = 0;
       float Bcount = 0;
       float Gcount = 0;
       float rgen = 0;
       float bgen = 0;
       float ggen = 0;
       for (int i = x - 1, r = 0; i < x + 2; i++, r++) {
         for (int j = y - 1, c = 0; j < y + 2; j++, c++) {
           color bruh = img.get(i,j);
           rgen = red(bruh);
           bgen = blue(bruh);
           ggen = green(bruh);
           rgen *= kernel[r][c];
           bgen *= kernel[r][c];
           ggen *= kernel[r][c];
           Rcount += rgen;
           Bcount += bgen;
           Gcount += ggen;
         }
       }
       return color(Rcount, Gcount, Bcount);
     }
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    //return color(0);
  }
  
  void apply(PImage source, PImage output) {
    for (int i = 0; i < source.width; i++) {
      for (int j = 0; j < source.height; j++) {
        color a = calcNewColor(source, i, j);
        output.set(i,j,a);
      }
    }
  }
}
