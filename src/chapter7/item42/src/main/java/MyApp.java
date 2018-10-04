import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparingInt;

public class MyApp {
    public static void main(String[] args) {

        // Anonymous class instance as a function object - obsolete!
        List<String> words = new ArrayList<>();

        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        // Lambda expression as function object (replaces anonymous class)
        Collections.sort(words,
                (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        Collections.sort(words, comparingInt(String::length));

        words.sort(comparingInt(String::length));


    }
}
