/*import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = new int[1000000];
    Random r = new Random();
    for (int i = 0; i < test.length; i++) {
      test[i] = r.nextInt(101);
    }

    int[] copy = new int[test.length];
    for (int i = 0; i < test.length; i++) {
      copy[i] = test[i];
    }
//    System.out.println(toString(copy));
    Arrays.sort(test);
    Arrays.sort(copy);
    System.out.println("-------- BUILT IN SORT ---------");
//    System.out.println(toString(copy));

//    System.out.println(toString(test));
    System.out.println("--------- SORTING NOW -------------------");

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
*/
import java.io.*;
import java.util.*;
public class PrelimTester {

  public static void main(String[] args) {
    int[] test = new int[1000000];
    Random r = new Random();
    for (int i = 0; i < test.length; i++) {
      test[i] = r.nextInt(101);
    }

    int[] copy = new int[test.length];
    for (int i = 0; i < test.length; i++) {
      copy[i] = test[i];
    }
//    System.out.println(toString(copy));
    Arrays.sort(copy);
    System.out.println("-------- BUILT IN SORT ---------");
//    System.out.println(toString(copy));

//    System.out.println(toString(test));
    System.out.println("--------- SORTING NOW -------------------");

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
    int[] test = new int[1000000];

    ArrayList<Integer> toShuffle = new ArrayList<Integer>(test.length);
    for (int i = 0; i < test.length; i++) {
      Random r = new Random();
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

    System.out.println("-----------------------------");
    Arrays.sort(copy);

    System.out.println("-----------------------------");
    //System.out.println(Preliminary.partition(test, 0, test.length));

    Preliminary.quicksort(test);
    System.out.println("---------------------");
    Random c = new Random();
    int randInd = c.nextInt(10001);
    int builtIn = copy[randInd + 1];
    int myOwn = Preliminary.quickselect(test, randInd);
    System.out.println((builtIn == myOwn));
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
*/
//5, 12, 12, 22, 45, 192, 345, 7348, 23468
/*
NOTES:
- 10 mil; 1:38 min? for a already sorted
- 1 mil; 7.6 sec for already sorted

- 10 mil; 1:38 min? for a random
- 1 mil; 8.5 sec very small run time for random

- 10 mil; 1.38 min? for a reverse sorted
- 1 mil; 7.8 sec for a reverse sorted

*/
