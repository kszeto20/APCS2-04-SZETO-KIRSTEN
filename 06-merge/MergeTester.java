import java.util.*;
import java.lang.*;
public class MergeTester {
  public static void main(String[] args) {
      int[] test = new int[100];

      Random r = new Random();

      for (int i = 0; i < test.length; i++) {
        test[i] = r.nextInt(101);
      }

      System.out.println("-------------NOW MERGING---------------");

    Merge.mergeSort(test);
    System.out.println(toString(test) + "\n");

    int smallest = 0;
    for (int i = 0; i < test.length; i++) {
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
