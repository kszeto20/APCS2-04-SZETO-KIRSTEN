import java.util.*;
import java.lang.*;
public class HeapTester {
  public static void main (String[] args) {
    int testSize = 5000000;
    int[] test = new int[testSize];
    Random r = new Random();
    for (int i = testSize - 1; i >= 0; i--) {
      test[i] = r.nextInt();
    }

    System.out.println("Before: " + MyHeap.toString(test));
    MyHeap.heapsort(test);
    System.out.println("After: " + MyHeap.toString(test));

  }
}
