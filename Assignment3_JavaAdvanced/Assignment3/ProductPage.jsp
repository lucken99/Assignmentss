<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.nagarro.model.UserProduct"%>
<%@ page import="java.util.*"%>
<%@ page import="com.nagarro.dao.UserProductDao"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
.heading {
	display: inline-block;
}

.user {
	display: inline-block;
	position: absolute;
	right: 0;
	padding: 25px;
}

.button {
	width: 115px;
	height: 25px;
	background: #4E9CAF;
	padding: 10px;
	text-align: center;
	border-radius: 5px;
	color: white;
	font-weight: bold;
	line-height: 25px;
	text-decoration: none;
}
</style>
<title>Insert title here</title>
</head>
<body>

   <%
   String userName = (String) request.getAttribute("UserName");
   
   %>




	<div align="center">
		<div class="heading">
			<h1>Product Management Tool</h1>
		</div>
		<div class="user">
		Hi,${userName} <a class="button" href="index.jsp">Logout</a>
		</div>
	</div>
	<div>

		<form action="UserServlet" method="post" enctype="multipart/form-data">


			<h3>Please enter product details to add to stock</h3>
			Title <input type="text" name="title"><br> Quantity <input
				type="text" name="quantity"><br> Product Size <input
				type="text" name="size"><br> Image <input type="file" name="image">

			<button type="submit" class="btn btn-primary" name="action"
				value="login">Submit</button>



		</form>
	</div>
	<!-- starting table -->
	<div class="tb">
		<table class="table table-bordered  table-responsive" border="2"
			width="100%">
			<thead>
				<tr>
					<th>S.No</th>
					<th>Title</th>
					<th>Quantity</th>
					<th>Size</th>
					<th>Image</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
					int i = 1;
					UserProductDao userProductDao = new UserProductDao();
					List<UserProduct> product = userProductDao.getUserProductList();
					String imagePath = "C:/Users/kaminishrivastava/eclipse-workspace/Assignment/Product_JSP_Servlets_Assignment/src/main/webapp/images/";
					for (UserProduct img : product) {
				%>


				<tr>
				   
					<td><%=i%></td>
					<td><%=img.getProductTitle()%></td>
					<td><%=img.getProductQty()%></td>
					<td><%=img.getProductSize()%></td>
					<%--  <td><img src=<%=imagePath+ img.getImageFileName()%> width="110" height="120" /></td>  --%>
					<% out.println("<td><img style=height: 30%; width: 40%; padding: 20px; src=images/"
+img.getImageFileName()+" "+"width=240 height=300/></td>");%>
					<td><a href="Edit.jsp?id=<%=img.getId()%>"><i
							class="fa fa-edit" style="font-size: 48px; color: black;"></i> </a>
						&nbsp &nbsp &nbsp &nbsp <a onclick="return getConfirmation();"
						href="Delete.jsp?id=<%=img.getId()%>"><i class="fa fa-close"
							style="font-size: 48px; color: red"></i> </a></td>



				</tr>

				<%
					i++;
					}
				%>
			</tbody>

		</table>
	</div>

	

</body>
</html>