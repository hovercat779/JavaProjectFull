package servlets;

import crud.UserCrud;
import entities.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

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

        Object method = req.getParameter("method");

        if (Objects.equals(method, "delete")) {

            UserCrud.deleteUser(Integer.parseInt(req.getParameter("id")));

        } else if (Objects.equals(method, "add")) {

            UsersEntity user = new UsersEntity();

            user.setLogin(req.getParameter("login"));
            user.setPassword(req.getParameter("password"));
            user.setName(req.getParameter("name"));
            user.setRole(req.getParameter("role"));
            user.setGender(req.getParameter("gender"));

            UserCrud.addUser(user);
        } else if (Objects.equals(method, "update")){
            UsersEntity user = UserCrud.getUser(Integer.parseInt(req.getParameter("id")));

            req.setAttribute("user", user);

            req.getRequestDispatcher("update.jsp").forward(req, resp);
        }

        List<UsersEntity> userList;
        userList = UserCrud.getAllUsers();
        req.setAttribute("users", userList);
        req.getRequestDispatcher("admin.jsp").forward(req, resp);

    }


}

