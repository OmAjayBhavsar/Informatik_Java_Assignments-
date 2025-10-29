/**********************
 * Task 1: "Divide and Conquer"
 * a) sequence a = 5,3,4,7,1,2
 *
 *         {5, 3, 4, 7, 1, 2}
 *         /                \
 *     {5,3,4}              {7,1,2}                 Divide
 *      /    \                 /    \
 *    {5}   {3,4}            {7}   {1,2}
 *                   -----
 *    |       / \             |     /   \
 *    \    {3}  {4}           \   {1}   {2}         Conquer
 *     \       /               \    /
 *      {3,4,5}                 {1,2,7}
 *          \                   /
 *            {1,2,3,4,5,6,7}
 *
 * b) In merge sort method we keep dividing the array till the array only contains
 *    one element and then rebuild the array in sorted manner.
 *
 * Task 3: MergeSort ist Stable
 *  In a Stable sort the order of occurrence of elements is maintained through the
 *  sorting process whereas in an Unstable sort the order of occurrence of element
 *  changes
 *   Example:
 *                 {3,2,2'}
 *                  /    \
 *              {3}     {2,2'}
 *                      /    \
 *                    {2}    {2'}
 *
 *  Sorted Array : {2,2',3}
 */

import java.util.*;
public class MergeSort {

    public static <T> void mergeSort(T[] a, Comparator<T> c) {
        int length = a.length;
        if (length < 2) {
            return;
        }
        int midpoint = a.length / 2;
        if (a.length <= 1) return;
        // generate 2 temporary array
        T[] a0 = Arrays.copyOfRange(a, 0, a.length / 2); // elements from index 0 to mid
        T[] a1 = Arrays.copyOfRange(a, a.length / 2, a.length); // elements from index mid to a.lenght
        mergeSort(a0, c);
        mergeSort(a1, c);
        // mergeSort is called recursively till the length of the subarray < 2
        merge(a0, a1, a, c);
    }

    public static <T> void merge(T[] a0, T[] a1, T[] a, Comparator<T> c) {
        int i0 = 0, i1 = 0;
        for (int i = 0; i < a.length; i++) {
            // if a0 is empty or have been merged then take element from a1
            if (i0 == a0.length)
                a[i] = a1[i1++];
                // if a1 is empty or have been merged then take element from a0
            else if (i1 == a1.length)
                a[i] = a0[i0++];
            // compare the array and choose the smallest element from both the array
            else if (c.compare(a0[i0], a1[i1]) <= 0)
                a[i] = a0[i0++];
            else
                a[i] = a1[i1++];
        }
    }

    public static void main(String[] args) {
        Comparator<Integer> C = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b);
            }
        };
        Integer[] array = {5, 3, 2, 4, 1, 6};
        mergeSort(array, C);
            System.out.println("Sorted Array = " + Arrays.toString(array));
    }
}