//This solution is presented by Om Ajay Bhavsar and Harshvardhan Yakkanti as a team.
public class MedianOfThree {

    public static int median(int a, int b, int c) {
        if((a>=b && a<=c)||(a>=c&&a<=b)){
            return a;
        } else if ((b>=a && b<=c)||(b>=c&&b<=a)) {
            return b;
        } else {
            return c;
        }
    }


    public static int median2(int a, int b, int c) {

        int array[] = {a,b,c};
        int sortedArray[] = new int[array.length];
        int median = 0;
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            for (int j = 1 + i; j < array.length; j++){
                if (array[i]>array[j]){
                    temp = array[i];
                    array[i]= array[j];
                    array[j]=temp;
                }
            }
        }
        for (int i = 0; i< array.length; i++){
            sortedArray[i] = array[i];
            median = array[1];
        }
        return median;
    }


    public static void main(String[] args) {
        System.out.println("Median = " + median(11,33,25));
        System.out.println("Median = " + median2(788,870,550));
    }
}
