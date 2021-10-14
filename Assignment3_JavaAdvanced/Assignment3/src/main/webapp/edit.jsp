<%@page import="com.lalit.dao.ProductDao"%>
<%@page import="com.lalit.model.Product"%>
<%@page import="java.util.*" %>
<%@page import="java.io.File"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
</head>
<body>
	<%
	int id =Integer.parseInt(request.getParameter("id"));
		ProductDao productDao=new ProductDao();
		List<ProductDao> ProductList=productDao.getProductDetailViaId(id);
		session=request.getSession();
		session.setAttribute("userId", id);
		for (ProductDao data : ProductList) {
			String imgScr="Assignment3\\imgAdd"+File.separator+Integer.toString(data.getId())+".png";
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
						<a href="loginSuccess.jsp"><button type="button">Cancel</button> </a>
					</div>
				</form>
			</div>

	<%
	}
	%>
</body>
</html>