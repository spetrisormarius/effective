
public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
    String s;
    public int compareTo(CaseInsensitiveString cis) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, cis.s);
        }
}
