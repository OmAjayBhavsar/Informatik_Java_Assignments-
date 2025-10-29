// Point class with 2 coordinates (x,y) implements Movable interface
class Point implements Movable {
    private int x;
    private int y;

    public Point(int p1, int p2) {
        this.x = p1;
        this.y = p2;
    }


    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    // √[(x2 − x1)^2 + (y2 − y1)^2]
    public double distance(Point p) {
        return Math.sqrt(Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }

    @Override
    public void translate(int dx, int dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}