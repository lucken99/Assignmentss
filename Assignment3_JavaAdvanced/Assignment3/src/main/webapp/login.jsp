<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">


	 <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

    <link rel="stylesheet" type="text/css" href="../css/style.css">
	<title>Login Page</title>
</head>
<body>
	<div class="container">
		<main class="main">
			<form method="post" action="<%=request.getContextPath()%>/login">
				<header class="row m-4 border header">
					<h4>Login</h4>
				</header>
				<div class="row m-4 align-items-center">
					<div class="col-4">
						<label for="username" class="col-form-label">Username:</label>
					</div>
					<div class="col-4">
						<input type="text" name="username" id="username" class="form-control" required>
					</div>
				</div>
				<div class="row m-4 align-items-center">
					<div class="col-4">
						<label for="password" class="col-form-label">Password:</label>
					</div>
					<div class="col-4">
						<input type="password" name="password" id="password" class="form-control" required>
					</div>
				</div>
				<div class="row m-4 align-items-center">
					<div class="col-4"></div>
					<div class="col-4">
						<a href="forget.jsp">Forgot your password?</a>
					</div>
				</div>
				<div class="row-2 m-4 border login-btn">
					<!-- button class="btn btn-primary" type="submit">login</button> -->
					<input type="submit" name="action" value="login"/>
				</div>
			</form>
		</main>
	</div>
</body>
</html>