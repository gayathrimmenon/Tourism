/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16122
 */
public class available extends HttpServlet {

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
           
            String b_id = request.getParameter("b_id");
            int bid = Integer.parseInt(b_id);
           
          
            String from = request.getParameter("from");
            String to = request.getParameter("to");
           
            
           String g_id = request.getParameter("g_id");
           String startdate= request.getParameter("start");
            String enddate= request.getParameter("end");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet available</title>");            
            out.println("</head>");
            out.println("<body>");
            try
              {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","root","");
                
                PreparedStatement ps   =  con.prepareStatement("insert into availableguide values(?,?,?,?,?,?)");
                
               //out.println("<html><head></head><body onload=\"alert('Your booking is done!')\"></body></html>");
              // out.println("<script type='text/javascript'>alert('Your booking is done');window.location('booking.html');</script>");
               
               
                ps.setString(1,from);
                ps.setString(2,to);
                ps.setString(3,startdate);
                ps.setString(4,enddate);
               
            
                ps.setInt(5, bid);
                ps.setString(6,g_id);
                 
                
                ps.executeUpdate();
                con.close();
                out.println("<html><body><script>alert('your booking is done');window.location.assign('homepage.html');</script></body></html>");
                
                
                
                
                
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
