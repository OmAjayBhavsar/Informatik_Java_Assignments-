// This solution is presented by Om Ajay Bhavsar and Harshavardhan Yakkanti as a team.
public class DecimalToDual {

    public static String transformDual(int dec) {
        String rest = "";
        String reverseString = "";
        int integer = 0;
        char character;

        while (dec > 0) {
            integer = dec % 2;
            rest = rest + integer ;
            dec /= 2;
        }
        for (int i = 0; i<rest.length(); i++){
            character = rest.charAt(i);
            reverseString = character + reverseString;
        }
        return reverseString;
    }

    public static void main(String[] args) {
        System.out.println("Dual = "+transformDual(13));
    }
}