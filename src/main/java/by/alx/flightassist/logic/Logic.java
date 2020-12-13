package by.alx.flightassist.logic;

import by.alx.flightassist.controller.Controller;
import by.alx.flightassist.bean.User;
import by.alx.flightassist.dao.DAOFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Logic {
    //service
    public Logic(User user){
        super();
        login = user.login;
        password = user.password;
        //LoginCheck();
    }
    protected String login;
    protected String password;

    public User LoginCheck(){
        DAOFactory factory = new DAOFactory();
        User user = new User();
        user.login = login;
        user.password = password;
        ResultSet resultSet = factory.getSqlUserDAO().signIn(user);
        if (resultSet == null) {
            return null;
        }
        else {
            try {
                user.role = resultSet.getString(4);
            } catch (SQLException e) {
                //e.printStackTrace();
            }
            return user;
        }
    }
    public boolean Register(){
        DAOFactory factory = new DAOFactory();
        User user = new User();
        user.login = login;
        user.password = password;
        int i = factory.getSqlUserDAO().registration(user);
        if(i == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
