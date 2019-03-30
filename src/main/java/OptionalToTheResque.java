import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class OptionalToTheResque {


    /*
    * Why is null bad??
    * https://dzone.com/articles/the-worst-mistake-of-computer-science-1
     */
    public static void main(String[] args) {
        List<User> userList = User.buildUsersList();
        Optional<User> userOptional = userList
                .stream()
                .filter(user -> user.getAge() == 1)
                .findFirst();
    }
}
