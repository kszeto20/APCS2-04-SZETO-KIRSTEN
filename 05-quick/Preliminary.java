import java.io.*;
import java.util.*;
public class Preliminary {

  public static int partition (int [] data, int start, int end){
//    System.out.println(toString(data));

    Random r = new Random();
    int index = r.nextInt(end - start) + start;
//    System.out.println("RandomIndex: " + index);
    int pivot = data[index];
//    System.out.println("Pivot: " + pivot);
    int front = data[start];
    data[start] = pivot;
    data[index] = front;
    int bigInd = start + 1;

    for (int toScan = start + 1; toScan < end; toScan++) {
      if (data[toScan] < pivot) {
        int storage = data[bigInd];
        data[bigInd] = data[toScan];
        data[toScan] = storage;
        bigInd++;
      }
      else if (data[toScan] > pivot) {
      }
    }

    int temp = data[bigInd - 1];
    data[bigInd - 1] = data[start];
    data[start] = temp;
//    System.out.println(toString(data));
//    System.out.println("BigInd: " + bigInd);
//    System.out.println("Pivot: " + data[bigInd - 1]);
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
