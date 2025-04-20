package indigo;

import indigo.model.User;
import indigo.repository.UserRepository;

import java.util.List;

import static indigo.Database.queryToDatabase;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Expense Tracker?");


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Please input username:");
//        String username = scanner.nextLine();
//        System.out.println("Please input password");
//        String password = scanner.nextLine();

        boolean isUser = UserRepository.authenticateUser("thaiphan", "1234");
        if (isUser) {
            System.out.println("Login success!");
        } else {
            System.out.println("User information wrong!");
        }

        List<User> aa = UserRepository.getUserByUserId("jasmine");
        if (!aa.isEmpty()) {
            System.out.println("User available");
        }


//        PreparedStatement myStmt = connection.prepareStatement("select * from expense_tracker_indigo.user where username = ?");
//        myStmt.setString(1, "thaiphan");

        queryToDatabase();
//        Check password


        //

        //


        //

        //
        //


    }
}