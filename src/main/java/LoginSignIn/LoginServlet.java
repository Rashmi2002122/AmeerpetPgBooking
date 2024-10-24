package LoginSignIn;

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

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
					.prepareStatement("Select Lusername from login where lusername=? and lpassword=?");
			psm.setString(1, name);
			psm.setString(2, pwd);
			ResultSet rs = psm.executeQuery();
			if (rs.next()) {

				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);

			} else {
				out.print("loginfail");
				out.print("<a href='LogIn.jsp'> Try Again!!</a>");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
