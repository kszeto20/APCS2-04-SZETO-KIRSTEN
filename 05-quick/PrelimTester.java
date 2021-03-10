import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = {999,999,999, 1, 0, 100, 30, 8, 10, -12, 999, 999};
    System.out.println(Preliminary.partition(test, 3, 9));
  }
}

//0, 1, 8, 10, 30, 100
