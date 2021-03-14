import java.util.*;
import java.io.*;
public class PrelimTester {
  public static void main(String[] args) {
    int[] test = new int[6000000];
    Random r = new Random();
    for (int i = 0; i < test.length; i++) {
      test[i] = r.nextInt(101);
    }


    long startTime = System.currentTimeMillis();
    Arrays.sort(test);
    long endTime = System.currentTimeMillis();
    long timeElapsed = endTime - startTime;
    System.out.println("Arrays.sort() Execution time in milliseconds: " + timeElapsed);

    startTime = System.currentTimeMillis();
    Preliminary.quicksort(test);

        /* ... the code being measured starts ... */

        // sleep for 5 seconds
        //TimeUnit.SECONDS.sleep(5);

        /* ... the code being measured ends ... */

        endTime = System.currentTimeMillis();

        timeElapsed = endTime - startTime;

        //long timeInSec = timeElapsed / 1000;

        System.out.println("Execution time in milliseconds: " + timeElapsed);
/*
    Arrays.sort(test);

    long startTime = System.currentTimeMillis();

    int j = Preliminary.quickselect(test, 10000);
*/
        /* ... the code being measured starts ... */

        // sleep for 5 seconds
        //TimeUnit.SECONDS.sleep(5);

        /* ... the code being measured ends ... */
/*
        long endTime = System.currentTimeMillis();

        long timeElapsed = endTime - startTime;

        long timeInSec = timeElapsed / 1000;

        System.out.println("Execution time in milliseconds: " + timeElapsed);
        System.out.println((j == test[10001]));

    Preliminary.quicksort(test);
*/

/*
    for (int i = 0; i < test.length - 1; i++) {
      System.out.print(test[i] + ", ");
    }
    System.out.println(test[test.length - 1]);
    */

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
