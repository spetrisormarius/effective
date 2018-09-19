//The general contract for the clone method is weak. Here it is, copied from the
//Object specification :
//Creates and returns a copy of this object. The precise meaning of “copy” may
//depend on the class of the object. The general intent is that, for any object x,
//the expression
//    x.clone() != x
//will be true, and the expression
//    x.clone().getClass() == x.getClass()
//will be true, but these are not absolute requirements. While it is typically the
//case that
//    x.clone().equals(x)
//will be true, this is not an absolute requirement.
//By convention, the object returned by this method should be obtained by calling
//super.clone. If a class and all of its superclasses (except Object) obey
//this convention, it will be the case that
//    x.clone().getClass() == x.getClass().
//By convention, the returned object should be independent of the object being
//cloned. To achieve this independence, it may be necessary to modify one or
//more fields of the object returned by super.clone before returning it.

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Void> _void = new ArrayList<>();

    public static void main(String[] args) {
        test();

        // alternative to clone
        // Copy constructor
//         public Yum(Yum yum) { ... };
//        A copy factory is the static factory (Item 1) analogue of a copy constructor:
//        // Copy factory
//        public static Yum newInstance(Yum yum) { ... };

    }

    private static void test() {

        Number integer = new Integer(4);

        boolean b = integer.getClass() == new Integer(0).getClass();

    }

}


