import java.io.*;
public class CowTester {
  public static void main(String[] args) {
    try {
      USACO.bronze("input.txt");
    }
    catch(FileNotFoundException e) {
      System.out.println("file not found");
    }
  }
}
