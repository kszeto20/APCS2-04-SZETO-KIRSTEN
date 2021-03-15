import java.io.*;
import java.util.*;
public class Quick {
  private static Random r = new Random();

  public static int partition (int [] data, int start, int end) {

    int index = r.nextInt(end - start + 1) + start;
    int pivot = data[index];

    data[index] = data[start];
    data[start] = pivot;

    int storage = 0;
    int fiftyChance = 0;
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
    return (bigInd - 1);
  }

  public static int quickselect (int[] data, int k) {
    return quickSelect(data, k, 0, data.length - 1);
  }

  private static int quickSelect(int[] data, int k, int start, int end) {
    int resultInd = partition(data, start, end);

    if (resultInd == k) {
      return data[k];
    }
    if (resultInd < k) {
      return quickSelect(data, k, resultInd + 1, end);
    }
    else {
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
