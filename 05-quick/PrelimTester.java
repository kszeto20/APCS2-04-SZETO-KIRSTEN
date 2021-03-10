import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = {999,999,999, 0, 1, 35, 12, 30, 22, 999, 999, 999};
    System.out.println(Preliminary.partition(test, 3, 9));
  }
}
