import java.util.EnumSet;
import java.util.Set;

public class Main {

    // Bit field enumeration constants - OBSOLETE!
    public class Text {
        public static final int STYLE_BOLD = 1 << 0; // 1
        public static final int STYLE_ITALIC = 1 << 1; // 2
        public static final int STYLE_UNDERLINE = 1 << 2; // 4
        public static final int STYLE_STRIKETHROUGH = 1 << 3; // 8
        // Parameter is bitwise OR of zero or more STYLE_ constants
        public void applyStyles(int styles) {  }
    }


    public static void main(String[] args) {
        //text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
    }


}

// EnumSet - a modern replacement for bit fields
class Text1 {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }
    // Any Set could be passed in, but EnumSet is clearly best
    public void applyStyles(Set<Style> styles) {  }

    public static void main(String[] args) {
        //text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }

}