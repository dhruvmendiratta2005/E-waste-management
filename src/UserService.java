import java.util.ArrayList;
import java.util.List;

// UserService.java
public class UserService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public void updateUser(User user) {
        User existingUser = getUserById(user.getId());
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setAddress(user.getAddress());
        }
    }

    public void deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }
}
