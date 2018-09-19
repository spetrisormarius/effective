public class Main {

//    First, the class must document precisely the effects of overriding any method.
//    In other words, the class must document its self-use of overridable methods.
//    For each public or protected method, the documentation must indicate which
//    overridable methods the method invokes, in what sequence, and how the results of
//    each invocation affect subsequent processing. (By overridable, we mean nonfinal
//    and either public or protected.) More generally, a class must document any
//    circumstances under which it might invoke an overridable method. For example,
//    invocations might come from background threads or static initializers.


//    To allow programmers to write efficient subclasses without undue pain, a
//    class may have to provide hooks into its internal workings in the form of judiciously
//            chosen protected methods or, in rare instances, protected fields.

//    You can eliminate a class’s self-use of overridable methods mechanically,
//    without changing its behavior. Move the body of each overridable method to a
//    private “helper method” and have each overridable method invoke its private
//    helper method. Then replace each self-use of an overridable method with a direct
//    invocation of the overridable method’s private helper method.

}
