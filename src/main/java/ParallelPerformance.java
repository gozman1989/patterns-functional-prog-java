import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelPerformance {

    public static void main(String[] args) {
        List<Integer> integers = IntStream.range(0, 10000000).boxed().collect(Collectors.toList());
        BinaryOperator<Integer> binaryOperator = (a, b)->(a+b);

        testSequentialSum(integers, binaryOperator);
        testParallelSum(integers, binaryOperator);
    }

    static void testSequentialSum(List<Integer> integers, BinaryOperator<Integer> binaryOperator){
        long start = System.currentTimeMillis();

        int sum = integers.stream().reduce(0, binaryOperator);
        long duration = System.currentTimeMillis()- start;
        System.out.println("testSequentialSum duration="+duration+" sum="+sum);
    }

    static void testParallelSum(List<Integer> integers, BinaryOperator<Integer> binaryOperator){
        long start = System.currentTimeMillis();

        int sum = integers.parallelStream().reduce(0, binaryOperator);
        long duration = System.currentTimeMillis()- start;
        System.out.println("testParallelSum duration="+duration+" sum="+sum);
    }
}
