package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Users;
import services.UserService;


public class UserServelet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UserService userService = new UserService();
        ArrayList<Users> users = null;
        try{
            users = (ArrayList<Users>) userService.getAllUsers();
        }catch(Exception e){
           request.setAttribute("message", "Error has occured");
        }
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/manage_user.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}