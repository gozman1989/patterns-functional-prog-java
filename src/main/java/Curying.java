import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Curying {
    public static void main(String[] args) {

        BinaryOperator<Integer> suma = (a, b)->(a+b);

        Function<Integer,
                Function<Integer, Integer>>
                currySum = u -> (v -> (u + v));

        System.out.println(suma.apply(10, 30));
        System.out.println(currySum.apply(10).apply(30));


    }
}
