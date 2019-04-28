/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
            
            int b_id = 0;
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
                
            int syear,eyear,smonth,emonth,sday,eday;

            
            syear=Integer.parseInt(startdate.substring(0,4));
            smonth=Integer.parseInt(startdate.substring(5,7));
            sday=Integer.parseInt(startdate.substring(8,10));
            
            eyear=Integer.parseInt(enddate.substring(0,4));
            emonth=Integer.parseInt(enddate.substring(5,7));
            eday=Integer.parseInt(enddate.substring(8,10));
            
            Calendar cal = Calendar. getInstance();
            java.util.Date date=cal. getTime();
            
            int cyear,cmonth,cday,c=0;
            cyear=cal.get(Calendar.YEAR);
            cmonth=cal.get(Calendar.MONTH);
            cday=cal.get(Calendar.DAY_OF_MONTH);
            
            /*if(!(syear>=cyear && smonth>=cmonth && sday>=cday))
                 out.println("<html><body><script>alert('You have selected an invalid date (You have selected the starting date as a past date)');window.location.assign('booking.html');</script></body></html>");
            else  if(!(eyear>=cyear && emonth>=cmonth && eday>=cday))
                 out.println("<html><body><script>alert('You have selected an invalid date (You have selected the ending date as a past date)');window.location.assign('booking.html');</script></body></html>");
               */ 
            int count = 0;
            if((eyear-syear)>0)
            {
                out.println("<html><body><script>alert('Trip cannot be booked for over a year ');</script></body></html>");
                count ++ ;
            }
                if((emonth-smonth)>1 )
                {
                  out.println("<html><body><script>alert('Trip cannot be booked for over a month');</script></body></html>");
                  count++;
                }
                  if(!(nop<=20&&nop>0))
                    {
                        out.println("<html><body><script>alert('No of persons should be between 0 and 20 ');</script></body></html>");
                        count++;
                    }
                if(count > 0)
                {
                   out.println("<script>window.location.assign('booking.html');</script>") ;
                }
            
            
              else{   
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
                out.println("hii");
                PreparedStatement ps   =  con.prepareStatement("insert into booking values(?,?,?,?,?,?,?,?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                
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
                ps.setInt(9, b_id);
                ps.setString(10,email);
                ps.setString(11,guide);
                ps.setString(12, "-");
                ps.setString(13, "0");
                b_id++;
                ps.executeUpdate();
                con.close();
                out.println("<html><body><script>alert('your booking is done');window.location.assign('booking.html');</script></body></html>");
                
                
                
                 
                
            }
            catch(Exception e) 
            {
                out.println("Exception : "+e);
            }
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
