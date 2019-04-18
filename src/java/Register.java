/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author khsci5mca16122
 */
public class Register extends HttpServlet {

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
            String u_id=request.getParameter("u_id");
            int uid = Integer.parseInt(u_id);
            String name=request.getParameter("firstname");
            String age=request.getParameter("age");
            int Age = Integer.parseInt(age);
            String address=request.getParameter("address");
            String country=request.getParameter("country");
            String Email=request.getParameter("email");
            String Contact=request.getParameter("contact");
            String Loginid=request.getParameter("id");
            String Password=request.getParameter("password");
           
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");            
            out.println("</head>");
            out.println("<body>");
             try
            {
                Class.forName("com.mysql.jdbc.Driver");
                 java.sql.Connection con=(java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
               
                PreparedStatement ps = con.prepareStatement("insert into user_login values(?,?,?,?,?,?,?,?,?)");
                out.println(" <style>\n" +
"            \n" +
"* {\n" +
"  box-sizing: border-box;\n" +
"}\n" +
"\n" +
".container2 {\n" +
"  position: relative;\n" +
"  max-width: 800px;\n" +
"  top:25%;\n" +
"  right:30%;\n" +
"  width:300%;\n" +
"  margin: 0 auto;\n" +
"}\n" +
"\n" +
".container2 img {vertical-align: middle;}\n" +
"\n" +
".container2 .content \n" +
"{\n" +
"  position: absolute;\n" +
"    background: rgb(0, 0, 0); /* Fallback color */\n" +
"  background: rgba(0, 0, 0, 0.6); /* Black background with 0.5 opacity */\n" +
"  color: #f1f1f1;\n" +
"  width: 250%;\n" +
"  height: 600px;\n" +
"  padding: 70px;\n" +
"  text-align: left;\n" +
"}\n" +
" .bg-text {\n" +
"  background-color: rgb(0,0,0); /* Fallback color */\n" +
"  background-color: rgba(0,0,0, 0); /* Black w/opacity/see-through */\n" +
"  color: white;\n" +
"  font-weight: bold;\n" +
"  border: 0 solid #f1f1f1;\n" +
"  position: absolute;\n" +
"  top: 30%;\n" +
"  left: 75%;\n" +
"  transform: translate(-50%, -38%);\n" +
"  z-index: 2;\n" +
"  width: 55%;\n" +
"  \n" +
"  text-align:left;\n" +
"}\n" +
"\n" +
"    \n" +
"\n" +
"  body, html\n" +
"  {\n" +
"  height: 100%;\n" +
"  margin: 0;\n" +
"  font-family: Arial, Helvetica, sans-serif;\n" +
"  font-size: 17px;\n" +
"}\n" +
".bg\n" +
"            {\n" +
"                height: 100%; \n" +
"            \n" +
"                background-position: center;\n" +
"                background-repeat: no-repeat;\n" +
"                background-size: cover;\n" +
"            }\n" +
"            input,textarea\n" +
"            {\n" +
"                background: rgba(255,255,255,0.4);\n" +
"                margin:none auto;\n" +
"                padding: 10px;\n" +
"            }\n" +
                         "a "+
                                 "            {\n" +
  
  "width: 20%;"+
  "text-align: center;"+
  "padding: 12px 0;"+
 " transition: all 0.3s ease;"+
  "color: white;"+
  "font-size: 36px;"+
"}"+

".icon-bar a:hover"+
                        "{"+
  "background-color: #000;"+
"}"+

".active "+
                        "{"+
  "background-color: #4CAF50;"+
"}"+
"\n" +
"      </style>\n" +
"    </head>\n" +
"    <body class=\"bg\" background=\"sea.jpg\"><div class=\"container2\" >     \n" +
"            <div class=\"content\">\n" +
"                <img src=\"bg3.jpg\">\n" +
"                    <div class=\"bg-text\">\n" +
"                        <center>"
                        + "<h1 style=\"font-family: monospace\"><u>GnT Travels</u></h1>"
                        + "</center><br>"
                        + "<h1 style=\"font-family: monospace\">Your account has been created!!</h1>\n" 
                        + "<a href=\"comp.html\">Home</h1><br>\n" 
                          + "<a href=\"user_login.html\">Login</h1>\n" +
"                      </div>\n" +
"                    </div>\n" +
"        </div>"
                );
                ps.setInt(1,uid);
                ps.setString(2,name);
                ps.setInt(3,Age);
                ps.setString(4,address);
                ps.setString(5,country);
                ps.setString(6,Email );
                ps.setString(7,Contact);
                ps.setString(8,Loginid);
                ps.setString(9,Password);
                
                 ps.executeUpdate();
                con.close();
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
