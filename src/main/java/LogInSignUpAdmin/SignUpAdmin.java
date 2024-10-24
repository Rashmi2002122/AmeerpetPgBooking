package LogInSignUpAdmin;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class SignUpAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			PrintWriter out = response.getWriter();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##Ameerpet",
					"tiger");
			String phoneNumber = request.getParameter("phoneNumber");
			String hostalname = request.getParameter("hostalname");
			String location = request.getParameter("location");
			Part image = request.getPart("image");
			String password = request.getParameter("password");

			String createTableSQL = "CREATE TABLE " + hostalname + " (" + "ROOMNUMBER NUMBER(3) NOT NULL , "
					+ "ROOMSHARE NUMBER(3) NOT NULL, " + "NUMBER_OF_BED NUMBER(3) NOT NULL" + ")";
			Statement stm = con.createStatement();
			PreparedStatement crt = con.prepareStatement(
					"insert into admininfo (phoneno,nameofhostal,location,image,password) values(?,?,?,?,?)");

			PreparedStatement stm2 = con.prepareStatement("insert into adminlogin (Ausername,Apassword) values(?,?)");

			PreparedStatement statement = con.prepareStatement("SELECT table_name FROM all_tables where table_name=?");

			InputStream is = image.getInputStream();

			crt.setString(1, phoneNumber);
			crt.setString(2, hostalname);
			crt.setString(3, location);
			stm2.setString(1, hostalname);
			stm2.setString(2, password);
			crt.setBlob(4, is);
			crt.setString(5, password);
			statement.setString(1, hostalname);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {

				out.print("Already User is Avilable");
				out.print("<a href='SignupAdmin.jsp'> Aready User Present </a>");

			} else {

				stm.execute(createTableSQL);
				stm2.executeQuery();
				crt.executeUpdate();
				out.print("Table created successful");
				System.out.println("Table " + hostalname + " is created successfully!");
				RequestDispatcher rd = request.getRequestDispatcher("LoginAdmin.jsp");
				rd.forward(request, response);

			}
		} catch (Exception e) {
			System.out.println(e.toString());

		}

	}

}
