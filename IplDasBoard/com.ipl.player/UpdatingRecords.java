
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/save-update-data")
public class UpdatingRecords extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String Name = req.getParameter("Name");
		int age = Integer.parseInt(req.getParameter("age"));
		String nationality = req.getParameter("nationality");
		String team = req.getParameter("team");
		int salary = Integer.parseInt(req.getParameter("salary"));
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_ipldb", "<user&password>",
					"<user&password>");

			PreparedStatement pst = conn.prepareStatement(
					"update ipl set PlayerName=?,PlayerAge=?,PlayerNationality=?,PlayerIplTeam=?,PlayerSalary=? where PlayerId=?");

			pst.setString(1, Name);
			pst.setInt(2, age);
			pst.setString(3, nationality);
			pst.setString(4, team);
			pst.setInt(5, salary);
			pst.setInt(6, id);

			pst.executeUpdate();
			resp.sendRedirect("SearchPlayersAndteam");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
