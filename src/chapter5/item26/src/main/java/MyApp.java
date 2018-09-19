import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MyApp {

    // Fails at runtime - unsafeAdd method uses a raw type (List)!
    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // Has compiler-generated cast

    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    // Use of raw type for unknown element type - don't do this!
    static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;

        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;

        //Class a =  int.class;

//        // Legitimate use of raw type - instanceof operator
//        if (o instanceof Set) { // Raw type
//            Set<?> s = (Set<?>) o; // Wildcard type
//        }

        return result;
    }

}
