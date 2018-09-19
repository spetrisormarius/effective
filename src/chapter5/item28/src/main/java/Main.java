import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        // Why generic array creation is illegal - won't compile!
//        List<String>[] stringLists = new List<String>[1]; // (1)
//
//        List<Integer> intList = Arrays.asList(42); // (2)
//
//        Object[] objects = stringLists; // (3)
//
//        objects[0] = intList; // (4)
//
//        String s = stringLists[0].get(0); // (5)

        List<?>[] stringLists = new List<?>[1]; // (1)

        List<?> test1 = new ArrayList<Integer>();



    }
}
