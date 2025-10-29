/*
This method allows the objects to be moved in the 2D plane
by a specified amount in the x and y directions.

This code in the Point class adjusts the x and y coordinates of the point (this.x and this.y)
based on the values of dx and dy, effectively moving the point by dx units horizontally
and dy units vertically.

*/

public interface Movable {
    void translate(int dx, int dy);
}

