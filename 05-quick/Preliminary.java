import java.io.*;
import java.util.*;
public class Preliminary {

  public static int partition (int [] data, int start, int end){
    System.out.println(toString(data));

    Random r = new Random();
    int randIndex = r.nextInt(data.length);
    System.out.println("RandomIndex: " + randIndex);
    int pivot = data[randIndex];
    System.out.println("Pivot: " + pivot);

    int front = data[start];

    data[start] = pivot;
    data[randIndex] = front;

    System.out.println(toString(data));
    return 1;
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
