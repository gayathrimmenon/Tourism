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
import javax.servlet.http.HttpSession;

/**
 *
 * @author KHSCI5MCA16122
 */
public class Session extends HttpServlet {

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
            HttpSession session = request.getSession();
            String uid = (String)session.getAttribute("u_id");
            String name="",age="",address="",country="",emailid="",contact="",loginid="",password,ticket="",from="",to="",hotel="",transport="",guide="",startdate="",enddate="",userid="",email="",bookingid="";
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Session</title>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
                PreparedStatement ps = con.prepareStatement("select user_login.* from user_login  inner join booking on user_login.u_id=booking.u_id where user_login.u_id =? ");
 


                ps.setString(1,uid);
                out.println("<h3 style='padding-left:50%'><br><br><br><br><br><br>USER-ID :<br> "+uid+"</h3>");
                
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
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
                    
                     guide=rs.getString(20);
                   
               
                    
               
               out.println("NAME : "+name+ "<br>"+
                       "DATE : "+age+     "<br>"+
                        "DATE : "+address+     "<br>"+
                         "DATE : "+country+     "<br>"+
                       " Time : "+emailid+    "<br>"+
                         "DATE : "+contact+     "<br>"+
                        "DATE : "+loginid+     "<br>"+
                       
                       "<br>");
               out.println("<br><center><h1 style='font-family:Mongolian Baiti;color:#088A85;'>Your Booking Details </h1><center>");
               out.println("NAME : "+from+ "<br>"+
                       "DATE : "+to+     "<br>"+
                        "DATE : "+startdate+     "<br>"+
                         "DATE : "+enddate+     "<br>"+
                       " Time : "+hotel+    "<br>"+
                         "DATE : "+transport+     "<br>"+
                        "DATE : "+ticket+     "<br>"+
                        "DATE : "+bookingid+     "<br>"+
                         
                       "DATE : "+guide+     "<br>"+
                       "<br>");
                } 
            }
            catch(Exception e)
            {
                out.println(e);
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
