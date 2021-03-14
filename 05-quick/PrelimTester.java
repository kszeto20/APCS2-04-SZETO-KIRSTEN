import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = new int[10000];
    Random r = new Random();
    for (int i = 0; i < test.length; i++) {
      test[i] = r.nextInt(101);
    }

    int[] copy = new int[10000];
    for (int i = 0; i < test.length; i++) {
      copy[i] = test[i];
    }
//    System.out.println(toString(copy));
    Arrays.sort(copy);
//    System.out.println("-------- BUILT IN SORT ---------");
//    System.out.println(toString(copy));

//    System.out.println(toString(test));
//    System.out.println("--------- SORTING NOW -------------------");

    //System.out.println(Preliminary.partition(test, 0, test.length));
    //Arrays.sort(test);
    //System.out.println("--------------------");
    //int toRet = test[1000004];
    //System.out.println("DIRECT: " + toRet);
    //System.out.println(Preliminary.quickselect(test, 1000004));
    Preliminary.quicksort(test);

    Random c = new Random();
    int randInd = c.nextInt(10001);
    int builtIn = copy[randInd + 1];
    int myOwn = Preliminary.quickselect(test, randInd);
    System.out.println((builtIn == myOwn));
//    System.out.println(toString(test));
  }

  public static String toString(int[] data) {
    String toRet = "{";
    for (int i = 0; i < data.length - 1; i++) {
        toRet += data[i];
        toRet += ", ";
      }
    toRet += data[data.length - 1];
    toRet += "}";
    return toRet;
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
