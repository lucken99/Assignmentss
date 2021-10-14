package com.nagarro.webController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nagarro.dao.UserDao;
import com.nagarro.model.User;


@WebServlet("/index")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao loginDao;

    public void init() {
        loginDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	response.sendRedirect("ProductPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("index".equals(action)) {
			try {
				authenticate(request, response);
		    } catch (Exception e) {
		    	// TODO Auto-generated catch block
		    	e.printStackTrace();
		    }
		}
		
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    
	    if (loginDao.validate(username, password)) {
	    	HttpSession session=request.getSession();
			session.setAttribute("userName", username);
	    	response.sendRedirect("ProductPage.jsp");
	    //	response.sendRedirect("Demo.jsp");

	    } else {
	    	HttpSession session=request.getSession();
	    	session.setAttribute("message","User NotExist.");
	    	response.sendRedirect("errorHandler.jsp");
	    }
    	
	}
	
}
