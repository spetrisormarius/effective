import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.Stream;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        // Uses the streams API but not the paradigm--Don't do this!
        //
//        Map<String, Long> freq = new HashMap<>();
//        File file = new File( "");
//        try (
//
//                Stream<String> words = new Scanner(file).tokens()) {
//            words.forEach(word -> {
//                freq.merge(word.toLowerCase(), 1L, Long::sum);
//            });
//        }


        // Proper use of streams to initialize a frequency table
//        Map<String, Long> freq;
//        try (Stream<String> words = new Scanner(file).tokens()) {
//            freq = words
//                    .collect(groupingBy(String::toLowerCase, counting()));
//        }

        // Pipeline to get a top-ten list of words from a frequency table
        Map<String, Integer> freq = new HashMap<>();
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .collect(toList());

    }

//
//    // Using a toMap collector to make a map from string to enum
//    private static final Map<String, Operation> stringToEnum =
//            Stream.of(values()).collect(
//                    toMap(Object::toString, e -> e));


}
