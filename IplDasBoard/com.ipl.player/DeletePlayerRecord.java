
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/find-by-id-del")
public class DeletePlayerRecord extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_ipldb", "<user&password>",
                    "<user&password>");
            PreparedStatement pst = conn.prepareStatement("delete from ipl where PlayerId=?");
            pst.setInt(1, id);

            pst.executeUpdate();
            resp.sendRedirect("SearchPlayersAndteam");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
