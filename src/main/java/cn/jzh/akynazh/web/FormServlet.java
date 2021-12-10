package cn.jzh.akynazh.web;

import cn.jzh.akynazh.bean.User;
import cn.jzh.akynazh.service.UserService;
import cn.jzh.akynazh.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/formServlet")
public class FormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        String description = req.getParameter("description");
        UserService userService = new UserServiceImpl();
        User user = new User(null, username, password, description);
        User loginUser = null;

        if (type.equals("Register")) {
            if (userService.existsUsername(username)) {
                return;
            } else {
                userService.register(user);
                loginUser = userService.login(user);
            }
        } else {
            loginUser = userService.login(user);
            System.out.println(loginUser);
            if (loginUser == null) {
                return;
            }
        }
        System.out.println(loginUser);
        Gson gson = new Gson();
        String jsonString = gson.toJson(loginUser);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write(jsonString);
    }
}
