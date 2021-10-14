package com.lalit.servlet;

import com.lalit.dao.UserDao;
import com.lalit.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/forgetPassword")
public class ForgetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            authenticate(request, response);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        response.sendRedirect("login.jsp");
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "	" + password);
        UserDao userDao = new UserDao();
        List<User> users = userDao.getUserList();
        for (User user : users) {
            System.out.println("loop repeated");
            if (username.equals(user.getUsername())) {
                System.out.println("matchfound");
                userDao.changePassword(password, username);
                break;
            }
        }
    }

}