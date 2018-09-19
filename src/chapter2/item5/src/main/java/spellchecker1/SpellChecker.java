package spellchecker1;

import java.util.List;

// Inappropriate use of static utility - inflexible & untestable!
public class SpellChecker {
    //private static final Lexicon dictionary = ...;

    private SpellChecker() {} // Noninstantiable
    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String typo) {
        return null;
    }
}
