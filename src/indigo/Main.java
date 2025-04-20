package indigo;

import java.util.Scanner;

import static indigo.Database.queryToDatabase;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Expense Tracker?");


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input username:");
        String username = scanner.nextLine();
        System.out.println("Please input password");
        String password = scanner.nextLine();






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