public class Merge {

  public static void mergeSort(int data[]) {

    //// girl we gotta fix this
    actualSort(data, 0, data.length - 1);
  }

  private static void mergeThat (int[] data, int lo, int middle, int hi) {

    // right and left temp arrays to be made

    int left = (middle - lo) + 1;
    int right = (hi - middle);

    int[] L = new int[left];
    int[] R = new int[right];

    // put in both sides into temp arrays

    for (int i = 0; i < left; ++i) {
      L[i] = data[lo + i];
    }
    for (int j = 0; j < right; ++j) {
      R[j] = data[middle + 1 + j];
    }
    System.out.println("Left: " + toString(L));
    System.out.println("Right: " + toString(R));

    System.out.println(toString(L) + toString(R));

  }



  private static void actualSort (int[] data, int lo, int hi) {
    // middle is inclusive

    if (lo < hi) {
      int middle = ((hi - 1) / 2) + lo;
      System.out.println("left || upper " + middle + " val at mid: " + data[middle]);
      actualSort(data, lo, middle);
      System.out.println("right || lower " + (middle + 1) + " val at mid: " + data[middle + 1]);
      actualSort(data, middle + 1, hi);
      mergeThat(data, lo, middle, hi);
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

/*
private static void quicksort(int[] data, int lo, int hi) {
  if (lo < hi) {
    int p = partition(data, lo, hi);
    quicksort(data, lo, p - 1);
    quicksort(data, p + 1, hi);
  }
}
*/
