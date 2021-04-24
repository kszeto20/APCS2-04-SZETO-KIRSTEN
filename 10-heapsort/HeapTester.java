import java.util.*;
import java.lang.*;
public class HeapTester {
  public static void main (String[] args) {
    int[] test = {90, 34, 99, 14, 89};
    System.out.println("Before: " + Arrays.toString(test));
    MyHeap.pushDown(test, 5, 0);
    System.out.println("After: " + Arrays.toString(test));
  }
}
