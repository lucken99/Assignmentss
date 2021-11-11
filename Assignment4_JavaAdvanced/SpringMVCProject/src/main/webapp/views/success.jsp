<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<header><p style="text-align:right"> Hi, ${user.userName}</p></header>
<h3 class="text-center">Find your TShirt here...</h3>
<p class="text-center"></p>
<div class="container" style="text-align:center">
<form action="tshirtform" method="post">
	<div class="form-group">
		<label for="color">Color</label>
		<input type="text" class="form-control" name="color" id="color"
		placeholder="Enter the color here.." required>
	</div>
	<br>
	<div class="form-group">
		<label for="size">Size</label>
		<input type="text" class="form-control" name="size" id="size"
		placeholder="Enter the size here.." required>
	</div>
	<br>
	<div class="form-group">
		<label for="gender">Gender</label>
		<input type="text" class="form-control" name="gender" id="gender"
		placeholder="Enter the gender here.." required>
	</div>
	<br>
	<div class="form-group">
		<label for="sortPreference">Sort Preference</label>
		<input type="text" class="form-control" name="sortPreference" id="sortPreference"
		placeholder="Enter the sort preference here.." required>
	</div>
	<br>
	<div class="container text-center">
		<button type="submit" class="btn btn-success">Search TShirts</button>
	</div>
</form>
</div>
</body>
</html>