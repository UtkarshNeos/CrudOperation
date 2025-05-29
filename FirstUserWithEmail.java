package in.neosoft;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Users {
    String name;
    Optional<String> email;

    Users(String name, Optional<String> email) {
        this.name = name;
        this.email = email;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

public class FirstUserWithEmail {
    public static void main(String[] args) {
        List<Users> users = Arrays.asList(
            new Users("Alice", Optional.empty()),
            new Users("Bob", Optional.of("bob@example.com")),
            new Users("Charlie", Optional.of("charlie@example.com"))
        );

        Optional<Users> firstUserWithEmail = users.stream()
            .filter(user -> user.getEmail().isPresent())
            .findFirst();

        firstUserWithEmail.ifPresent(user -> 
            System.out.println("First user with email: " + user.getName() + ", Email: " + user.getEmail().get())
        );

        // If no user with email found
        if (!firstUserWithEmail.isPresent()) {
            System.out.println("No user with email found");
        }
    }
}

 