// Triangle class with 3 points (a,b,c) implements Movable interface
class Triangle implements Movable {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point p1, Point p2, Point p3) {
        this.a = p1;
        this.b = p2;
        this.c = p3;
    }


    private Point getA() {
        return this.a;
    }

    private Point getB() {
        return this.b;
    }

    private Point getC() {
        return this.c;
    }

    private Point[] getPoints() {
        Point[] points = {a, b, c};
        return points;
    }

    public double perimeter() {
        return a.distance(b) + b.distance(c) + c.distance(a);
    }

    @Override
    public void translate(int dx, int dy) {
        a.translate(dx, dy);
        b.translate(dx, dy);
        c.translate(dx, dy);
    }

    @Override
    public String toString() {
        return "Triangle(" + a + ", " + b + ", " + c + ")";
    }
}