package indigo.logic;

import indigo.model.User;
import indigo.repository.UserRepository;

import java.util.List;

public class UserFlow {

    public static void startUserMainFlow() {

        // authenticate
        boolean isUser = UserRepository.authenticateUser("thaiphan", "1234");
        if (isUser) {
            System.out.println("Login success!");
        } else {
            System.out.println("User information wrong!");
        }

        // get User
        List<User> users = UserRepository.getUserByUsername("jasmine");
        if (!users.isEmpty()) {
            System.out.println("User available");
        }

        // isAdmin User
        String userId = "user001";
        boolean isAdmin = UserRepository.checkUserIsAdmin(userId);
        if (isAdmin) {
            System.out.println("User is Admin");
        }

//         update use
    }
}
