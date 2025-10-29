import java.util.Arrays;

public class BinarySearch {
    private static int needle;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(binarySearch2D(generateArray(5, 5), 19)));
        System.out.println(Arrays.toString(binarySearch2D(generateRandomArray(5, 5, 5, 500), 19)));
    }

    public static int[] binarySearch2D(int[][] haystack, int _needle) {
        needle = _needle;

        //in case needle is smaller or bigger than the first or last number in the matrix you get an error
        if (needle < haystack[0][0] || needle > haystack[haystack.length - 1][haystack[0].length - 1])
            return new int[]{-1, -1};

        //first searching for the correct line from 0 to number of lines-1
        //then searching for the correct column starting at the middle one
        return search(searchMatrix(haystack[0].length - 1, 0, haystack), haystack, haystack.length / 2);
    }

    //searches for the correct line in the matrix where needle is located at starting with the middle line
    public static int searchMatrix(int right, int left, int[][] haystack) {
        int middle = (right + left) / 2;

        //if middle is the line where needle is located at
        if (haystack[middle][0] <= needle && needle <= haystack[middle][haystack.length - 1]) {
            return middle;

            //if needle is in a line above middle; middle+1 is then the left border; using middle+1 because we already now that needle is not in the middle line
        } else if (haystack[middle][0] < needle) {
            return searchMatrix(right, middle + 1, haystack);

            //if needle is in a line underneath middle, m-1 is right border
        } else {
            return searchMatrix(middle - 1, left, haystack);
        }

    }

    //searches for the column number where needle is located at
    public static int[] search(int line, int[][] haystack, int middle) {

        //if needle is not ih the middle of the field we search for the correct column otherwise we already know it
        while (haystack[line][middle] != needle) {

            //if needle is bigger than the middle number we search the right side
            //in case we have a random array we also check if the next number is smaller than needle, otherwise needle is not part of the array
            // e.g. needle =19, [16,18,20]
            //19>18 but 19<20 -> needle not in array
            if (needle > haystack[line][middle]) {
                if (needle < haystack[line][middle + 1]) {
                    line = -2;
                    middle = -2;
                    break;
                }
                return search(line, haystack, (haystack.length + middle) / 2);
            }

            //in case needle is smaller than middle we search the left part and check if the previous number is bigger than needle
            if (needle < haystack[line][middle]) {
                if (needle > haystack[line][middle - 1]) {
                    line = -2;
                    middle = -2;
                    break;
                }
                return search(line, haystack, middle / 2);
            }
        }

        //returns the position of needle starting the column and row numbers at 1 instead of 0, so it is easier for the user to find on the sheet
        return new int[]{line + 1, middle + 1};
    }

    //generates Array with sorted numbers from 1 to k*m
    public static int[][] generateArray(int k, int m) {
        int number = 1;
        int[][] matrix = new int[k][m];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = number++;
            }
        }
        return matrix;
    }

    //generating an array with random numbers between high and low that are sorted
    public static int[][] generateRandomArray(int k, int m, int low, int high) {
        int[][] haystack = new int[k][m];

        //starting with low so the random numbers can´t be beneath it
        int number = low;

        //variable average describes the average distance between the numbers to fill the field from low to high
        //e.g. low=5, high=500 distance=high-low= 495
        //field with the dimension 5*5 -> 25 numbers needed
        //the average distance between two numbers is 20
        int average = (high - low) / (k * m) + 1;

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {

                // with this method the numbers at the beginning grow very fast and at the end basically not
                // int maxStep = high - number;
                //  number+=(int)(1.00001*Math.random()*maxStep);

                //this method grows the numbers to slowly
                // number+=(int)((Math.random()*(high-low))/(k*m*1.0));

                number += (int) (Math.random() * 2 * average);
                haystack[i][j] = number;
            }
        }
        return haystack;
    }
}
