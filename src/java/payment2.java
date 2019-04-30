/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16122
 */
public class payment2 extends HttpServlet {

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
            
            String fullname=request.getParameter("fullname");
            
            String email=request.getParameter("email");
            String Address=request.getParameter("address");
            
            String city=request.getParameter("city");
            
            String state=request.getParameter("state");
            
            String u_id=request.getParameter("u_id");
            
            //int uid = Integer.parseInt(u_id);
            
            String package_selected=request.getParameter("package_selected");
            out.print("AMMA");
            String travel_mode=request.getParameter("travel_mode");
            String no_of_persons =request.getParameter("nop");
             //int nop = Integer.parseInt(no_of_persons);
            String flight_from=request.getParameter("flight_from");
            String flight_to=request.getParameter("flight_to");
            String train_from=request.getParameter("train_from");
            String train_to=request.getParameter("train_to");
            String name_on_card=request.getParameter("cardname");
            String card_no=request.getParameter("cardnumber");
             //int cardno = Integer.parseInt(card_no);
            String exp_month=request.getParameter("expmonth");
            String exp_year=request.getParameter("expyear");
            int exp=Integer.parseInt(exp_year);
            String cvv=request.getParameter("cvv");
             //int cvv_no = Integer.parseInt(cvv);
            String total=request.getParameter("amt");
             //int total_amt = Integer.parseInt(total);
             Date today = new Date(); 
             Calendar cal = Calendar.getInstance();
              cal.setTime(today); 
             int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet payment</title>");            
            out.println("</head>");
            out.println("<body>");
            
            try
              {
               Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con=(java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
                /*Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","root","");*/
                out.println("hii");
                PreparedStatement ps   =  con.prepareStatement("insert into payment values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                out.println("hiit");
               //out.println("<html><head></head><body onload=\"alert('Your booking is done!')\"></body></html>");
              // out.println("<script type='text/javascript'>alert('Your booking is done');window.location('booking.html');</script>");
               
               
                ps.setString(1,fullname);
              ps.setString(2,email);
                ps.setString(3,Address);
                ps.setString(4,city);
                ps.setString(5,state);
                ps.setString(6,u_id);
                ps.setString(7,package_selected);
                ps.setString(8,travel_mode);
                ps.setString(9,no_of_persons);
                ps.setString(10,flight_from);
                ps.setString(11,flight_to);
                ps.setString(12,train_from);
                ps.setString(13,train_to);
                ps.setString(14,name_on_card);
                ps.setString(15, card_no);
                ps.setString(16,exp_month);
                ps.setString(17,exp_year);
                ps.setString(18, cvv);
                ps.setString(19,total);
                
               
                ps.setString(20,"yes");
                 out.println("<html><body><script>alert('Your payment is done');window.location.assign('home2.jsp');</script></body></html>");
                
               
                ps.executeUpdate();
                out.println(ps.toString());
                con.close();
                
                
             
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
