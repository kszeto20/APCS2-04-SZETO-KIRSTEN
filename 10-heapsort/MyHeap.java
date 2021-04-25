import java.util.*;
import java.lang.*;
public class MyHeap {
  public static void main (String[] args) {
    int testSize = 500;
    int[] test = new int[testSize];
    int[] copy = new int[testSize];
    Random r = new Random();
    int toAdd;
    for (int i = testSize - 1; i >= 0; i--) {
      toAdd = r.nextInt(101);
      test[i] = toAdd;
      copy[i] = toAdd;
    }
    System.out.println("Before: " + Arrays.toString(test));

    long startTime = System.currentTimeMillis();
    Arrays.sort(copy);
    long endTime = System.currentTimeMillis();
    long timeElapsed = endTime - startTime;
    System.out.println("Arrays.sort() Execution time in milliseconds: " + timeElapsed);
    System.out.println("Array: " + Arrays.toString(copy));
    startTime = System.currentTimeMillis();
    heapsort(test);
    endTime = System.currentTimeMillis();
    timeElapsed = endTime - startTime;
    System.out.println("My.sort() Execution time in milliseconds: " + timeElapsed);

    System.out.println("After: " + Arrays.toString(test));

    boolean match = true;
    for (int i = 0; i < testSize; i++) {
      if (test[i] != copy[i]) {
        match = false;
      }
      if (!match) {
        System.out.println("failed");
      }
    }
    System.out.println(match);
  }
  /*Swap the element at the provided index downward into the correct position.
  This will swap with the larger of the child nodes provided thatchild is larger.
  This stops when a leaf is reached, or neither child is larger.
 *@param size the number of heap elements in the data array.
         This is needed to allow a partially full array to be provided.
 *@precondition the children of data[index] are valid heaps.
 *@precondition index is between 0 and size-1 inclusive
 *@precondition size is between 0 and data.length inclusive.
 */
  private static void pushDown(int[]data, int size, int index) {
//    System.out.println("PDOWN ||||| Array: " + Arrays.toString(data) + " Size: " + size + " index: " + index);
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    int change = index;

    if (left < size) {
     if (data[left] > data[change]) {
       change = left;
//       System.out.println("left changed");
     }
    }

   if (right < size) {
     if (data[right] > data[change]) {
       change = right;
//       System.out.println("right changed");
     }
    }

    if (change != index) {
     int toChange = data[index];
     data[index] = data[change];
     data[change] = toChange;
     //System.out.println("Changed Arr: " + Arrays.toString(data));
//     System.out.println("PDOWN |||||| Feeding in: \n" + Arrays.toString(data) + " Size: " + size);
     pushDown(data, size, change);
   }
 }

  /*Reorder the provided array to be a valid heap.
  *@param data is the array to be modified
  */
  public static void buildHeap(int[]data){
//    System.out.println("DATA LENGTH: " + data.length);
//Before moving onto the next two methods, you must thoughroughly test the pushDown() and buildHeap() commands!
    for (int i = data.length / 2 - 1; i >= 0; i--) {
//      System.out.println("BHEAP |||||| Pushing Index: " + i + " || Value pushed: " + data[i]);
      pushDown(data, data.length, i);
    }
  }

 /*Swap the root node with the element at the provided index.
  *Then push the new root down, but not past the index that it swapped with.
  *@precondition: size is between 0 and data.length-1 inclusive.
  */
 private static void remove(int[]data,int size) {
   for (int i = size - 1; i >= 0; i--) {
     //System.out.println("i val: " + i);
     int toChange = data[0];
     data[0] = data[i];
     data[i] = toChange;
//     System.out.println("Valid: ");
/*
     for (int j = 0; j < size; j++) {
      System.out.println(data[j] + " ");
     }
*/
     size--;
     pushDown(data, size, 0);
   }
 }

 /*Sort the provided array
  *@param data is the array to be sorted
  */
 private static void heapsort(int[]data) {
//   System.out.println("Building the heap");
   buildHeap(data);
//   System.out.println("Removing --------------------");
   remove(data, data.length);
 }

}
