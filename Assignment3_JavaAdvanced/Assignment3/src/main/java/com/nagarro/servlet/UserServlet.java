package com.nagarro.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.nagarro.dao.UserProductDao;
import com.nagarro.model.UserProduct;

@MultipartConfig
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String qty = request.getParameter("quantity");
		String productSize = request.getParameter("size");
		
		
		Part file = request.getPart("image");
		String  imageName = file.getSubmittedFileName();
		
		
	
			String uploadPath = "D:\\myWebProject\\apache-tomcat-9.0.54\\webapps\\Assignment3\\images"
					+ imageName;// System.out.println("File Name : " + f + "File Size : " + size);
			System.out.println("Upload Path :" + uploadPath);

			
			try {           
				FileOutputStream fos = new FileOutputStream(uploadPath);
				InputStream is = file.getInputStream();
				byte[] data = new byte[is.available()];
				is.read(data);
				fos.write(data);
				fos.close();
				} catch (Exception e) {
				e.printStackTrace();
				}
		
		UserProductDao userProductDao = new UserProductDao();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("userName");

		System.out.println(userName);
		UserProduct userProduct = new UserProduct();
		userProduct.setProductSize(Double.parseDouble(productSize));
		userProduct.setProductQty(Double.parseDouble(qty));
		userProduct.setProductTitle(title);
		userProduct.setImageFileName(imageName);
		userProduct.setUserName(userName);
		userProductDao.saveUserProduct(userProduct);

		/*
		 * List<UserProduct> productList = userProductDao.getUserProductList();
		 * for(UserProduct u : productList) { System.out.println(u.getProductTitle());
		 * System.out.println(u.getProductQty());
		 * System.out.println(u.getProductSize()); }
		 */
		request.setAttribute("UserName", userName);
		RequestDispatcher rd = request.getRequestDispatcher("ProductPage.jsp");
		rd.forward(request, response);

	}

}
