import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));

//        Inheritance is appropriate only in circumstances where the subclass really is a
//        subtype of the superclass. In other words, a class B should extend a class A only if
//        an “is-a” relationship exists between the two classes.

    }
}
