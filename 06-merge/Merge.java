public class Merge {

  public static void mergeSort(int data[]) {

    //// girl wtf we gotta fix this
    actualSort(data, 0, data.length - 1);
  }

  private static void mergeThat (int[] data, int lo, int middle, int hi) {
    int[] temp = new int[hi - lo + 1];
    // merge both sides

    int leftInitial = lo;
    int rightInitial = middle + 1;

    int totalInitial = 0;

    while (leftInitial <= rightInitial && rightInitial <= hi) {
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
    if (leftInitial <= rightInitial) {
      temp[totalInitial] = data[leftInitial];
      totalInitial++;
      leftInitial++;
    }
    else if (rightInitial < hi) {
      temp[totalInitial] = data[rightInitial];
      totalInitial++;
      rightInitial++;
    }


    for (int h = lo; h < hi; h++) {
      data[h] = temp[h - lo];
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
