import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = {7, 7, 12, 7, 8, 7, 7, 13, 9};

    Random r = new Random();

//    System.out.println(Quick.quickselect(test, 0));
//    System.out.println(Quick.quickselect(test, 1));
//    System.out.println(Quick.quickselect(test, 5));
    System.out.println(Preliminary.partition(test, 0, test.length - 1));

    // reverse sorted? (3 seconds for 10 million)
    /*
    int nums = 10000000;
    for (int i = 0; i < test.length; i++) {
      test[i] = nums - 1;
      nums =- 1;
    }
    int[] copy = new int[test.length];
    for (int i = 0; i < test.length; i++) {
      copy[i] = test[i];
    }
    long startTime = System.currentTimeMillis();
    Preliminary.quicksort(test);
    long endTime = System.currentTimeMillis();
    long timeElapsed = endTime - startTime;
    System.out.println("My.sort() Execution time in milliseconds: " + timeElapsed);
    */
/*
    startTime = System.currentTimeMillis();
    Preliminary.quicksort(test);
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    System.out.println("My.sort() Execution time in milliseconds: " + timeElapsed);
*/

    // below is random

/*
    for (int i = 0; i < test.length; i++) {
      test[i] = r.nextInt(101);
    }

    int[] copy = new int[test.length];
    for (int i = 0; i < test.length; i++) {
      copy[i] = test[i];
    }

    long startTime = System.currentTimeMillis();
    Arrays.sort(copy);
    long endTime = System.currentTimeMillis();
    long timeElapsed = endTime - startTime;
    System.out.println("Arrays.sort() Execution time in milliseconds: " + timeElapsed);

    long prof = timeElapsed;

    startTime = System.currentTimeMillis();
    Preliminary.quicksort(test);
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    System.out.println("My.sort() Execution time in milliseconds: " + timeElapsed);

    long ama = timeElapsed;

    long timesSlower = (ama / prof);
      System.out.println("How many times slower is mine: " + timesSlower);
      */
// below is forward sorted
    /*
    for (int i = 0; i < test.length; i++) {
      test[i] = r.nextInt(101);
    }
    int[] copy = new int[test.length];
    for (int i = 0; i < test.length; i++) {
      copy[i] = test[i];
    }
//    System.out.println(toString(copy));
    Arrays.sort(copy);
    Arrays.sort(test);
    System.out.println("------------------ BUILT IN SORT -------------------");
    long startTime = System.currentTimeMillis();
    Arrays.sort(copy);
    long endTime = System.currentTimeMillis();
    long timeElapsed = endTime - startTime;
    System.out.println("Arrays.sort() Execution time in milliseconds: " + timeElapsed);
//    System.out.println(toString(test));
//    System.out.println("--------- SORTING NOW -------------------");
    //System.out.println(Preliminary.partition(test, 0, test.length));
    //Arrays.sort(test);
    //System.out.println("--------------------");
    //int toRet = test[1000004];
    //System.out.println("DIRECT: " + toRet);
    //System.out.println(Preliminary.quickselect(test, 1000004));
    System.out.println("--------- QUICKSELECT NOW -------------------");
    startTime = System.currentTimeMillis();
    Preliminary.quicksort(copy);
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    System.out.println("My.sort() Execution time in milliseconds: " + timeElapsed);
*/

    // below: reverse sorted check
  /*
    ArrayList<Integer> toShuffle = new ArrayList<Integer>(test.length);
    for (int i = 0; i < test.length; i++) {
      toShuffle.add(r.nextInt(100));
    }
    Collections.reverse(toShuffle);
		for (int i = 0; i < test.length; i++) {
      test[i] = toShuffle.get(i);
    }//converts arraylist to array
    int[] copy = new int[test.length];
    for (int i = 0; i < test.length; i++) {
      copy[i] = test[i];
    }
    System.out.println("------------------ BUILT IN SORT -------------------");
    long startTime = System.currentTimeMillis();
    Arrays.sort(copy);
    long endTime = System.currentTimeMillis();
    long timeElapsed = endTime - startTime;
    System.out.println("Arrays.sort() Execution time in milliseconds: " + timeElapsed);
    System.out.println("------------------- MY SORT -------------------------");
    startTime = System.currentTimeMillis();
    Preliminary.quicksort(test);
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    System.out.println("My.sort() Execution time in milliseconds: " + timeElapsed);
    //System.out.println(Preliminary.partition(test, 0, test.length));
*/
/*
    int randInd = r.nextInt(10001);
    int builtIn = copy[randInd];
    int myOwn = Preliminary.quickselect(test, randInd);
    System.out.println((builtIn == myOwn));
    */
  }
}
