public class Cylinder extends Present {
    private double height;
    private double radius;

    Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }

    public String toString() {
        return "Cylinder with height " + height + " m and radius " + radius + " m";
    }

    //surface area of cylinder = 2*(pi)*r*(r+h)
    @Override
    public double surface() {
        return 2 * Math.PI * radius * (radius + height);
    }
}