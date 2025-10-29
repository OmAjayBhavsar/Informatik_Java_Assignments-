/**************************************
 * 2) 1024, 65536, 65536
 * 3) High computational time - Highly complex. Hard to compute large numbers.
 *    Stack overflow - deep recursive calls and each call consumes memory on stack
 *    Computation limits - has practical limits to how large a number can be handled efficiently
 ***********************************************/

import java.math.BigInteger;

public class AckermannFunction {
    public static BigInteger ackermann(BigInteger x, BigInteger y) {
        BigInteger answer;
        if (y.equals(BigInteger.ZERO)) {
            answer = BigInteger.ZERO;
        } else if (x.equals(BigInteger.ZERO)) {
            answer = BigInteger.TWO.multiply(y);
        } else if (y.equals(BigInteger.ONE)) {
            answer = BigInteger.TWO;
        } else {
            answer = ackermann(x.subtract(BigInteger.ONE), ackermann(x, y.subtract(BigInteger.ONE)));
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Answer is := " + ackermann(BigInteger.valueOf(1), BigInteger.valueOf(10)));
        System.out.println("Answer is := " + ackermann(BigInteger.valueOf(2), BigInteger.valueOf(4)));
        System.out.println("Answer is := " + ackermann(BigInteger.valueOf(3), BigInteger.valueOf(3)));
        System.out.println(ackermann(BigInteger.valueOf(5), BigInteger.valueOf(6)));
    }
}