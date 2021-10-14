<%@page import="com.nagarro.dao.UserProductDao"%>
<%@page import="com.nagarro.model.UserProduct"%>
<%@page import="java.util.*" %>
<%@page import="java.io.File"%>
<%@page import="javax.servlet.http.HttpSession"%>
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
	int id =Integer.parseInt(request.getParameter("id"));
		UserProductDao userProductDao=new UserProductDao();
		List<UserProduct> userProductList=userProductDao.getImageDetailViaId(id);
		session=request.getSession();
		session.setAttribute("userId", id);
		for (UserProduct data : userProductList) {
			String imgScr="D:\\addImg"+File.separator+data.getProductTitle();
	%>
	<div class="container-fluid" style="margin-left:50px;">
		
				<header>
					<h2>Edit Image data</h2>
				</header>
				<form action="<%=request.getContextPath()%>/edit" method="post" enctype="multipart/form-data" >
					<div >Please select an image file to upload (Max Size 1 MB)</div>
					<br>
					<div >
						<%-- <input type="text" name="n1" value="<%=data.getImageName()%>" required />
						 --%><input type="file" name="file" accept="image/png, image/jpg, image/jpeg">
						<input type="submit">
						<a href="ProductPage.jsp"><button type="button">Cancel</button> </a>
					</div>
				</form>
			</div>
		
	<%
	}
	%>
</body>
</html>