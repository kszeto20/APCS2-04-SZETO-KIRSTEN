import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = {0, 1, 5, 12, 30, 22};
    System.out.println(Preliminary.partition(test, 0, test.length - 1));
  }
}
