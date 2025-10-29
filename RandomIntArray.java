// This solution is presented by Om Ajay Bhavsar and Harshvardhan Yakkanti as a team.
public class RandomIntArray {
    public static int[] createRandom(int n) {
        int[] array = new int[n];
        int max = 99;
        int min = 5;
        for (int i = 0; i<array.length; i++){
            array[i] =(int)((Math.random()*(max-min))+min);
        }
        return(array);
    }
    public static String toString(int[] a) {
        StringBuilder string= new StringBuilder(" ");
        for(int i = 0; i<a.length; i++){            // Start processing the current element 'a[i]'
                                                    // Continue processing until 'a[i]' becomes zero
            while(a[i] != 0){                       // Calculate the rightmost digit of 'a[i]' using the modulo operator
                int rest = a[i] % 10;               // take the rightmost digit from 'a[i]' by modulo 10
                                                    // Convert the digit to its character representation and prepend it to 'string'
                                                    // (ASCII value of '0' is 48, so we add 'rest' to it to get the character representation)
                string.insert(0, (char) (48 + rest));
                a[i] /= 10;                         // Remove the rightmost digit from 'a[i]' by dividing it by 10
            }
        }
        return (string.toString());
    }
    public static int posMin(int[] a) {
        int minimum=0;                              // Initialize minimum to 0 (the first index).
        for (int i =0; i<a.length-1;i++) {          // Start the loop from index 1.
            if (a[minimum] > a[i]){                 // Compare the current element with the minimum.
                minimum = i;                        // Update the minimum index if a smaller element is found.
            }
        }
        return(minimum);
    }
    public static void swap(int[] a) {
        int temp = a[0];
        a[0]=a[a.length-1];                            // Set the value of the first element to the value of the last element
        a[a.length-1]= temp;                           // Set the value of the last element to the original value of the first element
        System.out.println("After swapping : ");
                                                       // Loop through the elements of the array 'a' and print each element of array
        for (int j : a) {
            System.out.println(j);
        }
    }
    public static void main(String[] args) {
        int n = 6;
        int[] a = createRandom(n);
        for (int j : a) {
            System.out.println(j);
        }
        System.out.println("Position of min a = " + posMin(a));
        swap(a);
        System.out.println("Swapped string = " + toString(a));

    }
}