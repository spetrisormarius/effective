import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public class Main {

    //Template
    //Method pattern


    // Concrete implementation built atop skeletal implementation
    static List<Integer> intArrayAsList(int[] a) {
        Objects.requireNonNull(a);
// The diamond operator is only legal here in Java 9 and later
// If you're using an earlier release, specify <Integer>
        return new AbstractList<Integer>() {
            @Override public Integer get(int i) {
                return a[i]; // Autoboxing (Item 6)
            }
            @Override public Integer set(int i, Integer val) {
                int oldVal = a[i];
                a[i] = val; // Auto-unboxing
                return oldVal; // Autoboxing
            }
            @Override public int size() {
                return a.length;
            }
        };
    }

    //Incidentally,
    //this example is an Adapter [Gamma95] that allows an int array to be viewed
    //as a list of Integer instances


//    The class implementing the interface can forward invocations of interface
//    methods to a contained instance of a private inner class that extends the skeletal
//            implementation. This technique, known as simulated multiple inheritance, is
//    closely related to the wrapper class idiom discussed in Item 18.


//    A minor variant on the skeletal implementation is the simple implementation,
//    exemplified by AbstractMap.SimpleEntry. A simple implementation is like a
//    skeletal implementation in that it implements an interface and is designed for
//    inheritance, but it differs in that it isn’t abstract: it is the simplest possible working
//    implementation. You can use it as it stands or subclass it as circumstances warrant.

}
