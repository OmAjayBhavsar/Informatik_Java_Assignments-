// Line class with 2 points (start, end) implements movable interface
class Line implements Movable {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() {
        return this.start;
    }

    public Point getEnd() {
        return this.end;
    }

    public double length() {
        return start.distance(end);
    }

    @Override
    public void translate(int dx, int dy) {
        start.translate(dx, dy);
        end.translate(dx, dy);
    }

    @Override
    public String toString() {
        return "Line(" + start + "," + end + ")";
    }
}