package AdminPanal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ModifyRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String name = (String) session.getAttribute("adminName");
		try {
			PrintWriter out = response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##Ameerpet",
					"tiger");
			String RoomNumber = request.getParameter("RoomNumber");

			PreparedStatement psm = con.prepareStatement("DELETE FROM " + name + " WHERE RoomNumber=? ");
			psm.setString(1, RoomNumber);

			psm.executeUpdate();
			out.println("Successfully Deleted");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
