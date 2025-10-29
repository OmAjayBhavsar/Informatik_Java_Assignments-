public class Sieve {
    public static void Sieve(String[] input){
        try {                                               //see below(catch)
            int n = Integer.parseInt(input[0]);             //initializes int n with value of the first element of input array
            if (n <= 1){
                System.out.println("no primes out there");  //exception for a wrong input
            }
            else {                                          //actual algorithm/calculation starts here
                boolean prime[] = new boolean[n + 1];       //initializes another array which later assigns each number(index) its primality
                prime[0] = false;
                prime[1] = false;
                for (int i = 2; i <= n; i++) {              //all indices(>=2) are set true/prime at first, to be "sieved out" later
                    prime[i] = true;
                }

                for (int j = 2; j <= Math.sqrt(n); j++) {   //iterates over the array to sqrt(n); helps efficiency because j*j > n if j > sqrt(n)
                    if (prime[j]) {
                        System.out.println(j);                  //prints out the first prime
                        for (int k = j * j; k <= n; k += j) {   //sets all multiples of the prime to false starting at the square of the prime
                            prime[k] = false;                   //example: 3 is prime. 2*3 is already set to false. so starting at 3*3 is sufficient.
                        }
                    }
                }
                for (int l = (int) (Math.sqrt(n) + 1); l <= n; l++) {   //iterates over the numbers left out in the upper loop
                    if (prime[l]) {
                        System.out.println(l);                          //prints out the remaining primes
                    }
                }
            }
        } catch (NumberFormatException e) {                 //exception in case of an input that does not fit the integer format
            System.out.println("Not an int :(");
        } catch (ArrayIndexOutOfBoundsException indexOutOfBoundsException){
            System.out.println("There is no input");        //exception if no input at all is given
        }
    }
    public static void main(String[] args) {
        Sieve(new String[]{"20"});
    }
}