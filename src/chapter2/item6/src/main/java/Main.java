public class Main {
    public static void main(String[] args) {
        //String s = new String("bikini"); // DON'T DO THIS!
        String s = "bikini";
    }

    // Hideously slow! Can you spot the object creation?
    private static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
}
