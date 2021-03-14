import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = {999, 999, 999, 3, 4, 18, 25, 100, 330, 999, 999, 999};
    //System.out.println(Preliminary.partition(test, 0, test.length));
    System.out.println(Preliminary.quickselect(test, 0));
  }
}

//0, 1, 8, 10, 30, 100
