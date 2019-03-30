import java.util.List;
import java.util.function.*;

/*
A functional interface is an interface that contains one and only one abstract method.
 */
public interface FunctionalInterface {

    long singleAbstractMethod(long x1, long x2);

    public static void main(String[] args) {

        FunctionalInterface functionalInterface = new FunctionalInterface() {
            @Override
            public long singleAbstractMethod(long x1, long x2) {
                return x1+x2;
            }
        };

        //intentional Blank Space
        //intentional Blank Space
        //intentional Blank Space
        //intentional Blank Space
        //intentional Blank Space
        //intentional Blank Space
        //intentional Blank Space
        //intentional Blank Space
        //intentional Blank Space
        //intentional Blank Space
        //intentional Blank Space

        /*
        * A lambda expression is an inline implementation of a functional interface,
         * eliminating the need of an anonymous class.
         */
        FunctionalInterface functionalInterface2 = (x1, x2) -> x1+x2;
        functionalInterface2.moreMethods();

        System.out.println(functionalInterface2.singleAbstractMethod(10, 20));

        Runnable runnable = () -> {
            System.out.println("alanda");
        };

        (new Thread(runnable)).start();

        List<User> users  = User.buildUsersList().subList(0, 10);
        System.out.println(users);

        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
        Function<Integer, Integer> sum = ( a) -> 2*a;


        //https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
        Predicate<User>  isBucurestean = (user)->(user.getCity().equals("Bucuresti"));
        users.removeIf(isBucurestean);
        System.out.println(users);




        // https://docs.oracle.com/javase/8/docs/api/java/util/function/UnaryOperator.html
        UnaryOperator<Long> unaryOperator =  (a)->a+1;


        //https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html
        BinaryOperator<Integer> binaryOperator = (a, b)->(a+b);
        System.out.println(binaryOperator.apply(10, 20));

        //https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html
        Supplier<Long> supplier = () -> {
           return System.nanoTime();
        };

       // https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html
        Consumer<Long> consumer = System.out::println;
        consumer.accept(100l);

    }

    default void moreMethods(){
        System.out.println("alandala");
    }
}



