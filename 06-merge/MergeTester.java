import java.util.*;
import java.lang.*;
public class MergeTester {
  public static void main(String[] args) {
      int[] test = {234, 45, 69, 43, 123, 68, 432, 77};

      System.out.println("-------------NOW MERGING---------------");

    Merge.mergeSort(test);
    System.out.println(toString(test));
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
