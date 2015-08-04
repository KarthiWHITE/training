/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import userclasses.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utils.DbUtils;

/**
 *
 * @author cb-admin1
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        if (request.getSession().getAttribute("userid") != null) {
            request.setAttribute("curuser", User.getUser(request.getSession().getAttribute("userid").toString()));
            response.sendRedirect("userabout");
        } else {
            if (request.getParameter("email") != null) {
                Connection con = DbUtils.getConnection();
                PreparedStatement stmt = con.prepareStatement("select * from user where email=? and password=?");
                stmt.setString(1, request.getParameter("email"));
                stmt.setString(2, request.getParameter("password"));
                ResultSet set = stmt.executeQuery();
                if (set.next()) {
                    String id = set.getString("id");
                    HttpSession session = request.getSession(true);
                    session.setAttribute("userid", id);
                    session.setAttribute("username", set.getString("name"));
                    request.setAttribute("login", "success");
                    request.setAttribute("curuser", User.getUser(id));
                    response.sendRedirect("userabout");
              
                }else{
                    loginFailedRedirect(request, response);
                }
            } else {
                    loginFailedRedirect(request, response);
            }
        }
    }

    private void loginFailedRedirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            request.setAttribute("login", "fail");
                RequestDispatcher rd = request.getRequestDispatcher("login");
                rd.forward(request, response);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
