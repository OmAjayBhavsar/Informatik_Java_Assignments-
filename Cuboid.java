public class Cuboid extends Present {
    private double length;
    private double width;
    private double height;

    Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return "Cuboid with dimensions " + length + " m x " + width + " m x " + height + " m";
    }

    // surface area of a cuboid = 2*(l*w+l*h+h*w)
    @Override
    public double surface() {
        return (2 * (length * width + length * height + width * height));
    }

}