package in.neosoft;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class User{
	private String name;
	private int age;
	private boolean active;
	private Optional<String> email;
	
	public User(String name,int age, boolean active , String email) {
		this.name=name;
		this.age=age;
		this.active=active;
        this.email = Optional.ofNullable(email);
	}
        public int getAge() { return age; }
        public boolean isActive() { return active; }
        public Optional<String> getEmail() { return email; }
        public String getName() { return name; }
    
	}


public class Java8poc {
	public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Alice", 30, true, "alice@example.com"),
                new User("Bob", 25, false, "bob@example.com"),
                new User("Charlie", 35, true, null),
                new User("Diana", 28, true, "diana@example.com")
            );
        
        List<String> activeUserEmails = users.stream()
                .filter(User::isActive)
                .filter(u -> u.getAge() >= 28)
                .map(User::getEmail)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());


	}

}
