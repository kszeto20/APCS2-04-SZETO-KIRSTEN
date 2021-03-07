import java.io.*;
public class CowTester {
  public static void main(String[] args) {
    try {
      System.out.println(USACO.bronze("input.txt"));
    }
    catch(FileNotFoundException e) {
      System.out.println("file not found");
    }
  }
}
