public class Merge {

  public static void mergeSort(int data[]) {

    //// girl we gotta fix this
    actualSort(data, 0, data.length - 1);
  }





  private static void actualSort (int[] data, int lo, int hi) {
    // middle is inclusive

    if (lo < hi) {
      int middle = ((hi - 1) / 2) + lo;
      System.out.println("left || upper " + middle + " val at mid: " + data[middle]);
      actualSort(data, lo, middle - 1);
      System.out.println("right || lower " + (middle + 1) + " val at mid: " + data[middle + 1]);
      actualSort(data, middle, hi);
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
