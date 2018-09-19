import java.util.Collection;

// A first cut at making Chooser generic - won't compile
public class Chooser<T> {
    private T[] choiceArray = null;
    public Chooser(Collection<T> choices) {

        //choiceArray = (T[]) choices.toArray();

        choiceArray = choices.toArray(choiceArray);
    }
// choose method unchanged

    // SAFE!!!
//    private final List<T> choiceList;
//    public Chooser(Collection<T> choices) {
//        choiceList = new ArrayList<>(choices);
//    }
//    public T choose() {
//        Random rnd = ThreadLocalRandom.current();
//        return choiceList.get(rnd.nextInt(choiceList.size()));
//    }
}