public abstract class Present {
    static int counter = 0;

    protected Present() {
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    abstract double surface();

    double computePaperSize() {
        double surfaceArea = surface();
        double wastage = 0.6 * surfaceArea;
        // total area required for wrapping present
        double totalArea = surfaceArea + wastage;
        // rounds off to the closest, greater than or equal to, value of the input to give an integer
        // example Math.ceil(3.3) => 4.0
        // but if mul by 2 and divided by 2.0 then it gives value closer to 0.5
        // example Math.ceil((3.3*2)/2.0) => 3.5
        return Math.ceil(totalArea * 2) / 2.0;
    }

    public String wrap() {
        double paperSize = computePaperSize();
        // format the paper size to two decimal places
        String formattedPaperSize = String.format("%.2f", paperSize);
        return toString() + " requires " + formattedPaperSize + " square meters of wrapping paper.";
    }
}