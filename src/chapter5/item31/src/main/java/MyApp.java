import java.util.Collection;
import java.util.List;
import java.util.Set;

public  class MyApp<E> {

    private E e;

    public void push(E e) {

    }

    public  E pop() {

    return e;
    }

    public  boolean isEmpty() {
        return true;
    }


    // pushAll method without wildcard type - deficient!
//    public void pushAll(Iterable<E> src) {
//        for (E e : src)
//            push(e);
//    }

    // Wildcard type for a parameter that serves as an E producer
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src)
            push(e);
    }

    // popAll method without wildcard type - deficient!
//    public void popAll(Collection<E> dst) {
//        while (!isEmpty())
//            dst.add(pop());
//    }

// PECS stands for producer-extends, consumer-super.

    // Wildcard type for parameter that serves as an E consumer
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty())
            dst.add(pop());
    }


    // Wildcard type for parameter that serves as an T producer
    //Do not use bounded wildcard types as return types
    public static <E> Set<E> union(Set<? extends E> s1,
                                   Set<? extends E> s2) {
        return null;
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        return  null;
    }

    public static <T extends Comparable<? super T>> T maxWithWild(
            List<? extends T> list) {
        return  null;
    }


    // Two possible declarations for the swap method
    public static <E> void swap(List<E> list, int i, int j)  {
        swapHelper(list, i, j);
    }

    public static void swap2(List<?> list, int i, int j) {
        //list.set(i, list.set(j, list.get(i))); dnc
    }


    // Private helper method for wildcard capture
    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }


    public static void main(String[] args) {

        MyApp<Number> myApp = new MyApp<>();

        MyApp<Integer> myApp1 = new MyApp<>();

        myApp.push(new Integer(1));

        Iterable<Integer> integers = null;
        myApp.pushAll(integers);


    }

}
