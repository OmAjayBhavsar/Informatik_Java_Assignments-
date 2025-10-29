import java.util.*;
public class PrimeTwins {
    public static int [][] primeTwins(int amount) {
        int[][] array = new int[amount][2];
        int integer = 0;
        for(int i = 3; amount > 0; i = i+2){
            if(is_prime(i) && is_prime(i+2)){
                array [integer][0] = i;
                array [integer][1] = i+2;
                amount--;
                integer++;
            }
        }
        return array;
    }
    public static boolean is_prime(int number) {
        int temp = 0;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                temp++;
                break;
            }
        }
        return temp == 0;
    }

    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of n to generate n twin prime pairs := ");
        int number = scanner.nextInt();
        System.out.println("The first " + number +" twin prime pairs are := ");
        System.out.println(java.util.Arrays.deepToString(primeTwins(number)));
    }

}

