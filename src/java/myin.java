/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author KHSCI5MCA16122
 */
public class myin extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String ticket = request.getParameter("nop");
            int nop = Integer.parseInt(ticket);
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            String hotel = request.getParameter("hotel");
            String transport = request.getParameter("Transport");
            String guide = request.getParameter("guide");
            String startdate= request.getParameter("startdate");
            String enddate= request.getParameter("enddate");
            String loginid=request.getParameter("loginid");
            String email=request.getParameter("email");
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet book</title>");            
            out.println("</head>");
            out.println("<body>");
           
             try
              {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","root","");
                
                PreparedStatement ps1  =  con.prepareStatement("insert into international values(?,?,?,?,?,?,?,?,?,?)");
               
                ps1.setString(1,from);
                ps1.setString(2,to);
                ps1.setString(3,startdate);
                ps1.setString(4,enddate);
                ps1.setString(5,hotel);
                ps1.setString(6,transport);
                ps1.setString(7,loginid);
                ps1.setInt(8, nop);
                ps1.setString(9,email);
                ps1.setString(10,guide);
                
                ps1.executeUpdate();
                con.close();
                
                out.println("<html><body><script>alert('your booking is done');window.location.assign('checkin.html');</script></body></html>");

            }
            catch(Exception e) 
            {
                out.println("Exception : "+e);
            }
            out.println("<h1>Servlet myin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
