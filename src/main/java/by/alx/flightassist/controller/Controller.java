package by.alx.flightassist.controller;

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


        //request.setAttribute("name", "Tom");
        //request.setAttribute("age", 34);
        //String login = request.getParameter("login");
        //String password = request.getParameter("password");
        //getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
        User user = new User();
        user.login = request.getParameter("login");
        user.password = request.getParameter("password");
        Logic logic = new Logic(user);
        if(logic.LoginCheck()){
            //Open flights.jsp
        }
    }
}
