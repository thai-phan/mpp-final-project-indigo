package indigo.repository;

import indigo.model.UserRole;
import indigo.model.UserRoleEnum;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static indigo.Database.getConnection;

public class UserRoleRepository {


    public static UserRole getRoleFromRoleId(String roleId) {
        UserRole role = null;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "select * from expense_tracker_indigo.user_role where role_id = ?");
            statement.setString(1, roleId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                role = new UserRole(
                        resultSet.getString("role_id"),
                        UserRoleEnum.valueOf(resultSet.getString("role_name")),
                        resultSet.getString("description")
                );

            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
        return role;
    }
}
