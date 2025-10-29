/*
* Tree recursion of fib1(5) :=
*                                              fib1(5)
*                                            /         \
*                                      fib1(4)          fib1(3)
*                                    /         \      /         \
*                               fib1(3)    fib1(2)   fib1(2)   fib1(1)
*                               /       \/        \/         \/        \
*                          fib1(2)    fib(1) ... fib1(1) ... fib1(1)   fib1(0)
*                          /     \
*                     fib1(1)    fib1(0)
*                      /
*                   fib1(0)
* */

import java.math.BigInteger;

public class BigIntegerFibonacci {
    static long fib1Count = 0;
    static long fib2Count = 0;
    public static BigInteger fib1(int n) {
        fib1Count++;
        BigInteger x = BigInteger.valueOf(n);
        if (x.equals(BigInteger.ZERO) || x.equals(BigInteger.ONE)) {
            return BigInteger.valueOf(1);
        } else {
            return fib1(n - 1).add(fib1(n - 2));
        }
    }

    public static BigInteger fib2(int n) {
        fib2Count++;
        BigInteger num1 = BigInteger.valueOf(1);
        BigInteger num2 = BigInteger.valueOf(1);
        for (int i = 1; i < n; i++) {
            BigInteger num3 = num2;
            num2 = num2.add(num1);
            num1 = num3;
            System.out.println("num3= "+num3);
            System.out.println("num2= "+num2);
            System.out.println("num1= "+num1);
        }
        return num2;
    }

    public static void main(String[] args) {
        int n = 23;
        System.out.println("The first " + n + " Fibonacci numbers are := ");
        for (int i = 0; i < n; i++) {
            BigInteger fibonacciNumber = fib1(i);
            System.out.println("F(" + i + ") = " + fibonacciNumber);
        }
        System.out.println("The " + n + "th Fibonacci numbers is := " + fib1(n));
        System.out.println("Total calls to fib1 := " + fib1Count);
        System.out.println("The " + n + "th Fibonacci numbers is := " + fib2(n));
        System.out.println("Total calls to fib2 := " + fib2Count);
    }
}

