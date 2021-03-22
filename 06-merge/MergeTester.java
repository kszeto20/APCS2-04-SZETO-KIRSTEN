import java.util.*;
import java.lang.*;
public class MergeTester {
  public static void main(String[] args) {
    int[] test = new int[10000000];
    Random r = new Random();
    for (int i = 0; i < test.length; i++) {
      test[i] = r.nextInt(101);
    }
    int[] copy = new int[test.length];
    for (int i = 0; i < test.length; i++) {
      copy[i] = test[i];
    }


    System.out.println("-------------NOW ARRAYS MERGING---------------");
    long startTime = System.currentTimeMillis();
    Arrays.sort(copy);
    long endTime = System.currentTimeMillis();
    long timeElapsed = endTime - startTime;
    System.out.println("Arrays.sort() Execution time in milliseconds: " + timeElapsed);

    long prof = timeElapsed;

    System.out.println("-------------NOW MY MERGING---------------");

    startTime = System.currentTimeMillis();
    Merge.mergesort(test);
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    System.out.println("My.sort() Execution time in milliseconds: " + timeElapsed);

    long ama = timeElapsed;

    long timesSlower = (ama / prof);
    System.out.println("How many times slower is mine: " + timesSlower);

    int smallest = 0;
    for (int i = 1; i < test.length; i++) {
      if (test[i] < test[smallest]) {
        smallest = i;
      }
    }
    System.out.println((smallest == 0));
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
