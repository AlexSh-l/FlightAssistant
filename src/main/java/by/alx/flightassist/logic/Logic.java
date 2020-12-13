package by.alx.flightassist.logic;

import by.alx.flightassist.controller.Controller;
import by.alx.flightassist.bean.User;
import by.alx.flightassist.dao.DAOFactory;
import by.alx.flightassist.bean.Flight;

import java.util.ArrayList;

public class Logic {
    //service
    public Logic(User user){
        super();
        login = user.login;
        password = user.password;
    }
    protected String login;
    protected String password;

    public User LoginCheck(){
        DAOFactory factory = new DAOFactory();
        User user = new User();
        user.login = login;
        user.password = password;
        User u = factory.getSqlUserDAO().signIn(user);
        if (u == null) {
            return null;
        }
        else {
            return u;
        }
    }
    public boolean Register(){
        DAOFactory factory = new DAOFactory();
        User user = new User();
        user.login = login;
        user.password = password;
        user.role = "client";
        int i = factory.getSqlUserDAO().registration(user);
        if(i == 0){
            return false;
        }
        else{
            return true;
        }

    }
    public void FlightOut(){
        DAOFactory factory = new DAOFactory();
        ArrayList<Flight>list = factory.getSqlFlightDAO().FlightPrint();
    }
}
