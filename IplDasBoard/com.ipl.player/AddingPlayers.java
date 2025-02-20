
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddingPlayers extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String Name = req.getParameter("Name");
        int age = Integer.parseInt(req.getParameter("age"));
        String nationality = req.getParameter("nationality");
        String team = req.getParameter("team");
        int salary = Integer.parseInt(req.getParameter("salary"));
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_ipldb", "<UserName>", "<Password>");

            PreparedStatement pst = conn.prepareStatement("Insert into ipl values(?,?,?,?,?,?)");
            pst.setInt(1, id);
            pst.setString(2, Name);
            pst.setInt(3, age);
            pst.setString(4, nationality);
            pst.setString(5, team);
            pst.setInt(6, salary);
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
