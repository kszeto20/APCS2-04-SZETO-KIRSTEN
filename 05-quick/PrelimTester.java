import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = new int[10000000];
    Random r = new Random();
    for (int i = 0; i < 10000000; i++) {
      test[i] = r.nextInt(100);
    }
    //System.out.println(Preliminary.partition(test, 0, test.length));
    Arrays.sort(test);
    System.out.println("--------------------");
    int toRet = test[1000000];
    System.out.println("DIRECT: " + toRet);
    System.out.println(Preliminary.quickselect(test, 1000000));
  }
}

//5, 12, 12, 22, 45, 192, 345, 7348, 23468

/*

import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = new int[10000000];

    ArrayList<Integer> toShuffle = new ArrayList<Integer>(test.length);
    for (int i = 0; i < test.length; i++) {
      Random r = new Random();
      toShuffle.add(r.nextInt(100));
    }

    Collections.shuffle(toShuffle);

		for (int i = 0; i < test.length; i++) {
      test[i] = toShuffle.get(i);
    }//converts arraylist to array

    System.out.println("-----------------------------");
    //System.out.println(Preliminary.partition(test, 0, test.length));
    System.out.println(Preliminary.quickselect(test, 3000000));
  }
}

//5, 12, 12, 22, 45, 192, 345, 7348, 23468
*/
