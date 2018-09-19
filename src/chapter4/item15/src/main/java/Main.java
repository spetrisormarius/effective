import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    // Potential security hole!
    public static final Integer[] VALUES = {  };

    private static final Integer[] PRIVATE_VALUES = {  };

    public static final List<Integer> VALUES2 =
        Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    public static final Integer[] values() {
        return PRIVATE_VALUES.clone();
    }


}
