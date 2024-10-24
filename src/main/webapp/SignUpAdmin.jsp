<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
</head>
<style>
body {
	font-family: Arial, sans-serif;
}

.container {
	width: 300px;
	margin: 0 auto;
	padding-top: 100px;
}

.log {
	display: flex;
	flex-direction: column;
}

.log label {
	margin-bottom: 10px;
}

.log input {
	margin-bottom: 20px;
	padding: 10px;
	font-size: 16px;
}

.log button {
	padding: 10px;
	font-size: 16px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
}

.log button:hover {
	background-color: #45a049;
}

.log a {
	padding: 10px;
	text-decoration: none;
	text-align: center;
	color: red;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Sign Up</h2>
		<form class="log" action="SignUpAdmin" method="post" enctype="multipart/form-data" >
			<label for="phone">Number:</label>
			 <input type="number" name="phoneNumber" required> 
			 <label for="username">Hostel Name:</label> 
			 <input type="text" name="hostalname" required>
			 <label for="username">Location:</label>
			 <input type="text" name="location" required>
			 <label for="photo">Hostel Photo:</label>
			 <input type="file" name="image" required="required">
			 <label for="password">Password:</label> 
			 <input type="password" name="password" required>

			<button type="submit">Login</button>
			<a href="LogInAdmin.jsp">Already Register</a>
		</form>
	</div>
</body>
</html>