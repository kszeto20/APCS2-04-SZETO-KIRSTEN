import java.io.*;
import java.util.*;
public class Preliminary {

  public static int partition (int [] data, int start, int end){
//    System.out.println(toString(data));

    Random r = new Random();
    int index = r.nextInt(end - start) + start;
//    System.out.println("RandomIndex: " + index);
    int pivot = data[index];
//    System.out.println("PivotValue: " + pivot);
    int front = data[start];
    data[start] = pivot;
    data[index] = front;
//    System.out.println("Initial move of P to the front: " + toString(data));
    int bigInd = start + 1;

    for (int toScan = start + 1; toScan < end; toScan++) {
      if (data[toScan] < pivot) {
//        System.out.println("BEFORE: " + toString(data));
        int storage = data[bigInd];
        data[bigInd] = data[toScan];
        data[toScan] = storage;
//        System.out.println("BigInd Before: " + bigInd);
        bigInd++;
//        System.out.println("BigInd After: " + bigInd);
//        System.out.println("Actual Smaller Case: " + toString(data) + "\n -------------");
      }
      else if (data[toScan] == pivot) {
        boolean bigSmallSplit = true;
        Random b = new Random();
        int bool = b.nextInt(2);
        if (bool == 0) {
          bigSmallSplit = false;
//          System.out.println("System chose smaller!");
          int toStore = data[bigInd];
          data[bigInd] = data[toScan];
          data[toScan] = toStore;
//          System.out.println("BigInd Before: " + bigInd);
          bigInd++;
//          System.out.println("BigInd After: " + bigInd);
//          System.out.println("\n -------------");
        }
        else {
//          System.out.println("System chose bigger!");
//          System.out.println("\n -------------");
        }
      }
      else {
//        System.out.println("DEBUG: bigInd --> " + bigInd + " | val --> " + data[bigInd]);
//        System.out.println("curToScan Val : "  + toScan);
//        System.out.println("\n -------------");
      }
//      System.out.println("AFTER: " + toString(data));
    }

    int temp = data[bigInd - 1];
    data[bigInd - 1] = data[start];
    data[start] = temp;
//    System.out.println(toString(data));
//    System.out.println("BigInd: " + bigInd);
//    System.out.println("PivotValue: " + data[bigInd - 1]);
//    System.out.println("Kirsten's Pivot Index: " + (bigInd - 1));
    return (bigInd - 1);
  }

  public static int quickselect (int[] data, int k) {
    return quickSelect(data, k, 0, data.length - 1);
  }

  private static int quickSelect(int[] data, int k, int start, int end) {
    if (start == end) {
      return data[k];
    }
    int resultInd = partition(data, start, end);
    if (resultInd < k) {
      System.out.println(toString(data));
      return quickSelect(data, k, resultInd + 1, data.length - 1);
    }
    else {
      System.out.println(toString(data));
      return quickSelect(data, k, 0, resultInd - 1);
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
