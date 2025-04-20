package indigo.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static indigo.Database.getConnection;

public class UserRepository {

    public static boolean authenticateUser(String username, String password) {
        boolean isUserAvailable = false;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from expense_tracker_indigo.user where username = ? and password = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                isUserAvailable = true;
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
        return isUserAvailable;
    }

    public static void getUserByUserId(String username) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from expense_tracker_indigo.user where username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("username");
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    public static void createUser(String user_id, String username, String password, String email,
                                  String phoneNumber, String userPosition) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO expense_tracker_indigo.user (user_id, username, password, email, phone_number, user_position_code) " +
                            "VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, user_id);
            statement.setString(2, username);
            statement.setString(3, password);
            statement.setString(4, email);
            statement.setString(5, phoneNumber);
            statement.setString(6, userPosition);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("username");
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    public static void updateUser(String username, String password, String email, String phoneNumber, String userPositionCode) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "update expense_tracker_indigo.user SET " +
                            "username = ?," +
                            "password = ?, " +
                            "email = ?, " +
                            "phone_number = ?," +
                            "user_position_code = ?" +
                            "where user_id = ?");
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setString(4, phoneNumber);
            statement.setString(5, userPositionCode);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("username");
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    public static void removeUser(String userId) {
        try (Connection connection = getConnection()) {
            PreparedStatement myStmt = connection.prepareStatement(
                    "delete from expense_tracker_indigo.user where user_id = ?");
            myStmt.setString(1, userId);
            ResultSet resultSet = myStmt.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("username");
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }


}
