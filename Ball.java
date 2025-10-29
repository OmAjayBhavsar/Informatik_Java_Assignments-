public class Ball extends Present {
    private double radius;

    Ball(double radius) {
        this.radius = radius;
    }

    public String toString() {
        return "Ball with radius " + radius + " m";
    }

    // surface area of sphere = 4*(pi)*r^2
    @Override
    public double surface() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

}