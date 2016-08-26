package servlets;

import crud.UserCrud;
import entities.UsersEntity;
import utils.UserUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hovercat on 24.08.16.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersEntity user = UserUtils.loginCheck(req.getParameter("login"));

        if (user.getPassword().equals(req.getParameter("password"))) {
            if (user.getRole().equals("admin")) {
                List<UsersEntity> userList;
                userList = UserCrud.getAllUsers();
                req.setAttribute("users", userList);
                req.getRequestDispatcher("table.jsp").forward(req, resp);
            } else {
                req.setAttribute("user", user);
                req.getRequestDispatcher("loginCheck.jsp").forward(req, resp);
            }
        }
    }
}
