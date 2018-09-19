import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyApp {
    // Mixing generics and varargs can violate type safety!
    static void dangerous(List<String>... stringLists) {

        List<Integer> intList = Arrays.asList(1, 2, 3);

        Object[] objects = stringLists;

        objects[0] = intList; // Heap pollution

        String s = stringLists[0].get(0); // ClassCastException

        @SuppressWarnings("unchecked")
        List<String>[] lists = new ArrayList[1];

        // Arrays are covariant:


    }


    // UNSAFE - Exposes a reference to its generic parameter array!
    static <T> T[] toArray(T... args) {
        return args;
    }


//    This code allocates
//    an array of type Object[], which is the most specific type that is guaranteed to
//    hold these instances, no matter what types of objects are passed to pickTwo at the
//    call site. The toArray method simply returns this array to pickTwo, which in turn
//    returns it to its caller, so pickTwo will always return an array of type Object[].
//
// Added by me for clarity Object[] is not polimorphic. it wil lost its type due too erasure
    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return toArray(a, b);
            case 1: return toArray(a, c);
            case 2: return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }


    //throws a ClassCastException
    public static void main(String[] args) {
        //String[] attributes =  pickTwo("Good", "Fast", "Cheap");

        Object[] attributes2 =  pickTwo("Good", "Fast", "Cheap");


        //Object obj = new String();
        //Object[] obj = new String[2];
        //String[] str = (String[])obj;


    }

    // Safe method with a generic varargs parameter
    @SafeVarargs
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }
//    a generic varargs methods is safe if:
//      1. it doesn’t store anything in the varargs parameter array, and
//      2. it doesn’t make the array (or a clone) visible to untrusted code.



}
