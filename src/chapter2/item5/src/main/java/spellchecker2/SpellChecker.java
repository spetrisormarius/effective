package spellchecker2;

import java.util.List;

// Inappropriate use of singleton - inflexible & untestable!
public class SpellChecker {
    //private final Lexicon dictionary = ;
    private SpellChecker() {}
    public static SpellChecker INSTANCE  = new SpellChecker();
    public boolean isValid(String word) {
        return false;
    }
    public List<String> suggestions(String typo) {
        return null;
    }
}
