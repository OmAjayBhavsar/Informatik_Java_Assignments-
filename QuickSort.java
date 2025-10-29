/*********************************************************
 1)
 0, 1, 2, 3, 4, 5, 6
 a = {5, 3, 4, 8, 7, 1, 2}

 i)
 Pivot Element p = 2

 ii)
 i=0 , j=5
 a[0] > p  if yes -> i = 0
 a[5] < p  if yes -> j = 5
 swap(a[0],a[5])
 New Array a = {1,3,4,8,7,5,2}

 iii)
 i = 1
 a[1] > p if yes -> i = 1
 j = 4
 a[4] < p if no
 j = 3
 a[3] < p if no
 j = 2
 a[2] < p if no
 j = 1
 a[1] < p if no
 j = i = 1
 swap(a[1],p)
 New Array a = {1,2,4,8,7,5,3}

 iv)
 Now let 3 be Pivot element in {4,8,7,5,3}
 {4,8,7,5,3}
 {3,8,7,5,4}
 New Array = {1,2,3,8,7,5,4}

 v)
 {8,7,5,4}
 {4,7,5,8}
 New Array = {1,2,3,4,7,5,8}

 vi)
 {7,5,8}
 {5,7,8}
 Sorted Array a = {1,2,3,4,5,7,8}

 2)
 Time Complexity in middle case = O(n log n)
 The pivot point has influence on number of comparisons (efficiency) of Quick Sort.

 Worst case -
 Worst case would be when the pivot point is either the smallest or the largest element
 in the array as result one side has no elements and the other side has all the elements
 except the pivot point element. Which has time complexity = O(n^2).
 **********************************************************/

public class QuickSort {
    static int swap;

    // initiate array with left being 0th element and right being the array.length-1 element
    public static <T extends Comparable<T>> void quickSort(T[] a) {
        quickSort(a, 0, a.length - 1);
    }

    //
    private static <T extends Comparable<T>> void quickSort(T[] a, int left, int right) {
        if (right > left) {
            int pivot = partition(a, left, right);
            // recursive call on left subarray to sort left partition
            quickSort(a, left, pivot - 1);
            // recursive call on right subarray to sort right partition
            quickSort(a, pivot + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int left, int right) {
        // pivot is right most element of the subarray
        T pivot = a[right];
        // mid is the left most index of subarray
        int mid = left;


        for (int i = mid; i < right; i++) {
            // is a[i] <= pivot then element is on the left side
            if (a[i].compareTo(pivot) <= 0) {
                // swam a[i] with mid
                swap(a, i, mid++);
            }
        }
        // pivot is swapped with element mid. this ensures that the
        // element <= pivot on left and element >= pivot on right
        swap(a, right, mid);

        // return position of pivot after partitioning
        return mid;
    }

    // helper method to swap elements in array
    private static <T extends Comparable<T>> void swap(T[] a, int b, int c) {
        if (b != c) {
            T temp = a[b];
            a[b] = a[c];
            a[c] = temp;
        }
    }
}