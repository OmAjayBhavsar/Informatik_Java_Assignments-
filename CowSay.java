public class CowSay {

    // Default width of the text box
    public static int feld = 40;

    public static String[] array;
    public static String text;

    // Default values of Eyes and Tongue
    public static String Augen = "oo";
    public static String Zunge = " ";


    public static void main(String[] args) {
        try {
            for (int k = 0; k < args.length; k++) {
                if (args[k].equals("-W")) {
                    // Sets the width of the text box
                    feld = Integer.parseInt(args[k + 1]);
                }
            }
            // Takes the input text
            text = args[args.length - 1];
            array = args;

            feld();

            kuh();

            // exception cases
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("No input means no moo!\nNulla vacca sine argumentum!");
        } catch (NumberFormatException e) {
            System.err.println("There went something wrong.");
        }
    }

    // Cow diagram is printed with the specific Text, Eyes and Tongue whenever kuh() method is called.
    public static void kuh() {
        System.out.println("   \\ ^__^\n" +
                "      \\  (" + augen() + ")\\_______ \n" +
                "         (__)\\       )\\/\\ \n" +
                "          " + Zunge + "  ||---W | \n" +
                "             ||    ||");

    }

    // Specific Eyes are determined based on the command line arguments whenever augen() method is called.
    public static String augen() {
        for (int j = 0; j < array.length; j++) {
            switch (array[j]) {
                // Various cases for different eye styles
                case "-b":
                    Augen = "==";
                    break;

                case "-d":
                    Augen = "XX";
                    Zunge = "U";
                    break;

                case "-g":
                    Augen = "$$";
                    break;

                case "-s":
                    Augen = "**";
                    Zunge = "U";
                    break;

                case "-t":
                    Augen = "--";
                    break;

                case "-w":
                    Augen = "00";
                    break;

                case "-p":
                    Augen = "@@";
                    break;

                case "-y":
                    Augen = "..";
                    break;
                // Prints the customized Eyes of Cow entered in the command line.
                case "-e":
                    System.out.print(array[j + 1]);
                    break;
                case "-T":
                    Zunge = "U";
                    break;

            }
        }
        return Augen;
    }

    // Prints the top and bottom borders of the text box
    public static void feld() {
        System.out.print(" ");
        for (int i = 0; i < feld; i++) {
            System.out.print("_");
        }
        System.out.println();

        text();

        System.out.print(" ");
        for (int i = 0; i < feld; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // This method prints the text entered in the command line.
    public static void text() {
        String[] text1 = text.split("(?!^)");
        int line = 0;
        //Saves zeile
        String save;
        String zeile = "";

        //If text is shorter than field
        if (text1.length < feld) {
            System.out.print("|" + text);
            for (int j = text1.length; j < feld; j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        } else {
            for (int i = 1; i <= text1.length; i++) {
                save = zeile;
                zeile = save + text1[i - 1];

                //k needed to count empty space in text Bubble
                int k = i;
                //Print when zeile the length of feld
                if ((i % feld == 0 || i == text1.length)) {

                    //For first row
                    if (line == 0) {
                        System.out.println("/" + zeile + "\\");

                    }

                    //For last line
                    if (i == text1.length && i / feld == line) {
                        System.out.print("\\" + zeile);
                        //If last text is shorter then feld
                        while (k % feld != 0) {
                            System.out.print(" ");
                            k++;
                        }
                        System.out.println("/");
                    }


                    //If line in the middle
                    if (line != 0 && (i != text1.length || k < text1.length))
                        System.out.println("|" + zeile + "|");
                    zeile = "";
                    line++;
                }
            }
        }
    }
}



