import java.util.*;
public class Merge {

  public static void mergesort(int data[]) {
    int[] temp = new int[data.length];
    actualSort(data, temp, 0, data.length - 1);
  }

  private static void mergeThat (int[] data, int[] temp, int lo, int middle, int hi) {
    System.out.println("TEMP: " + Arrays.toString(temp));
    System.out.println("REAL: " + Arrays.toString(data));

    System.out.println("\n");
    System.out.println("lo: " + lo + " mid: " + middle + " hi: " + hi);
    System.out.println("\n");
    // merge both sides

    int leftInitial = lo;
    int rightInitial = middle + 1;

    int totalInitial = 0;

    while (leftInitial <= middle && rightInitial <= hi) {
      if (data[leftInitial] <= data[rightInitial]) {
        temp[totalInitial] = data[leftInitial];
        leftInitial++;
        totalInitial++;
      }
      else {
        temp[totalInitial] = data[rightInitial];
        rightInitial++;
        totalInitial++;
      }
    }

    // extras
    while (leftInitial <= middle) {
      temp[totalInitial] = data[leftInitial];
      leftInitial++;
      totalInitial++;
    }
    while (rightInitial <= hi) {
      temp[totalInitial] = data[rightInitial];
      rightInitial++;
      totalInitial++;
    }

    System.out.println("TEMP: " + Arrays.toString(temp));
    System.out.println("REAL: " + Arrays.toString(data));

    for (int i = lo; i <= hi; i++) {
      data[i] = temp[i - lo];
    }
  }
  private static void actualSort (int[] data, int[] temp, int lo, int hi) {
    // middle is inclusive

    if (lo < hi) {
      int middle = (lo + hi) / 2;
      System.out.println("left || upper " + middle + " val at mid: " + data[middle]);
      actualSort(data, temp, lo, middle);
      System.out.println("right || lower " + (middle + 1) + " val at mid: " + data[middle + 1]);
      actualSort(data, temp, middle + 1, hi);
      System.out.println("\n");
      mergeThat(data, temp, lo, middle, hi);
    }
  }
}
