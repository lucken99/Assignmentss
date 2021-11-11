<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.nagarro.model.TShirt" %>
<%@ page import="com.nagarro.controller.RequiredTShirtController" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container mt-5">
	<%
		final List<TShirt> matchedTShirts = (List<TShirt>) request.getAttribute("matchedTShirts");
		if (matchedTShirts.size()>0){
	%>
	<header>
		<h2 style="text-align:center">Tshirts Found...</h2>
	</header>
	
	<div class="container mb-5 mt-5">
		<div class="table-responsive">
			<table class="table table-striped" border="1">
				<thead>
					<tr>
						<th scope="col">S. No.</th>
						<th scope="col">ID</th>
						<th scope="col">NAME</th>
						<th scope="col">COLOUR</th>
						<th scope="col">GENDER</th>
						<th scope="col">SIZE</th>
						<th scope="col">PRICE</th>
						<th scope="col">RATING</th>
						<th scope="col">AVAILABILITY</th>
					</tr>
				</thead>
				<tbody>
					<%
						int k=1;
							for (final TShirt tShirt: matchedTShirts){					
					%>
					<tr>
						<th scope="row"><%=k%></th>
						<td><%=tShirt.getId() %></td>
						<td><%=tShirt.getName() %></td>
						<td><%=tShirt.getColor() %></td>
						<td><%=tShirt.getGender() %></td>
						<td><%=tShirt.getSize() %></td>
						<td><%=tShirt.getPrice() %></td>
						<td><%=tShirt.getRating() %></td>
						<td><%=tShirt.getAvailability() %></td>
					</tr>
					<%
						k++;
						}
					%>
				</tbody>
			</table>
		</div>
		<br>
		<form action="tryagain" method="post">
			<input type="submit" class="btn btn-success" value="Try Again">
		</form>
	</div>
	<%
		}else {
	%>
	<div class="container mt-5"> <h1 class="text-muted">Oops! No matching Tshirts found</h1></div>
</div>
<%} %>
</body>
</html>