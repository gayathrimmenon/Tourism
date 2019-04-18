
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

 </style>
      
    </head>
<body background="bg3.jpg" class="bg">

<div class="navbar">
     <a href="#default" class="logo">GnT Travels</a>
     <h3> WELCOME ${username}</h3>
    <div class="navbar-right">
        <a href="home.html"> <i class='fas fa-home' style='font-size:38px;'></i></a>&nbsp;&nbsp;&nbsp;
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
    
    <%
  
     String uid = request.getParameter("id");        
    String password = request.getParameter("password");
    String name="",age="",address="",country="",emailid="",contact="",loginid="",ticket="",from="",to="",hotel="",transport="",guide="",startdate="",enddate="",userid="",email="",bookingid="";

    session.setAttribute("id",uid);
    session.setAttribute("password", password);
    
    
    %>
 <%  
     try
   {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con=(java.sql.Connection) DriverManager.getConnection("jdbc:mysql://localhost/tourism","root","");
        PreparedStatement ps = con.prepareStatement("select user_login.* from user_login  inner join booking on user_login.u_id=booking.u_id where user_login.u_id =? ");
            
          ps.setString(1,uid);
 
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
out.println("Exception : "+e);
}
%>
    </body>
</html>
