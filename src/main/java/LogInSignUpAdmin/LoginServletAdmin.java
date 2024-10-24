package LogInSignUpAdmin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServletAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String name;

	public String getName() {
		return name;
	}

	public static void setName(String name) {
		LoginServletAdmin.name = name;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##Ameerpet",
					"tiger");
			String name = request.getParameter("username");
			String pwd = request.getParameter("password");
			PreparedStatement psm = con
					.prepareStatement("Select Ausername from adminlogin where Ausername=? and Apassword=?");
			psm.setString(1, name);
			psm.setString(2, pwd);
			ResultSet rs = psm.executeQuery();
			if (rs.next()) {
				LoginServletAdmin.setName(name);
				RequestDispatcher rd = request.getRequestDispatcher("AdminPanal.jsp");
				rd.forward(request, response);
				HttpSession session = request.getSession();
				session.setAttribute("adminName", name);

			} else {
				out.print("loginfail");
				out.print("<a href='LogInAdmin.jsp'> Try Again!!</a>");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}