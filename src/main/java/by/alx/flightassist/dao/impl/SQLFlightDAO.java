package by.alx.flightassist.dao.impl;

import by.alx.flightassist.dao.FlightDAO;
import by.alx.flightassist.bean.Flight;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class SQLFlightDAO extends FlightDAO {
    @Override
    public ArrayList<Flight> FlightPrint(){
        try {
            ArrayList<Flight> list = new ArrayList<Flight>();
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName).getDeclaredConstructor().newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb?serverTimezone=Europe/Moscow&useSSL=false", "root", "");
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights")) {
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()) {
                    Flight flight = new Flight();
                    flight.setDestination(resultSet.getString(2));
                    flight.setStart(resultSet.getString(3));
                    flight.setStart_time(resultSet.getTime(4));
                    flight.setEnd_time(resultSet.getTime(5));
                    flight.setFlightnum(resultSet.getString(6));
                    flight.setPlanetype(resultSet.getString(7));
                    flight.setAirport(resultSet.getString(8));
                    list.add(flight);
                }
                statement.close();
                connection.close();
                return list;
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
}
