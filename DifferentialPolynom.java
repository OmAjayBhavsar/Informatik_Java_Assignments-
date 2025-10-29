import java.util.Arrays;
import java.util.Scanner;

public class DifferentialPolynom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Total number of coefficients in Equation := ");
        int totalCoefficients = scanner.nextInt();

        double[] coefficients = new double[totalCoefficients];
        System.out.println("Enter the values of coefficients");

        for (int i = 0; i < totalCoefficients; i++) {
            coefficients[i] = scanner.nextDouble();
        }
        System.out.print("The Coefficients Polynomial is= " + Arrays.toString(coefficients));
        System.out.print("\nThe differentiated Coefficients are= " + Arrays.toString(diffPoly(coefficients)));
    }

    public static double[] diffPoly(double[] coeffs) {
        int lenght = coeffs.length - 1;
        double[] diffCoeffs = new double[lenght];
        int power = 1;
        int temp = diffCoeffs.length;
        for (int i = 0; i < temp; i++) {
            diffCoeffs[i] = coeffs[i + 1] * power;
            power++;
        }
        return diffCoeffs;
    }
}