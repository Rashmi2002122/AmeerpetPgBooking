package AdminPanal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import LogInSignUpAdmin.LoginServletAdmin;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginServletAdmin lsg = new LoginServletAdmin();
		String name = lsg.getName();

//		HttpSession session = request.getSession(false);
//		String name = (String) session.getAttribute("adminName");
		try {
			PrintWriter out = response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##Ameerpet",
					"tiger");
			String RoomNumber = request.getParameter("RoomNumber");
			String RoomShare = request.getParameter("RoomShare");
			String NoOfBed = request.getParameter("NoOfBed");
			System.out.println("name" + name);

			PreparedStatement psm = con
					.prepareStatement("insert into " + name + " (RoomNumber,RoomShare,Number_Of_Bed) values(?,?,?)");
			psm.setString(1, RoomNumber);
			psm.setString(2, RoomShare);
			psm.setString(3, NoOfBed);

			psm.executeUpdate();
			out.println("Successfully Added");
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
