<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Blob"%>

<%
String userid = request.getParameter("name");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to <%=userid%></title>

<link rel="stylesheet" href="DetailsPresent.css">
</head>

<body>


	<div class="card-container">
		<%
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##Ameerpet", "tiger");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from " + userid);

			while (rs.next()) {

				String roomNumber = rs.getString("RoomNumber");
				String roomShare = rs.getString("RoomShare");
				String numberOfBed = rs.getString("Number_of_Bed");
		%>

		<div class="card">


			<h3>
				RoomNUmber: <%=roomNumber%>
			</h3>
			<h4>Number of Share: <%=roomShare%></h4>
			<p>
				Vacancy: <%=numberOfBed%>
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
	
	<button type="button">Contact the Hostel</button>

</body>
</html>