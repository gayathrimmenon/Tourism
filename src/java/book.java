/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16122
 */
public class book extends HttpServlet {

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
            String u_id = request.getParameter("u_id");
            int uid = Integer.parseInt(u_id);
            String b_id = request.getParameter("b_id");
            int bid = Integer.parseInt(b_id);
            String ticket = request.getParameter("nop");
            int nop = Integer.parseInt(ticket);
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            String hotel = request.getParameter("hotel");
            String transport = request.getParameter("Transport");
           String guide = request.getParameter("guide");
           String startdate= request.getParameter("startdate");
            String enddate= request.getParameter("enddate");
            
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
                
                PreparedStatement ps   =  con.prepareStatement("insert into booking values(?,?,?,?,?,?,?,?,?,?,?)");
                
               //out.println("<html><head></head><body onload=\"alert('Your booking is done!')\"></body></html>");
              // out.println("<script type='text/javascript'>alert('Your booking is done');window.location('booking.html');</script>");
               
               
                ps.setString(1,from);
                ps.setString(2,to);
                ps.setString(3,startdate);
                ps.setString(4,enddate);
                ps.setString(5,hotel);
                ps.setString(6,transport);
                ps.setInt(7,nop);
                ps.setInt(8, uid);
                ps.setInt(9, bid);
                ps.setString(10,email);
                 ps.setString(11,guide);
                
                ps.executeUpdate();
                con.close();
                out.println("<html><body><script>alert('your booking is done');window.location.assign('booking.html');</script></body></html>");
                
                
                
                
                
            }
            catch(Exception e) 
            {
                out.println("Exception : "+e);
            }
            
            
            
            
            
            
           
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
