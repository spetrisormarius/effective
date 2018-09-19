import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import inheritance.ColorPoint;
import inheritance.Point;

public class Main {
    public static void main(String[] args) {

        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        list.contains(s); //???

        inheritance.Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        System.out.println(  p.equals(cp) == cp.equals(p) ); //???

        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        inheritance.Point p2 = new inheritance.Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

        System.out.println( p1.equals(p3 ) ); // ???


    }

    @Override public boolean equals(Object o) {
        throw new AssertionError(); // Method is never called
    }

//    • Reflexive: For any non-null reference value x, x.equals(x) must return true.
//    • Symmetric: For any non-null reference values x and y, x.equals(y) must return
//            true if and only if y.equals(x) returns true.
//    • Transitive: For any non-null reference values x, y, z, if x.equals(y) returns
//        true and y.equals(z) returns true, then x.equals(z) must return true.
//    • Consistent: For any non-null reference values x and y, multiple invocations
//      of x.equals(y) must consistently return true or consistently return false,
//      provided no information used in equals comparisons is modified.
//   • For any non-null reference value x, x.equals(null) must return false.



//    Putting it all together, here’s a recipe for a high-quality equals method:
//1. Use the == operator to check if the argument is a reference to this object.
//    If so, return true. This is just a performance optimization but one that is worth
//    doing if the comparison is potentially expensive.
//2. Use the instanceof operator to check if the argument has the correct type.
//    If not, return false. Typically, the correct type is the class in which the method
//            occurs. Occasionally, it is some interface implemented by this class. Use an
//    interface if the class implements an interface that refines the equals contract
//            to permit comparisons across classes that implement the interface. Collection
//    interfaces such as Set, List, Map, and Map.Entry have this property.
//3. Cast the argument to the correct type. Because this cast was preceded by an
//    instanceof test, it is guaranteed to succeed.
// 4. For each “significant” field in the class, check if that field of the argument
//    matches the corresponding field of this object. If all these tests succeed, return
//            true; otherwise, return false. If the type in Step 2 is an interface, you
//    must access the argument’s fields via interface methods; if the type is a class,
//    you may be able to access the fields directly, depending on their accessibility

}
