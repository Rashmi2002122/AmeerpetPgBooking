<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Blob"%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Ameerpet</title>
<link rel="stylesheet" href="welcome.css">
</head>
<body>

	<header>
		<div class="bgimg">
			<div class="container">
				<div class="topnav">
					<a href="LogIn.jsp">Home</a> <a href="LogIn.jsp">Candidate</a> <a
						href="LogInAdmin.jsp">Owner</a> <a href="#contact">Contact</a> <a
						href="About.jsp">About</a>
				</div>
			</div>
		</div>
	</header>


	<div class="card-container">
		<%
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##Ameerpet", "tiger");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from admininfo");

			while (rs.next()) {

				String name = rs.getString("NAMEOFHOSTAL");

				String description = rs.getString("LOCATION");
				Blob image = rs.getBlob("image");
				byte[] imgData = image.getBytes(1, (int) image.length());
		%>

		<div class="card">
			<a href="DetailsPresent.jsp?name=<%=name%>"> <img
				src="view.jsp?id=<%=imgData%>" alt="Hostel Image">
			</a>
			<h3>
				<%=name%>
			</h3>
			<p>
				<%=description%>
			</p>

		</div>
		<%
		}

		rs.close();
		stmt.close();
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>



	</div>

</body>
</html>
