import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FunctionalVsOOP {


    /*
    * Functional(Declarative/What) vs OOP(How)
     */
    public static void main(String[] args) {

        List<User> usersList = User.buildUsersList().subList(0, 10);
        oopFunc(usersList);
        functionalFunc(usersList);

    }

    private static void oopFunc(List<User> usersList) {
        User oldest = null;
        for (User user : usersList){
            if (oldest == null){
                oldest = user;
            }else if (user.getAge()>oldest.getAge()){
                oldest = user;
            }
        }

        if (oldest != null){
            System.out.println("oldest="+oldest);
        }
    }

    private static void functionalFunc(List<User> usersList) {
        /*
        * The fine detail of how this query is implemented is left to the library. We refer to this idea as internal iteration
        * This “what” style is often called declarative programming. You give rules saying what you want,
         * and you expect the system to decide how to achieve it. It’s great because it reads closer to the problem statement.
         */
        Optional<User> oldestUser = usersList
                .stream()
                .max(Comparator.comparing(User::getAge));
         oldestUser.ifPresent(System.out::println);
        /*
         *Functional programming exemplifies this idea of declarative programming
         * (“just say what you want, using expressions that don’t interact, and for which
         * the system can choose the implementation”) and side-effect-free
         * computation explained previously.
         */
    }
}
