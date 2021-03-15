import java.io.*;
import java.util.*;
public class Preliminary {
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
