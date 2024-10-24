<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Room</title>
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
		<h2>New Entry</h2>
		<form class="log" action="CreateRoom" method="post">
			<label for="RoomNumber">RoomNumber:</label>
			 <input type="number" name="RoomNumber" required>
			  <label for="RoomShare">RoomShare:</label>
			<input type="number" name="RoomShare" required>
			 <label	for="RoomNumber">Number Of Bed:</label> 
			 <input type="number" name="NoOfBed" required> 

			<button type="submit">Upload</button>
			<a href="DeleteRoom.jsp">Delete Some Entry...</a>
		</form>
	</div>
</body>
</html>