
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
                        
  
 <style>
         .mapouter
         {  
             position:relative;
             text-align:right;
             left:1px;
             bottom: 25%;
             right:30%;
             height:500px;
             width:600px;
         }
         .gmap_canvas
         {
             overflow:hidden;
             background:none!important;
             height:500px;
             width:600px;
         }
       


h1 {
    font-size: 35px;
    left:60px;
    text-transform: uppercase;
    font-family: monospace;
    font-weight: 600;
    margin-bottom: 30px;
  }
 
.p1{
    font-size: 12px;
    text-transform: uppercase;
    font-family: arial;
    font-weight: 600;
    margin-bottom: 30px;
    color:#ff6600;
  }
  .p2{
    font-size: 25px;
    text-transform: uppercase;
    font-family: monospace;
    font-weight: 600;
    margin-bottom: 30px;
    color:#ff6600;
    font-stretch: semi-expanded;
  }
  p{
      font-size:30px;
      font-family:monospace;
  }
.navbar {
  overflow: hidden;
  background-color: rgba(0,0,0, 0.4);
}

.navbar a {
  float: left;
  top:10%;
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 10px;
  text-decoration: none;
}
.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}
.navbar a.logo {
  font-size: 25px;
  font-weight: bold;
  font-family: monospace;
}
.navbar-right {
  float: right;
  font-family: monospace;
  font-size: 25px;
}
 
.dropdown {
  float: right;
  font-size: 20%;  
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
    letter-spacing: 4px;
    border-radius: 0;
    font-family: Montserrat, sans-serif;
}

.dropdown .dropbtn {
 
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}


.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color:  #ff471a;
}

.dropdown:hover .dropdown-content {
  display: block;
}

 html,body {
    height:100%;
    width:100%;
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
 .bg
            {
                height: 100%; 
         
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
            }

  .jumbotron {
    
   
    font-family: Montserrat, sans-serif;
   
  }

  .bg-text {
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0, 0.4); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  font-size: 40px;
  font-family: harrington;
  border: 7px solid #f1f1f1;
  position: absolute;
  top: 34%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 500px;
  padding: 5px;
  text-align: center;
  
}
.bg-tx {
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0, 0); /* Black w/opacity/see-through */
  color: white;
  font-weight: bold;
  font-size: 40px;
  font-family: harrington;
  
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 20%;
  padding: 5px;
  text-align: center;
  
}
* {
  box-sizing: border-box;
}

.container2 {
  position: absolute;
  width: 600px;
  height: 50%;
  top:15%;
  right:200%;
  left: -1%;
  
  margin: 0 auto;
}

.container2 img {vertical-align: middle;}

.container2 .content 
{
  position: absolute;
  top:16%;
  
  background: rgb(0, 0, 0); /* Fallback color */
  background: rgba(0, 0, 0, 0.6); /* Black background with 0.5 opacity */
  color: #f1f1f1;
  width: 500%;
  padding: 111px;
}
.div2{
    float:left;
    text-align: left;
}
.open-button {
  background-color: #29a329;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: absolute;
  width: 280px;
  float: left;
  left:44%;
  overflow: hidden;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container2 {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container2 input[type=text], .form-container2 input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container2 input[type=text]:focus, .form-container2 input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container2 .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container2 .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container2 .btn:hover, .open-button:hover {
  opacity: 1;
}
p{
    color:white;
    font-size: 40px;
    font-family: monospace;
}
 td, th {
  border: 1px solid #ddd;
  padding: 8px;
}

 tr:nth-child(even){background-color: #f2f2f2;}

 tr:hover {background-color: #ddd;}
 th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 70%;
}

 </style>
      
    </head>
<body background="beach2.jpg" class="bg">

<div class="navbar">
     <a href="#default" class="logo">GnT Travels</a>
     <h3> <mark>WELCOME ${username}</mark></h3>
    <div class="navbar-right">
        <a href="home2.jsp">Home</a> &nbsp;&nbsp;&nbsp;
        <a href="maps.html">Resource Locator</a>&nbsp;&nbsp;&nbsp;
        <a href="Cost.html">Cost Estimation</a>
    <div class="dropdown">
    <button class="dropbtn">
      <i class='fas fa-gift' style='font-size:34px'></i>Packages 
    </button>
    <div class="dropdown-content">
      <a href="booking.html">Domestic</a>
      <a href="inter1.html">International</a>
     
    </div>
  </div> 
    <a href="LogoutServlet1">Logout</a>
  </div>
</div>
   
   
</div>

<script>
function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}
</script>
    <%
  
     String uid = request.getParameter("g_id");        
    
   

    session.setAttribute("g_id",uid);
  
    
    
    %>
 <%  
    try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
                PreparedStatement stmt=con.prepareStatement("select * from guide where g_id=?");
                 stmt.setString(1,uid);
                ResultSet rs=stmt.executeQuery(); 
               
                      
            out.println("<center>");
           out.println("<h1 style='font-family:'arial';font-color:'maroon' '><mark>Guide Details<MARK></h1>");
            out.println("<table border=1 width=10% height=50% align=center>"
                     + "<tr><th>g_id </th>"
                    + "<th>Name </th>"
                    +"<th>Age </th>"
                    
                    +"<th>Address </th>"
                    +"<th>Country </th>"
                   
                    +"<th>EmailId </th>"
                     +"<th>Qualification </th>"
                     +"<th>Experience</th>"
                    +"<th>Contact </th>"
                    +"<th>LoginId </th>"
                   
                  
                    +"</tr>");
            String name,age,address,country,emailid,contact,loginid,qualification,experience,g_id;
            while(rs.next())
                {
                    g_id=rs.getString(1);
                    name=rs.getString(2);
                    age=rs.getString(3);
                    address=rs.getString(4);
                    country=rs.getString(5);
                    emailid=rs.getString(6);
                    qualification=rs.getString(7);
                    experience=rs.getString(8);
                    contact=rs.getString(9);
                    loginid=rs.getString(10);
                   
               
                    out.println("<tr style=color:crimson red>"
                         +"<td>" + g_id +"</td>"
                        +"<td>" + name +"</td>"
                        +"<td>" + age +"</td>"
                        + "<td>" + address + "</td>"
                        +"<td>" + country +"</td>"
                        +"<td>" + emailid +"</td>"
                        +"<td>" + qualification +"</td>"
                        +"<td>" + experience +"</td>"
                                
                        +"<td>" + contact +"</td>"
                        +"<td>" + loginid +"</td>"
                       
                       
                        + "</tr>");
                    
                }
            }
            catch(Exception e)
            {
                out.println("Exception : "+e);
            }
            out.println("</table>");
              
          
%>
    </body>
</html>
