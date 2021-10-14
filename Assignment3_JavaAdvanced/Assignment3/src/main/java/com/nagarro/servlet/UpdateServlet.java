 package com.nagarro.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.nagarro.dao.UserProductDao;
import com.nagarro.model.UserProduct;

@WebServlet("/edit")
public class UpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		// to get id
		int id = (int) session.getAttribute("userId");
		// to get username
		String userName = "";
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("userName")) {
				userName = c.getValue();
			}
		}
		if (userName == null)
			response.sendRedirect("index.jsp");
		else {
			System.out.println(id);
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
				List<FileItem> multifiles;
				try {
					multifiles = sf.parseRequest(request);
				System.out.println("multifile size = "+multifiles.size());
				UserProductDao userProductDao = new UserProductDao();
				for (FileItem item : multifiles) {
					System.out.println(item.getName());
					String productTitle = item.getName();
					System.out.println(item);
					try {
						System.out.println(1);
						
						File file=new File("D:\\imgAdd" +File.separator +item.getName());
						item.write(file);
						System.out.println(item);
						System.out.println(1);
						
						if (item.getSize() < 1024*1024) {
							userProductDao.editProductDetail(productTitle, item.getSize()/1024,id);
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				} catch (FileUploadException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			response.sendRedirect("ProductPage.jsp");
	}
}
