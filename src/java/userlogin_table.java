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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16122
 */
public class userlogin_table extends HttpServlet {

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
            ServletContext application = getServletConfig().getServletContext();
             String bt1 = request.getParameter("Login");
            String uname = request.getParameter("id");
            String pass = request.getParameter("password");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet userlogin_table</title>");            
            out.println("</head>");
            out.println("<body>");
           if(bt1.equals("Login"))
            {
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","root","");
                    PreparedStatement ps = con.prepareStatement("select* from user_login");
                    ResultSet rs = ps.executeQuery();
                    int count =0;
                    while(rs.next())
                    {
                        if(uname.equals(rs.getString(8)) && pass.equals(rs.getString(9)))
                        {
                            String username =rs.getString(8);
                            String userid=rs.getString(1);
                            application.setAttribute("username",username);
                            application.setAttribute("userid", userid);
                            RequestDispatcher rd = request.getRequestDispatcher("home2.jsp");
                             String htmlResponse = "<html>";
                                htmlResponse += "<h2>Your username is: " + uname + "<br/>";       
   
                                 htmlResponse += "</html>";  
                           rd.forward(request, response);
                            //response.sendRedirect("welcomehomepage.html");"
                            count++;
                        }   
                        
                    }
                        if(count == 0)
                        {
                             out.println("<html><body><script>alert('wrong id or password');window.location.assign('user_login.html');</script></body></html>");
                            
                        }
                        con.close();
                    
                }
                catch(Exception e)
                {
                    out.println("exception : "+e);
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
