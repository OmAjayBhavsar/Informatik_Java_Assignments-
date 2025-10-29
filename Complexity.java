public class Complexity {
    public static void main(String[] args) {
        System.out.println("Tabelle der Komplexitäten");
        System.out.println("ein Rechenschritt: 1 Nanosekunde (10^(-9)sec)");
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", // %10s --> String mit 10 Zeichen, rechtsbündig, links mit Leerzeichen aufgefüllt
                        "k", "ldn", "n", "n*ldn", "n^2", "n^3", "2^n"));
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", 1, "1 ns", "2 ns", "2 ns", "4 ns", "8 ns", "4 ns"));
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", 2, "2 ns", "4 ns", "8 ns", "16 ns", "64 ns", "16 ns"));
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", 3, "3 ns", "8 ns", "24 ns", "64 ns", "512 ns", "256 ns"));
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", 4, "4 ns", "16 ns", "64 ns", "256 ns", "4 µs", "66 µs"));
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", 5, "5 ns", "32 ns", "160 ns", "1 µs", "33 µs", "4 s"));
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", 6, "6 ns", "64 ns", "384 ns", "4 µ", "262 µs", "585 Years"));
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", 7, "7 ns", "128 ns", "896 ns", "16 µs", "2 ms", "1*10^20 Centuries"));
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", 8, "8 ns", "256 ns", "2 µs", "66 µs", "17 ms", "4*10^58 Centuries"));
        System.out.println(
                String.format("%s%10s%10s%10s%13s%13s%20s", 9, "9 ns", "512 ns", "5 µs", "262 µs", "134 ms", "4*10^135 Centuries"));
    }

}
