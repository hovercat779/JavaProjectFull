package servlets;

import crud.UserCrud;
import entities.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hovercat on 15.08.16.
 */
public class AdminServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UsersEntity> userList;
        userList = UserCrud.getAllUsers();
        req.setAttribute("users", userList);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);

    }
}
