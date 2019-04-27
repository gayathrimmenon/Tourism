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
public class payment_one extends HttpServlet {

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
            out.println("<title>Servlet payment_one</title>");            
            out.println("</head>");
            out.println("<body>");
             try
            {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con=(java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
                PreparedStatement stmt=con.prepareStatement("select * from payment");
                ResultSet rs=stmt.executeQuery(); 
               
                       
            out.println("<center>");
           out.println("<h1 style='font-family:'arial';font-color:'maroon' '>Payment Details</h1>");
            out.println("<table border=1 width=10% height=50% align=center>"
                    + "<tr><th>User_Id </th>"
                     + "<tr><th>Booking_Id </th>"
                    + "<th>FullName </th>"
                    +"<th>EmailId </th>"
                    
                    +"<th>Address </th>"
                    +"<th>City </th>"
                    +"<th>State </th>"
                    +"<th>Package selected </th>"
                    +"<th>travel mode </th>"
                    +"<th> No of persons</th>"
                    +"<th> flight from</th>"
                     +"<th> flight to</th>"
                    +"<th>Train From </th>"
                    +"<th>Train To </th>"
                    +"<th> Name on Card</th>"
                    +"<th>Card Number </th>"
                    +"<th>Expiry Month</th>"
                    +"<th>Expiry Year</th>"
                    +"<th>CVV</th>"
                    +"<th>Total Amt </th>"
                    +"<th>Payed?</th>"
                  
                    +"</tr>");
            String u_id,b_id,name,address,city,state,emailid,pack,travelmode,nop,flight_from,flight_to,train_from,train_to,cardname,cardno,cvv,expmonth,expyear,total,payed;
            while(rs.next())
                {
                    u_id=rs.getString(6);
                    b_id=rs.getString(7);
                    name=rs.getString(1);
                     emailid=rs.getString(2);
                    address=rs.getString(3);
                    city=rs.getString(4);
                    state=rs.getString(5);
                    pack=rs.getString(8);
                    travelmode=rs.getString(9);
                    nop=rs.getString(10);
                   flight_from=rs.getString(11);
                     flight_to=rs.getString(12);
                     train_from=rs.getString(13);
                     train_to=rs.getString(14);
                     cardname=rs.getString(15);
                     cardno=rs.getString(16);
                     cvv=rs.getString(17);
                     expmonth=rs.getString(18);
                    expyear=rs.getString(19);
                     total=rs.getString(20);
                    payed=rs.getString(21);
                                  
                       
              
                    out.println("<tr style=color:crimson red>"
                        +"<td>" + u_id +"</td>"
                                +"<td>" + b_id +"</td>"
                        +"<td>" + name +"</td>"
                       +"<td>" + emailid +"</td>"
                        + "<td>" + address + "</td>"
                        +"<td>" + city +"</td>"
                         +"<td>" + state +"</td>"
                        +"<td>" +pack  +"</td>"
                        +"<td>" + travelmode +"</td>"
                         +"<td>" + nop +"</td>"       
                        +"<td>" + flight_from +"</td>"
                       +"<td>" + flight_to +"</td>"
                        +"<td>" + train_from +"</td>"
                      +"<td>" + train_to +"</td>"  
                        +"<td>" + cardname +"</td>"
                       +"<td>" + cardno +"</td>"
                       +"<td>" + cvv +"</td>"
                        +"<td>" + expmonth +"</td>"
                     +"<td>" + expyear +"</td>"
                        +"<td>" + total +"</td>" 
                          +"<td>" + payed +"</td>"
                        + "</tr>");
                    
                }
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
