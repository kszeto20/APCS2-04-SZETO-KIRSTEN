public class Merge {

  public static void mergeSort(int data[]) {
    actualSort(data, 0, data.length - 1);
  }

  private static void mergeThat (int[] data, int lo, int middle, int hi) {
    int[] temp = new int[(hi - lo) + 1];
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

    for (int i = lo; i <= hi; i++) {
      data[i] = temp[i - lo];
    }
  }
  private static void actualSort (int[] data, int lo, int hi) {
    // middle is inclusive

    if (lo < hi) {
      int middle = (lo + hi) / 2;
      actualSort(data, lo, middle);
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
