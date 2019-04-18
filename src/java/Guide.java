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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author KHSCI5MCA16122
 */
public class Guide extends HttpServlet {

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
             String name=request.getParameter("firstname");
            String age=request.getParameter("age");
            String address=request.getParameter("address");
            String country=request.getParameter("country");
            String Email=request.getParameter("email");
            String Qualification=request.getParameter("qualification");
            String Experience=request.getParameter("experience");
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
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tourism","root","");
               
                PreparedStatement ps = con.prepareStatement("insert into guide values(?,?,?,?,?,?,?,?,?,?)");
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
                        "a:link, a:visited {"+
                            "background-color: #f44336;"+
                            "color: white;"+
                           " padding: 15px 25px;"+
                           " text-align: center;"+
                           " text-decoration: none;"+
                            "display: inline-block;"+
"}"+

"a:hover, a:active {"+
  "background-color: red;"+
"}"+
"            input,textarea\n" +
"            {\n" +
"                background: rgba(255,255,255,0.4);\n" +
"                margin:none auto;\n" +
"                padding: 10px;\n" +
"            }\n" +
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
                        + "<h1 style=\"font-family: monospace\">Your account has been created!!</h1>\n" +
                     "<br><br><a href= 'comp.html'>Home</a>"+
"                      </div>\n" +
"                    </div>\n" +
"        </div>");
 
            
                ps.setString(1,name);
                ps.setString(2,age);
                ps.setString(3,address);
                ps.setString(4,country);
                ps.setString(5,Email );
                ps.setString(6,Qualification);
                ps.setString(7,Experience );
                ps.setString(8,Contact);
                ps.setString(9,Loginid);
                ps.setString(10,Password);
                
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
