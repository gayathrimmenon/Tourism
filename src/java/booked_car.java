/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
public class booked_car extends HttpServlet {

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
            out.println("<title>Servlet booked_car</title>");            
            out.println("</head>");
            out.println("<body>");
           try
            {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con=(java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
                PreparedStatement stmt=con.prepareStatement("select * from car");
                ResultSet rs=stmt.executeQuery(); 
               
                       
            out.println("<center>");
           out.println("<h1 style='font-family:'arial';font-color:'maroon' '>Guide Details</h1>");
            out.println("<table border=1 width=10% height=50% align=center>"
                    + "<tr><th>u_id </th>"
                    +"<th>Destination </th>"
                    
                    +"<th>Car Type </th>"
                    +"<th>Date </th>"
                   
                    +"<th>Total Amt </th>"
                    
                    +"</tr>");
            String dest,date,u_id,type,amt;
            while(rs.next())
                {
                    
                    dest=rs.getString(1);
                    type=rs.getString(2);
                    amt=rs.getString(3);
                    date=rs.getString(4);
                    u_id=rs.getString(5);
                    
                   
               
                    out.println("<tr style=color:crimson red>"
                        +"<td>" +u_id +"</td>"
                        +"<td>" + dest +"</td>"
                        + "<td>" + type + "</td>"
                        +"<td>" + date +"</td>"
                        +"<td>" + amt +"</td>"
                        
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
