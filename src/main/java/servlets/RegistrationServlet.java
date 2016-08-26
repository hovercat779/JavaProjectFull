package servlets;

import crud.UserCrud;
import entities.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hovercat on 24.08.16.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("registration.jsp").forward(req, resp);

        UsersEntity user = new UsersEntity();

        user.setLogin(req.getParameter("login"));
        user.setName(req.getParameter("password"));
        user.setPassword(req.getParameter("name"));
        user.setRole(req.getParameter("role"));

        UserCrud.addUser(user);
    }
}