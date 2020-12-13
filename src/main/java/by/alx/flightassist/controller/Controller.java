package by.alx.flightassist.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/controller")
public class Controller extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //request.setAttribute("name", "Tom");
        //request.setAttribute("age", 34);
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        //getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);

    }
}
