import java.io.*;
import java.util.*;
public class Quick {
  private static Random r = new Random();

  public static int partition (int [] data, int start, int end){
//    System.out.println(toString(data));
    //Random r = new Random();
    int index = r.nextInt(end - start + 1) + start;
//    System.out.println("RandomIndex: " + index);
    int pivot = data[index];
//    System.out.println("PivotValue: " + pivot);
    data[index] = data[start];
    data[start] = pivot;

    int storage = 0;
    int fiftyChance = 0;
//    System.out.println("Initial move of P to the front: " + toString(data));
    int bigInd = start + 1;

    for (int toScan = start + 1; toScan <= end; toScan++) {
      fiftyChance++;
      if (data[toScan] > pivot) {
      }
      else {
        if (data[toScan] < pivot || fiftyChance % 2 == 0) {
          storage = data[bigInd];
          data[bigInd] = data[toScan];
          data[toScan] = storage;
          bigInd++;
        }
      }
    }
    storage = data[bigInd - 1];
    data[bigInd - 1] = data[start];
    data[start] = storage;

//    System.out.println("DEBUG: Moved back into pivot spot" + toString(data));
//    System.out.println("BigInd: " + bigInd);
//    System.out.println("PivotValue: " + data[bigInd - 1]);
//   System.out.println("Kirsten's Pivot Index: " + (bigInd - 1));
    return (bigInd - 1);
  }

  public static int quickselect (int[] data, int k) {
    return quickSelect(data, k, 0, data.length - 1);
  }

  private static int quickSelect(int[] data, int k, int start, int end) {
//    System.out.println("Start --> " + start + " end --> " + end);
    int resultInd = partition(data, start, end);

    if (resultInd == k) {
//      System.out.println("0.After Initial Partition " + toString(data));
//      System.out.println("0.Returned Index: " + resultInd);
      return data[k];
    } 
    if (resultInd < k) {
//      System.out.println("1.After Initial Partition " + toString(data));
//      System.out.println("1.Returned Index: " + resultInd);
      return quickSelect(data, k, resultInd + 1, end);
    }
    else {
//      System.out.println("2.After Initial Partition " + toString(data));
//      System.out.println("2.Returned Index: " + resultInd);
      return quickSelect(data, k, start, resultInd - 1);
    }
  }

  public static void quicksort(int[] data){
    quicksort(data, 0, data.length - 1);
  }

  private static void quicksort(int[] data, int lo, int hi) {
    if (lo < hi) {
      int p = partition(data, lo, hi);
      quicksort(data, lo, p - 1);
      quicksort(data, p + 1, hi);
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
