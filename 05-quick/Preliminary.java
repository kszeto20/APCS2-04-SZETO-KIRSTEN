import java.io.*;
import java.util.*;
public class Preliminary {

  public static int partition (int [] data, int start, int end){
//    System.out.println(toString(data));
    Random r = new Random();
    int index = r.nextInt(end - start + 1) + start;
    System.out.println("RandomIndex: " + index);
    int pivot = data[index];
    System.out.println("PivotValue: " + pivot);
    for (int i = index; i > start; i--) {
      data[i] = data[i - 1];
    }
    data[start] = pivot;
    System.out.println("Initial move of P to the front: " + toString(data));
    int bigInd = start + 1;

    for (int toScan = start + 1; toScan <= end; toScan++) {
      if (data[toScan] < pivot) {
        System.out.println("BEFORE: " + toString(data));
        int storage = data[bigInd];
        data[bigInd] = data[toScan];
        data[toScan] = storage;
        System.out.println("BigInd Before: " + bigInd);
        bigInd++;
        System.out.println("BigInd After: " + bigInd);
//        System.out.println("Actual Smaller Case: " + toString(data) + "\n -------------");
      }
      else if (data[toScan] == pivot) {
        boolean bigSmallSplit = true;
        Random b = new Random();
        int bool = b.nextInt(2);
        if (bool == 0) {
          bigSmallSplit = false;
          System.out.println("System chose smaller!");
          int toStore = data[bigInd];
          data[bigInd] = data[toScan];
          data[toScan] = toStore;
          System.out.println("BigInd Before: " + bigInd);
          bigInd++;
          System.out.println("BigInd After: " + bigInd);
//          System.out.println("\n -------------");
        }
        System.out.println("System chose larger!");
      }
      System.out.println("AFTER: " + toString(data));
    }
    for (int i = 1; i < bigInd; i++) {
      data[i - 1] = data[i];
    }

    data[bigInd - 1] = pivot;
    System.out.println("DEBUG: Moved back into pivot spot" + toString(data));
//    System.out.println("BigInd: " + bigInd);
//    System.out.println("PivotValue: " + data[bigInd - 1]);
//    System.out.println("Kirsten's Pivot Index: " + (bigInd - 1));
    return (bigInd - 1);
  }

  public static int quickselect (int[] data, int k) {
    return quickSelect(data, k, 0, data.length - 1);
  }

  private static int quickSelect(int[] data, int k, int start, int end) {
    System.out.println("Start --> " + start + " end --> " + end);
    int resultInd = partition(data, start, end);
    if (resultInd == k) {
      return data[k];
    }
    if (resultInd < k) {
      System.out.println("After Initial Partition " + toString(data));
      System.out.println("Returned Index: " + resultInd);
      return quickSelect(data, k, resultInd, end);
    }
    else {
      System.out.println("After Initial Partition " + toString(data));
      System.out.println("Returned Index: " + resultInd);
      return quickSelect(data, k, start, resultInd);
    }
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
