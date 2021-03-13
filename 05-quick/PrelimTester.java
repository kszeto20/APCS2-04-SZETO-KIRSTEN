import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = {0, 999, 999, 1, 999, 100, 30, 8, 10, 999, 999, 999};
    System.out.println(Preliminary.partition(test, 0, test.length));
  }
}

//0, 1, 8, 10, 30, 100
