public class Merge {

  public static void mergesort(int data[]) {
    actualSort(data, 0, data.length - 1);
  }

  private static void mergeThat (int[] data, int lo, int middle, int hi) {
    // merge both sides
    int leftTotal = middle - lo + 1;
    int rightTotal = hi - middle;
    int[] left = new int[leftTotal];
    int[] right = new int[rightTotal];

    for (int i = 0; i < leftTotal; i++) {
      left[i] = data[lo + i];
    }
    for (int i = 0; i < rightTotal; i++) {
      right[i] = data[middle + i + 1];
    }

    int leftInitial = 0;
    int rightInitial = 0;

    int totalInitial = lo;

    while (leftInitial < leftTotal && rightInitial < rightTotal) {
      if (left[leftInitial] <= right[rightInitial]) {
        data[totalInitial] = left[leftInitial];
        leftInitial++;
      }
      else {
        data[totalInitial] = right[rightInitial];
        rightInitial++;
      }
      totalInitial++;
    }

    // extras
    while (leftInitial < leftTotal) {
      data[totalInitial] = left[leftInitial];
      leftInitial++;
      totalInitial++;
    }
    while (rightInitial < rightTotal) {
      data[totalInitial] = right[rightInitial];
      rightInitial++;
      totalInitial++;
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
