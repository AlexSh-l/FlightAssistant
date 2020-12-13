package by.alx.flightassist.logic;

import by.alx.flightassist.controller.Controller;
import by.alx.flightassist.bean.User;
import by.alx.flightassist.dao.DAOFactory;

import java.sql.ResultSet;

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

    public boolean LoginCheck(){
        DAOFactory factory = new DAOFactory();
        User user = new User();
        user.login = login;
        user.password = password;
        ResultSet resultSet = factory.getSqlUserDAO().signIn(user);
        if (resultSet == null)
            return false;
        else
            return true;
    }
}
