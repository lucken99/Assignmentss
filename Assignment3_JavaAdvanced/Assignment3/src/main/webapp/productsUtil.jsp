<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.lalit.model.Product" %>
<%@ page import="java.util.*"%>
<%@ page import="com.lalit.dao.ProductDao"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Products details</title>
	<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libsfont-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<div class="heading" align="center">
		<h2>Product Management Tool</h2>
	</div>
	<div class="edit-product">
		<h4>Please enter product details to add to stock</h4>
		<form method="post" action="<%=request.getContextPath()%>/registeredUser" enctype="multipart/form-data">
			<label for="title">Title</label>
			<input type="text" id="title" name="title">
			<br>
			<br>
			<label for="qty">Quantity</label>
			<input type="number" id="qty" name="qty" min="0" max="100">
			<br>
			<br>
			<label for="size">Size</label>
			<input type="number" id="size" name="size">
			<br>
			<br>
			<label for="image">Image(Max Size 1 MB)</label>
			<input type="file" id="image" name="file"
			    accept="image/png, imgage/jpg, image/jpeg">
			<input type="submit">
		</form>
	</div>
	<br>
	<br>
	<div class="product-details">
		<table>
			<tr>
				<th>S.No</th>
				<th>Title</th>
				<th>Quantity</th>
				<th>Size</th>
				<th>Image</th>
				<th>Actions</th>
			</tr>
			<%
			ProductDao productDao = new ProductDao();
			List<Product> product = productDao.getProductList();
			int i = 1;
			String un = "";
			session = request.getSession();
			un = (String) session.getAttribute("userName");
			System.out.println(un);
			for (Product prod : product) {
				String imgScr = "http://localhost:8080/Assignment3/imgAdd"+ File.separator + Integer.toString(prod.getId()) + ".png";
			%>
			<tr>
				<td><%=i%></td>
				<td><%=prod.getTitle()%></td>
				<td><%=prod.getQty()%></td>
				<td><%=prod.getImageSize()%></td>
				<td><img src=<%=imgScr%> width="110" height="120" /></td>
				<td><a href="edit.jsp?id=<%=prod.getId()%>"><i class="fa fa-edit" style="font-size: 48px; color: black;"></i></a>
					&nbsp &nbsp & nbsp &nbsp <a onclick="return getConfirmation();"href="delete.jsp?id=<%=prod.getId()%>"><i class="fa fa-close" style="font-size: 48px; color: red"></i></a></td>
			</tr>
			<%
				i++;
			} %>

		</table>
	</div>
</body>
</html>