import java.util.function.Function;
import java.util.function.Predicate;

public class JavaFunctionalComposition {

    public static void main(String[] args) {
        String sample = "Alandala";
        String sample2 = "AlandalaBBB";
        Predicate<String> incepeCuA = (str)->str.startsWith("A");
        Predicate<String> seTerminaCuB = (str)->str.endsWith("B");
        Predicate<String> incepeCuASiSeTerminaCuB = (str -> incepeCuA.test(str) && seTerminaCuB.test(str) );

        System.out.println(incepeCuASiSeTerminaCuB.test(sample2));
        Predicate<String> incepeCuASiSeTerminaCu2 =  incepeCuA.and(seTerminaCuB);
        System.out.println(incepeCuASiSeTerminaCu2.test(sample2));


        Predicate<String> incepeCuASauSeTerminaCuB =  incepeCuA.or(seTerminaCuB);
        System.out.println(incepeCuASauSeTerminaCuB.test(sample));


        Function<Integer, Integer> multiply = (value) -> value * 10;
        Function<Integer, Integer> add      = (value) -> value +17;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);
        Function<Integer, Integer> multiplyAndAdd = multiply.andThen(add);

        System.out.println(addThenMultiply.apply(3));
        System.out.println(multiplyAndAdd.apply(3));
    }
}
