public class HappyNumbers {
    public static void main(String[] args) {
        int number = 99999123;
        boolean isHappy = isHappy(number);
        if (isHappy){
            System.out.println(number+ " is happy number");
        } else {
            System.out.println(number + " is not happy number");
            System.out.println(nextHappyNumber(number) + " is the next happy number");
        }
    }

    public static boolean isHappy(int n) {
        int num = 0;
        int sum = 0;
        if (n < 9)
            n = n * n;
        sum = n;

        while (n > 9) {
            sum = 0;
            while (n != 0) {
                num = n % 10;
                sum = sum + (num * num);
                n = n / 10;
            }
            n = sum;
        }
        if (sum == 1){
            return true;
        }
        return false;
    }

    public static int nextHappyNumber(int n){
        for (int i = n+1 ; ; i++){
            boolean isHappy = isHappy(i);
            if (isHappy == true){
                return (i);
            }
        }
    }
}



