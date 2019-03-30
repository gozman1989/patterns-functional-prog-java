import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//A sequence of elements supporting sequential and parallel aggregate operations
public class Streams {

    public static void main(String[] args) {
        List<User> userList = User.buildUsersList();

        List<Long> ages = userList
                .stream()
                .filter(user -> user.getCity().equals("Iasi"))//filtering
                .distinct()//only distinc elements
                .skip(1)   //skipping
                .limit(10)//limit results
                .map(user -> user.getAge()) //mapping from one object/primitive to another
                .collect(Collectors.toList());
        System.out.println(ages);

        List<String> words = Arrays.asList("Ana", "Are", "Mere");

        //flap mapping
        List<String> uniqueLetters = words.stream()
                .map(word-> word.split(""))
                .flatMap(words2 -> Arrays.stream(words2))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueLetters);


        String word = words
                .stream()
                .filter(word2 -> word2.equals("Are"))
                .findFirst().orElseGet( ()->"maria");

        System.out.println(word);


    //Primitive Streams
        int n = 3;
        int sum = IntStream.range(1, n+1)
                .reduce(0, (x, y)-> x+y);

        System.out.println("sum="+sum);



        long sumaVarstelor = userList.stream()
                .limit(4)
                .mapToLong(User::getAge)
                .sum();

        System.out.println(sumaVarstelor);

        //combine streams
       Stream<Integer> integerStream0_10 = IntStream.range(0, 10).boxed();
       Stream<Integer> integerStream23_35 = IntStream.range(23, 35).boxed();
       List<Integer> numbers = Stream.concat(integerStream0_10, integerStream23_35).collect(Collectors.toList());
        System.out.println(numbers);


        //reduce
        int suma2= IntStream.range(0, 10).reduce(0, (a,b)->(a+b));
        System.out.println(suma2);

        //Map Conversion
       /* Map<String, User> usersByMap = userList.stream().collect(Collectors.toMap(user -> user.getCity(), user->user));
        System.out.println(usersByMap);*/


        Map<String, User> usersByMap2 = userList.stream().collect(
                Collectors.toMap(
                        user -> user.getCity(),
                        user->user,
                        (oldVal, newVal)-> newVal
                        )
        );
        System.out.println(usersByMap2);

    }




}
