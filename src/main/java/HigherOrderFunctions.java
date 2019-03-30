import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/*
 * A higher order function is a function that either takes a function (method) as parameter,
 * or returns a function after its execution
 */
public class HigherOrderFunctions {

    public static void main(String[] args) {

        BinaryOperator<Double> inmultire = (a, b)->(a*b);
        BiFunction<BinaryOperator<Double>, Double,Double> ridicareLaPAtrat = (bf, a)->( bf.apply(a, a));

        System.out.println("10x3="+inmultire.apply(10d,3d));
        System.out.println("10 la patrat="+ridicareLaPAtrat.apply(inmultire, 10d));

        List<User> userList = User.buildUsersList();
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Long.valueOf(o2.getAge()-o1.getAge()).intValue();
            }
        });
        //OR


        userList.sort(Comparator.comparing(User::getAge).reversed().thenComparing(User::getCity));
        }
}
