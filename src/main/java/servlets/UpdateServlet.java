package servlets;

import crud.UserCrud;
import entities.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hovercat on 04.09.16.
 */
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        UsersEntity user = UserCrud.getUser(Integer.parseInt(req.getParameter("id")));

        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        user.setRole(req.getParameter("role"));
        user.setGender(req.getParameter("gender"));

        UserCrud.updateUser(user);

        List<UsersEntity> userList;
        userList = UserCrud.getAllUsers();
        req.setAttribute("users", userList);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);
    }
}
