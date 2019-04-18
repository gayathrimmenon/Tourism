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
public class join extends HttpServlet {

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
            out.println("<title>Servlet join</title>");            
            out.println("</head>");
            out.println("<body>");
           try
            {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con=(java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
                PreparedStatement stmt=con.prepareStatement("select * from user_login inner join booking on user_login.u_id=booking.u_id");
                ResultSet rs=stmt.executeQuery(); 
               
                       
            out.println("<center>");
           out.println("<h1 style='font-family:'arial';font-color:'maroon' '>Booking Details</h1>");
            out.println("<table border=1 width=10% height=50% align=center>"
                    
                    
                   + "<tr><th>User_Id </th>"
                    + "<th>Name </th>"
                    +"<th>Age </th>"
                    
                    +"<th>Address </th>"
                    +"<th>Country </th>"
                   
                    +"<th>EmailId </th>"
                    +"<th>Contact </th>"
                    +"<th>LoginId </th>"
                    +"<th> From</th>"
                    
                    +"<th>To </th>"
                    +"<th>Start Date </th>"
                    +"<th>End Date </th>"
                    +"<th>Hotel </th>"
                   
                    +"<th>Transport </th>"
                    
                     + "<th>No Of People </th>"
                   
                    +"<th>Booking Id </th>"
                     +"<th>Email </th>"
                     +"<th>Guide </th>"
                    
                  
                    +"</tr>");
            String u_id,name,age,address,country,emailid,contact,loginid,password,ticket,from,to,hotel,transport,guide,startdate,enddate,userid,email,bookingid;
            while(rs.next())
                {
                    u_id=rs.getString(1);
                    name=rs.getString(2);
                    age=rs.getString(3);
                    address=rs.getString(4);
                    country=rs.getString(5);
                    emailid=rs.getString(6);
                    contact=rs.getString(7);
                    loginid=rs.getString(8);
                    from=rs.getString(10);
                    to=rs.getString(11);
                    startdate=rs.getString(12);
                    enddate=rs.getString(13);
                    hotel=rs.getString(14);
                    transport=rs.getString(15);
                   
                    ticket=rs.getString(16);
                    
                    bookingid=rs.getString(18);
                    email=rs.getString(19);
                     guide=rs.getString(20);
                   
               
                    out.println("<tr style=color:crimson red>"
                        +"<td>" + u_id +"</td>"
                        +"<td>" + name +"</td>"
                        +"<td>" + age +"</td>"
                        + "<td>" + address + "</td>"
                        +"<td>" + country +"</td>"
                        +"<td>" + emailid +"</td>"
                        +"<td>" + contact +"</td>"
                        +"<td>" + loginid +"</td>"
                        
                        +"<td>" + from +"</td>"
                        + "<td>" + to + "</td>"
                        +"<td>" + startdate +"</td>"
                        +"<td>" + enddate +"</td>"
                        +"<td>" + hotel +"</td>"
                        +"<td>" + transport +"</td>"
                        +"<td>" + ticket +"</td>"
                       
                        +"<td>" + bookingid +"</td>"
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
