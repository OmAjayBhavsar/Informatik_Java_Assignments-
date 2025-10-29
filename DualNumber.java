public class DualNumber {
    private double a;
    private double b;

    public DualNumber(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        if (a == 0) {
            if (b != 0) return b + "ϵ";
            else return "0";
        }
        if (b > 0) return (a + "+" + b + "ϵ");
        //prevents 10+-7ϵ
        if (b < 0) return (a + "" + b + "ϵ");
        //b zero
        return (a + "");
    }

    //static so that it can be called independently of existence of an instance of DualNumber class
    public static DualNumber ONE() {
        return new DualNumber(1, 0);
    }

    public DualNumber add(DualNumber z) {
        this.a += z.a;
        this.b += z.b;
        return this;
    }

    public DualNumber multiply(DualNumber z) {
        /*
        this: a+bϵ      z:    c+dϵ
        (a+bϵ)(c+dϵ)=ac+adϵ+bcϵ+bdϵ^2
        =ac+adϵ+bcϵ
        */
        double aTemp = this.a; //we need to remember one of the variables separately
        //because otherwise we would use this.a after we assigned a new value to it but actually want its original value
        //the new value of this.b depends on original this.a
        this.a = aTemp * z.a;
        this.b = aTemp * z.b + this.b * z.a;
        return this;
    }

    public DualNumber subtract(DualNumber z) {
        this.a -= z.a;
        this.b -= z.b;
        return this;
    }

    public DualNumber divide(DualNumber z) {
        //When a of the divisor is 0, no matter what the value of b is, the behaviour is same as dividing by 0
        //(since ϵ^2=0)
        if (z.a == 0) {
            throw new ArithmeticException("Division by zero");
        }
        /*similar approach to complex division: expand fraction with conjugate
        this: a+bϵ      z:    c+dϵ
         (a+bϵ)/(c+dϵ)=[(a+bϵ)(c-dϵ)]/[(c+dϵ)(c-dϵ)]
         =(ac-adϵ+bcϵ-bdϵ^2)/[c^2-(dϵ)^2]
         =(ac-adϵ+bcϵ)/(c^2)
         so result values:
         a'=a/c
         b'=[(bc-ad)/(c^2)]*ϵ
         */
        double aTemp = this.a;      //see at multiply
        this.a = aTemp / z.a;
        this.b = (this.b * z.a - aTemp * z.b) / (z.a * z.a);
        return this;
    }

    public DualNumber pow(int n) {
        if (n < 0) {
            //exponent law: x^-n=(1/x)^n
            DualNumber inverse = (ONE().divide(this));
            this.a = inverse.a;
            this.b = inverse.b;
            return this.pow(-n);
        }
        //result at start 1 representing z^0
        DualNumber result = new DualNumber(1, 0);
        //from FastExponentiation task:
        while (n > 0) {
            if (n % 2 == 0) {
                //n is even: square our dual number and halve 2
                this.multiply(this);
                n /= 2;
            } else {
                //n odd: decrement n and start multiplying our dual number (or squares (of squares of...) of our original)
                //on result to mimic x^odd=x*x^(odd-1)
                n--;
                result.multiply(this);
            }
        }
        this.a = result.a;
        this.b = result.b;
        return this;
    }

    public static void main(String[] args) {
        DualNumber num1 = new DualNumber(-3123, 3123);
        DualNumber num2 = new DualNumber(3120, -1);
        DualNumber num3 = new DualNumber(32, -132);
        System.out.println("num1: " + num1);
        System.out.println("num2: " + num2);
        System.out.println("num3: " + num3);
        System.out.println("Add: " + num1.add(num2));
        System.out.println("Mul: " + num1.multiply(num2));
        System.out.println("Sub: " + num1.subtract(num2));
        System.out.println("Pow: " + num1.pow(2));
        System.out.println("Div: " + num1.divide(num2.add(ONE())));
        System.out.println("Div: " + num1.divide(num2));
        DualNumber num4 = new DualNumber(0, 10);
        System.out.println(num2.divide(num4));
    }
}