import java.util.*;

public class PerfectShuffle {
    public static int[] interleave(int[] a1, int[] a2) {
        int[] array = new int[2 * a1.length];
        int character = 0;
        for (int i = 0; i < a1.length; i++) {
            array[2*i] = a1[i];
            //character++;
            array[2*i+1] = a2[i];
            //character++;
        }
        return (array);
    }

    public static int[] perfectShuffle(int[] a) {
        if (a.length % 2 != 0)
            return (a);
        int[] a1 = new int[a.length / 2];
        int[] a2 = new int[a.length / 2];
        System.arraycopy(a, 0, a1, 0, a1.length);
//        int character = a2.length;
//        for (int i = 0; i < a2.length; i++) {
//            a2[i] = a[character];
//            character++;
//        }
      /*
      int halfSize = a.length/2
      * for (i=0...){
      * a1[i]=a[i]
      * a2[i]=a[i+a1.length]
      * }*/
        System.arraycopy(a,a1.length,a2,0,a2.length);
        return (interleave(a1, a2));
    }

    public static int shuffleNumber(int n) {
        if (n % 2 != 0)
            return (-1);

        int[] tempArray = new int[n];
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            tempArray[i] = (int) (Math.random() * 10);
            array[i] = tempArray[i];
        }
        int count = 0, integer = 0;
        do {
            integer = 0;
            count++;
            array = perfectShuffle(array);
            for (int i = 0; i < n; i++) {
                if (tempArray[i] != array[i]) {
                    integer = 1; // we didn't reach original shuffle yet
                    break;
                }
            }
        }
        while (integer == 1); // if integer = 0 array is shuffled to original state. loop stops
        return count; // no of shuffle required in order to array return to its original state
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(interleave(new int[]{1, 2, 3}, new int[]{4, 5, 6})));
        System.out.println(Arrays.toString(perfectShuffle(new int[]{1, 2, 3, 4, 5, 6})));
        System.out.println(shuffleNumber(20));
    }
}