import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyApp {
    private Object[] elements;

    public static void main(String[] args) {

        Set<Integer> exaltation = new HashSet();

    }
    int size;

    public <T> T[] toArray(T[] a) {

        if (a.length < size) {
            // This cast is correct because the array we're creating
            // is of the same type as the one passed in, which is T[].
            @SuppressWarnings("unchecked")
            T[] result =
                    (T[]) Arrays.copyOf(elements, size, a.getClass());

            return result;
        }

        System.arraycopy(elements, 0, a, 0, size);

        if (a.length > size)
            a[size] = null;

        return a;
    }


}
