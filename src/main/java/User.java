import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
@AllArgsConstructor
public class User {
    private String username;

    private long age;

    private String city;

    static  final String cities[] = {"Bucuresti", "Iasi", "Craiova", "Cluj", "Brasov"};

    public static List<User> buildUsersList() {
        List<User> users = IntStream
                .range(0, 1000)
                .mapToObj(i->new User("user_"+i, i,cities[i%cities.length]))
                .collect(Collectors.toList());
        return users;
    }
}
