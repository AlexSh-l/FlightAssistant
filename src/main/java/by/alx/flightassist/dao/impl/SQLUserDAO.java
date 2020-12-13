package by.alx.flightassist.dao.impl;

import by.alx.flightassist.bean.User;
import by.alx.flightassist.dao.UserDAO;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class SQLUserDAO extends UserDAO {
    @Override
    public User signIn(User user){
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName).getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?serverTimezone=Europe/Moscow&useSSL=false", "root", "");
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM userbd WHERE login = ?")) {
                statement.setString(1, user.login);
                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                String pass = resultSet.getString(3);
                if (!pass.equals(user.password))
                    return null;
                user.role = resultSet.getString(4);
                statement.close();
                connection.close();
                return user;
            }
            catch ( SQLException e){
                connection.close();
                return null;
            }
        }
        catch (SQLException e) {
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int registration(User user){
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName).getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?serverTimezone=Europe/Moscow&useSSL=false", "root", "");
            try(PreparedStatement statement = connection.prepareStatement("INSERT userbd (login, password, userrole) VALUES (?, ?, ?)")) {
                statement.setString(1, user.login);
                statement.setString(2, user.password);
                statement.setString(3, user.role);
                int row = statement.executeUpdate();
                statement.close();
                connection.close();
                return row;
            }
            catch ( SQLException e){
                connection.close();
                return 0;
            }
        }
        catch (SQLException e) {
            return 0;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
