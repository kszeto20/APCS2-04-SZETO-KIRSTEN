import java.util.*;
import java.lang.*;
public class MyHeap {
  /*Swap the element at the provided index downward into the correct position.
  This will swap with the larger of the child nodes provided thatchild is larger.
  This stops when a leaf is reached, or neither child is larger.
 *@param size the number of heap elements in the data array.
         This is needed to allow a partially full array to be provided.
 *@precondition the children of data[index] are valid heaps.
 *@precondition index is between 0 and size-1 inclusive
 *@precondition size is between 0 and data.length inclusive.
 */
  public static void pushDown(int[]data, int size, int index) {
    System.out.println("Array: " + Arrays.toString(data) + " Size: " + size + " index: " + index);
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    int change = index;

    if (left < size) {
     if (data[left] > data[change]) {
       change = left;
       System.out.println("left changed");
     }
    }

   if (right < size) {
     if (data[right] > data[change]) {
       change = right;
       System.out.println("right changed");
     }
    }

    if (change != index) {
     int toChange = data[index];
     data[index] = data[change];
     data[change] = toChange;
     System.out.println("Changed Arr: " + Arrays.toString(data));
     System.out.println("Feeding in: \n" + Arrays.toString(data) + " " + size + " " + change);
     pushDown(data, size, change);
   }
 }

  /*Reorder the provided array to be a valid heap.
  *@param data is the array to be modified
  */
 //public static void buildHeap(int[]data)//We will discuss this today:
//Before moving onto the next two methods, you must thoughroughly test the pushDown() and buildHeap() commands!


 /*Swap the root node with the element at the provided index.
  *Then push the new root down, but not past the index that it swapped with.
  *@precondition: size is between 0 and data.length-1 inclusive.
  */
 //private static void remove(int[]data,int size)

 /*Sort the provided array
  *@param data is the array to be sorted
  */
 //public static void heapsort(int[]data)//We will discuss this next time!:

}
