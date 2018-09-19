package inheritance;

import java.awt.*;

public class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);

        this.color = color;
    }

    // Broken - violates symmetry!
//    @Override public boolean equals(Object o) {
//        if (!(o instanceof inheritance.ColorPoint))
//            return false;
//        return super.equals(o) && ((inheritance.ColorPoint) o).color == color;
//    }

    // Broken - violates transitivity!
//    @Override public boolean equals(Object o) {
//        if (!(o instanceof inheritance.Point))
//            return false;
//
//        // If o is a normal inheritance.Point, do a color-blind comparison
//        if (!(o instanceof inheritance.ColorPoint))
//            return o.equals(this);
//
//        // o is a inheritance.ColorPoint; do a full comparison
//        return super.equals(o) && ((inheritance.ColorPoint) o).color == color;
//    }

    // Broken - violates Liskov substitution principle (page 43)
    @Override public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass())
            return false;
        inheritance.Point p = (inheritance.Point) o;
        return p.x == x && p.y == y;
    }



}