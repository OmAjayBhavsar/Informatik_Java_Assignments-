public class MonteCarlo {

    public static double pi(int iterations) {
        double inCircle = 0;
        for (int i = iterations; i > 0; i--) {     //running the simulations
            double x = Math.random();
            double y = Math.random();           //initializing the random coordinates
            if (x * x + y * y < 1) {
                inCircle++;                     //adds 1 when the point is in the circle
            }
        }
        System.out.println(4 * inCircle / iterations);  // *4 else you have pi/4
        return 4 * inCircle / iterations;
    }

    public static void goat(int iterations) {
        double prizeCount = 0;                  //counts how many times the candidate wins, if they stay at their first pick
        for (int i = iterations; i > 0; i--) {     //simulates the game
            double chance = Math.random();      //random number in [0,1)
            if (chance < 1.0 / 3) {                 //you randomly pick one of three doors so the chance is 33.333% for winning if you do not change
                prizeCount++;
            }
        }
        double b = prizeCount / iterations;       //wikipedia: "probabilities can be numerically described by the number of desired outcomes [/wins], divided by the total number of all outcomes [/simulations]"
        double a = 1 - b;                       //p(winning if you stay) + p(winning if you switch) must be 1, since winning, if you switch is equivalent to losing if you stay
        System.out.println("The chance of winning the prize, if the candidate switches is: ~ " + a + "%. If they don't switch the probability is: ~" + b + "%");
    }

    public static void twodice(int number) { //method for simulating dicing
        double counter = 0;
        double counter2 = 0;
        int Zahl = (int) (Math.random() * 6 + 1);          //creates random number between 1 and 6 aka rolling the dice
        for (int i = 0; i < number; i++) {                          //testing simulation for number of times
            int Zahl2 = (int) (Math.random() * 6 + 1);
            if (Zahl == 5) {                                         // if first number is true, rolls the dice again
                if (Zahl2 == 5) {                                    // if second number is also true, counts this try as success
                    ++counter;
                } else if (Zahl2 == 6) {
                    ++counter2;
                } else { Zahl=Zahl2;
                }
            }else Zahl=Zahl2;                           //makes it more efficient
        }
        double average = 0;
        double average2 = 0;

        if (counter != 0) {                                                        // to catch the case if counter=0
            average = number / counter;
            System.out.println(average + " times dicing to get two times 5");
        } else System.out.println("no success");

        if (counter2 != 0) {
            average2 = number / counter2;
            System.out.println(average2 + " times dicing to get 5 then 6");
        } else System.out.println("no success");

        if (average < average2) {
            System.out.println("two times 5 is faster");

        } else if (average > average2) {
            System.out.println("first 5 then 6 is faster");

        } else {
            System.out.println("they are the same");

        }
    }


    public static void main(String[] args) {
        String input;

        try {
            input = args[0];
            int n = Integer.parseInt(args[1]);
            if (n <= 0) {
                System.out.println("no simulation");
            } else if (input.equals("Pi") || input.equals("pi")) {
                pi(n);
            } else if (input.equals("Ziegenproblem") || input.equals("Zonk")) {
                goat(n);

            } else if (input.equals("Wuerfeln") || input.equals("Dice")) {
                twodice(n);
            }

        } catch (ArrayIndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("There is no input. Try Pi or Zonk or Wuerfeln with an int");
        } catch (NumberFormatException e) {
            System.out.println("the second input needs to be an int. Try Pi or Zonk or Dice with an int");
        }


    }
}
