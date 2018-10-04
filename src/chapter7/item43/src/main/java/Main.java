import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> map = null;
        String key = null;
        map.merge(key, 1, (count, incr) -> count + incr);

        map.merge(key, 1, Integer::sum);


        //Static
        //Integer::parseInt;  //str -> Integer.parseInt(str)

        //Bound
        // Instant.now()::isAfter Instant then = Instant.now();
        //t -> then.isAfter(t)
        //Unbound String::toLowerCase str -> str.toLowerCase()
        //Class Constructor TreeMap<K,V>::new () -> new TreeMap<K,V>
        //Array Constructor int[]::new len -> new int[len]


    }
}
