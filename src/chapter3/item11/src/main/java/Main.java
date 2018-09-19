//          Here is the contract, adapted from the Object specification :
//        • When the hashCode method is invoked on an object repeatedly during an
//        execution of an application, it must consistently return the same value,
//        provided no information used in equals comparisons is modified. This value
//        need not remain consistent from one execution of an application to another.
//        • If two objects are equal according to the equals(Object) method, then calling
//        hashCode on the two objects must produce the same integer result.
//        • If two objects are unequal according to the equals(Object) method, it is not
//        required that calling hashCode on each of the objects must produce distinct
//        results. However, the programmer should be aware that producing distinct
//        results for unequal objects may improve the performance of hash tables.

public class Main {

    // The worst possible legal hashCode implementation - never use!
    @Override public int hashCode() { return 42; }



}


