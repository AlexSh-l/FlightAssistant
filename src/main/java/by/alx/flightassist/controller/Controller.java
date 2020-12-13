package by.alx.flightassist.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import by.alx.flightassist.logic.Logic;
import by.alx.flightassist.bean.User;


public class Controller extends HttpServlet {
    public Controller(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.login = request.getParameter("login");
        user.password = request.getParameter("password");
        Logic logic = new Logic(user);
        if(logic.LoginCheck() != null){
            //Open flights.jsp
            //role defined pages
        }
        else{
            user.role = "client";
            if(logic.Register()){
                //Open flights.jsp
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/flights.jsp");
                requestDispatcher.forward(request, response);
            }
            else{
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}
