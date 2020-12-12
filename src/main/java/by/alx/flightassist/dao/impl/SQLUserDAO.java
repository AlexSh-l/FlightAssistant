package by.alx.flightassist.dao.impl;

import by.alx.flightassist.bean.User;
import by.alx.flightassist.dao.UserDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class SQLUserDAO extends UserDAO {
    @Override
    public void signIn(String login, String password){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?serverTimezone=false&useSSL=false", "root", "");
            Statement statement = connection.createStatement();
            //int rows = statement.executeUpdate("SELECT (login, password) FROM userbd(login, password)");
            ResultSet resultSet = statement.executeQuery("SELECT (login, password) FROM userbd(login, password)");
            connection.close();
        }
        catch (SQLException e) {

        }
    }
    @Override
    public void registration(String login, String password){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?serverTimezone=false&useSSL=false", "root", "");
            Statement statement = connection.createStatement();
            int rows = statement.executeUpdate("INSERT userbd(login, password, role) VALUES (login, password, client)");
            connection.close();
        }
        catch (SQLException e) {

        }

    }
}
