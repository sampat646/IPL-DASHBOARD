package com.ipl.team;

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

@WebServlet("/View-member")
public class DisplayingTeamMembers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teamName = req.getParameter("team-name");
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_ipldb", "<user&password>",
                    "<user&password>");

            PreparedStatement pst = conn.prepareStatement("select * from ipl where PlayerIplteam=?");
            pst.setString(1, teamName);
            ResultSet rs = pst.executeQuery();
            req.setAttribute("iplList", rs);
            req.getRequestDispatcher("DisplayMembers.jsp").forward(req, resp);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
