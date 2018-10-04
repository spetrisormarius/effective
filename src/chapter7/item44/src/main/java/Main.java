public class Main {

//    Now that Java has lambdas, best practices for writing APIs have changed considerably.
//    For example, the Template Method pattern [Gamma95], wherein a subclass
//    overrides a primitive method to specialize the behavior of its superclass, is far less
//    attractive. The modern alternative is to provide a static factory or constructor that
//    accepts a function object to achieve the same effect.



//    UnaryOperator<T> T apply(T t) String::toLowerCase
//    BinaryOperator<T> T apply(T t1, T t2) BigInteger::add
//    Predicate<T> boolean test(T t) Collection::isEmpty
//    Function<T,R> R apply(T t) Arrays::asList
//    Supplier<T> T get() Instant::now
//    Consumer<T> void accept(T t) System.out::println


}
