package com.ipl.team;

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

public class AddTeam extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String TeamName = req.getParameter("TeamName");

        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_ipldb", "<user&password>",
                    "<user&password>");

            PreparedStatement pst = conn.prepareStatement("Insert into ipl_team values(?)");
            pst.setString(1, TeamName);

            int result = pst.executeUpdate();

            PrintWriter pw = res.getWriter();

            if (result > 0) {
                pw.write("<script> alert('Added the Team')</script>");
            } else {
                pw.write("<script> alert('Not Added the Team')</script>");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
