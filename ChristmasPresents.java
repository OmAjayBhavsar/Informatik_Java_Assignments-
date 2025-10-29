public class ChristmasPresents {

    public static void main(String[] args) {
        Ball ball = new Ball(0.9);

        Cuboid cuboid = new Cuboid(1.2,3.4,5.6);

        Cylinder cylinder = new Cylinder(2.1,3.2);

        System.out.println(ball.wrap());
        System.out.println(cuboid.wrap());
        System.out.println(cylinder.wrap());
    }
}