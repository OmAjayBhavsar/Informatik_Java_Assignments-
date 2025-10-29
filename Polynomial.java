public class Polynomial {
    private int degree;
    private double[] coeffs;

    public Polynomial(double[] c) {
        coeffs = c;
    }

    public int getDegree() {
        int count = 0;
        for (double coefficients : coeffs) {
            if (coefficients == 0.0) // counts if coefficient = 0
                count++;
        }
        // copies non-zero coeff from the original array to the new array, removing zero coeff
        double[] newArray = new double[coeffs.length - count];
        for (int i = 0, k = 0; i < coeffs.length; i++) {
            if (coeffs[i] == 0) {
            } else
                newArray[k++] = coeffs[i];
        }
        // degree is one less than array indices
        degree = newArray.length - 1;
        return degree;
    }

    public double[] getAllCoefficients() {
        return coeffs;
    }

    public double getCoefficient(int i) {
        if (i >= 0)
            return coeffs[i];
        else
            return 0;
    }

    public String toString() {
        // removes trailing zero coeffs
        int count = 0;
        for (int j = 0; j < coeffs.length; j++) {
            if (coeffs[j] == 0.0)
                count++;
        }
        // copies array in new array eliminating zero coeffs
        double[] newArray = new double[coeffs.length - count];
        for (int j = 0, k = 0; j < coeffs.length; j++) {
            if (coeffs[j] == 0) {
            } else
                newArray[k++] = coeffs[j];
        }
        this.coeffs = newArray; // updates static coeffs to new array coeffs without zeros

        String poly = "";
        int temp = this.getDegree();
        // concatenates terms : from the highest degree term and moves to constant
        for (int i = coeffs.length - 1; i >= 0; i--) {
            poly = coeffs[i] + "*x^" + temp + poly;
            if (temp > 0)
                poly = " + " + poly;
            temp--;
        }
        return poly;
    }

    public double evaluate(double x) {
        double Sum = 0;
        double Multiply = 1;
        int tempDegree = this.getDegree();
        if (tempDegree == 0) {
            return coeffs[0];
        } else {
            // Horner's method for polynomial evaluation
            // starting from the highest degree
            Sum += coeffs[tempDegree] * x;
            for (int i = tempDegree - 1; i > 0; i--) {
                Sum = Sum + coeffs[i];
                Multiply = Sum * x;
                Sum = Multiply;
            }
            Sum = Sum + coeffs[0];
            return Sum;
        }
    }

    public Polynomial differentiate() {
        //temporary arrays
        double[] temp = new double[coeffs.length - 1];
        double[] temp2 = new double[coeffs.length];
        int tempDegree = this.getDegree();
        //copy coeffs to temp2
        System.arraycopy(coeffs, 0, temp2, 0, coeffs.length);
        //until j > 0, calculates the derivative starting from second to last coeff
        for (int i = coeffs.length - 2, j = coeffs.length - 1; j > 0; i--, j--) {
            temp[i] = temp2[j] * tempDegree;
            tempDegree = tempDegree - 1;
        }
        // stores the updated coeffs in temp
        this.coeffs = temp;
        return this;
    }

    public static void main(String[] args) {

        double[] c = {2.0, 0.0, -2.0, 5.0, 3.0, 7.0};
        Polynomial string = new Polynomial(c);
        string.getDegree();
        string.getAllCoefficients();
        System.out.println(string.getCoefficient(4));
        System.out.println(string);
        System.out.println(string.evaluate(2));
        System.out.println(string.differentiate());
    }
}
