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
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16122
 */
public class inter_one extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet inter_one</title>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
                PreparedStatement stmt=con.prepareStatement("select * from international");
                ResultSet rs=stmt.executeQuery(); 
               
                       
            out.println("<center>");
           out.println("<h1 style='font-family:'arial';font-color:'maroon' '>Booking Details of International Trips</h1>");
            out.println("<table border=1 width=10% height=50% align=center>"
                    
                    
                    +"<tr><th> From</th>"
                    
                    +"<th>To </th>"
                    +"<th>Start Date </th>"
                    +"<th>End Date </th>"
                    +"<th>Hotel </th>"
                   
                    +"<th>Transport </th>"
                    +"<th>LoginId </th>"
                     + "<th>No Of People </th>"
                     +"<th>Email </th>"
                     +"<th>Guide </th>"
                     +"<th>Guide_taken </th>"
                   
                  
                    +"</tr>");
            String ticket,from,to,hotel,transport,guide,startdate,enddate,loginid,email,guide_taken;
            while(rs.next())
                {
                    
                    loginid=rs.getString(7);
                    from=rs.getString(1);
                    to=rs.getString(2);
                    startdate=rs.getString(3);
                    enddate=rs.getString(4);
                    hotel=rs.getString(5);
                    transport=rs.getString(6);
                    guide=rs.getString(10);
                    ticket=rs.getString(8);
                    email=rs.getString(9);
                    guide_taken=rs.getString(12);
                   
               
                    out.println("<tr style=color:crimson red>"
                        
                        +"<td>" + from +"</td>"
                        + "<td>" + to + "</td>"
                        +"<td>" + startdate +"</td>"
                        +"<td>" + enddate +"</td>"
                        +"<td>" + hotel +"</td>"
                        +"<td>" + transport +"</td>"
                        +"<td>" + loginid +"</td>"
                        
                        +"<td>" + ticket +"</td>"
                        +"<td>" + email +"</td>"
                         +"<td>" + guide +"</td>"
                                
                        
                       
                        + "</tr>");
                    
                }
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
            out.println("</table>");
            
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
