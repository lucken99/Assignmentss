<%@page import="com.nagarro.dao.UserProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String un="";//=(String)request.getAttribute("userName");
	
	if (un == null)
		response.sendRedirect("index.jsp");
	else {
		int id = Integer.parseInt(request.getParameter("id"));
		UserProductDao userProductDao=new UserProductDao();
		userProductDao.deleteProductDetail(id);
		response.sendRedirect("ProductPage.jsp");
	}
	%>
</body>
</html>