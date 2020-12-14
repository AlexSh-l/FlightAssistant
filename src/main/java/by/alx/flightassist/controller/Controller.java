package by.alx.flightassist.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import by.alx.flightassist.bean.Flight;

import by.alx.flightassist.logic.Logic;
import by.alx.flightassist.bean.User;

public class Controller extends HttpServlet {
    public Controller() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        Logic logic = new Logic(user);
        if (logic.LoginCheck() != null) {
            //Open flights.jsp
            //role defined pages
            ArrayList<Flight> list = logic.FlightOut();
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/flights.jsp");
            request.setAttribute("flights", list);
            requestDispatcher.forward(request, response);
        } else {
            user.setRole("client");
            if (logic.Register()) {
                //Open flights.jsp
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/flights.jsp");
                requestDispatcher.forward(request, response);
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
