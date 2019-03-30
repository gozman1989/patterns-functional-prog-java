import java.util.stream.IntStream;

public class ParallelStreamsFlaw {
    public static void main(String[] args) {

         IntStream
                .range(0, 1_000_000)
                .parallel()
                .mapToObj(i->new Counter())
                .forEach(Counter::addToSuma);
        System.out.println(Counter.suma);

    }



}


class Counter{
    static int suma = 0;

    int c = 1;

    void addToSuma(){
        suma += c;
    }
}