package indigo;

import static indigo.logic.UserFlow.startUserMainFlow;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Expense Tracker!");


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please input username:");
//        String username = scanner.nextLine();
//        System.out.println("Please input password");
//        String password = scanner.nextLine();



        startUserMainFlow();

    }
}