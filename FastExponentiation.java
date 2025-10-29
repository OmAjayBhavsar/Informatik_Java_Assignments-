/********************************************************
 x = 2 und x = 13
 x^13 = 8192.0

 13 is odd ,so 2*(2^(13-1)) = 8192.0;
 ********************************************************/

/* x^n
* n = 0 :: 1
* even = (x*x)^n/2
* odd = x*x^(n-1)
* */

public class FastExponentiation {
    private static int rekCount, iterCount = 0;
    public static double fastPotRek(double x, int n) {
        if (n == 0) {
            return 1;
        }
        else {
            rekCount++;
            return x * fastPotRek(x, n - 1);
        }
    }
    // Binary exponentiation method
    public static double fastPotIter(double x, int n) {
        double result = 1;
        while (n > 0) {
            iterCount++;
            if (n % 2 == 1) {
                result *= x; // result = 32 ; result = 32*256 => 8192
            }
                x *= x; // x = 16 ; x = 256 ;
                n /= 2; // n = 3 ; n = 1 ; n = 0
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fastPotIter(3, 13));
        System.out.println("Iterative Iterations count: " + iterCount);
        System.out.println(fastPotRek(3, 13));
        System.out.println("Recursive Iterations count: " + rekCount);

    }
}