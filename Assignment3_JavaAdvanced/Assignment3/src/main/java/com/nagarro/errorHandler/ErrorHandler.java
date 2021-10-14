package com.nagarro.errorHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/errorMakeup")
public class ErrorHandler {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	response.sendRedirect("errorHandler.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
