package indigo.repository;

import indigo.model.Expense;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static indigo.Database.getConnection;

public class ExpenseRepository {

    public static List<Expense> getExpensesByUser(String expendId) {
        List<Expense> expenses = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from expense_tracker_indigo.expense where expense_id = ?");
            statement.setString(1, expendId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Expense expense = new Expense();
                expense.setExpenseId(resultSet.getString("expense_id"));
                expense.setUserId(resultSet.getString("user_id"));
                expense.setAmount(resultSet.getDouble("amount"));
                expense.setDate(resultSet.getDate("date"));
                expense.setDescription(resultSet.getString("description"));
                expenses.add(expense);
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
        return expenses;
    }

    public static boolean viewExpense(String expendId) {
        boolean isUserAvailable = false;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from expense_tracker_indigo.expense where expense_id = ?");
            statement.setString(1, expendId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                isUserAvailable = true;
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
        return isUserAvailable;
    }

    public static void addExpense(String expendId) {

    }

    public static void updateExpense(String expendId) {

    }

    public static void removeExpense(String expendId) {

    }
}