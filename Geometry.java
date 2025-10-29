
public class Geometry {
    public static void main(String[] args) {
        Point p1 = new Point(1, -2);
        Point p2 = new Point(-3, 4);

        Line line1_2 = new Line(p1, p2);

        Point p3 = new Point(5, -6);
        Point p4 = new Point(-7, 8);
        Point p5 = new Point(9, -10);

        Triangle triangle3_4_5 = new Triangle(p3, p4, p5);


//      Translation : Moved in a 2D coordinate system
        System.out.println("Before Translation: ");
        System.out.println(p1);
        System.out.println(line1_2);
        System.out.println(triangle3_4_5);

        p1.translate(2, -1);
        line1_2.translate(-4, 3);
        triangle3_4_5.translate(6, -5);

        System.out.println("\nAfter Translation");
        System.out.println(p1);
        System.out.println(line1_2);
        System.out.println(triangle3_4_5);

        System.out.println("\nLength between points p1 and p2: " + line1_2.length());

        System.out.println("\nDistance between point p2 and p3: " + p2.distance(p3));

        System.out.println("\nPerimeter of Triangle3_4_5: " + triangle3_4_5.perimeter());
    }
}