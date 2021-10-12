package com.lalit.controller;

import com.lalit.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao loginDao;

    @Override
    public void init() {
        loginDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("login".equals(action)) {
            try {
                authenticate(request, response);
            } catch (Exception e) {
                System.out.println("Authentication fails!");
                e.printStackTrace();
            }
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);


        if (loginDao.validate(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("userName", username);
            response.sendRedirect("productsUtil.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
