public class PalindromeNumber {
    public static void main(String[] args) {
        int rest,sum=0,temp;
        int n = 454;//It is the number variable to be checked for palindrome

        temp = n;
        while ( n > 0 ){
            rest = n % 10;  //getting remainder
            sum = ( sum * 10 ) + rest;
            n = n / 10;
        }
        if( temp == sum )
            System.out.println(" palindrome number ");
        else
            System.out.println("not palindrome");
    }
}