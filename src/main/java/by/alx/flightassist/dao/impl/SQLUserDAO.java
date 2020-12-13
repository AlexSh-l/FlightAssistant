package by.alx.flightassist.dao.impl;

import by.alx.flightassist.bean.User;
import by.alx.flightassist.dao.UserDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class SQLUserDAO extends UserDAO {
    @Override
    public ResultSet signIn(User user){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?serverTimezone=false&useSSL=false", "root", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT (user.login, user.password) FROM userbd(login, password)");
            connection.close();
            return resultSet;
        }
        catch (SQLException e) {
            return null;
        }
    }
    @Override
    public int registration(User user){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?serverTimezone=false&useSSL=false", "root", "");
            Statement statement = connection.createStatement();
            int row = statement.executeUpdate("INSERT userbd(login, password, role) VALUES (user.login, user.password, client)");
            connection.close();
            return row;
        }
        catch (SQLException e) {
            return 0;
        }

    }
}
