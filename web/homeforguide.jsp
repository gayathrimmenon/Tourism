<%-- 
    Document   : homeforguide
    Created on : Apr 1, 2019, 12:59:05 PM
    Author     : KHSCI5MCA16122
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <style>
            .color
            {
                background:url("texture3.jpeg");
            }
            .button
            {
                -webkit-transition-duration: 0.4s; /* Safari */
                transition-duration: 0.4s;
                border-radius: 15px;
            }
            .button1:hover
            {
                border-radius: 15px;
                width:150px;
                height:90px;
                background-color: lightgrey;
                
                        .home {
  float: right;
  width: 20%;
  text-align: center;
  padding: 12px 0;
  transition: all 0.3s ease;
  color: white;
  font-size: 56px;
}

 a:hover {
  background-color: #000;
}

.active {
  background-color: #4CAF50;
}
        </style>
    </head>
    <body class="color">
       
        <h3>Welcome ${username}</h3>
         
        <form action="user_one" method="POST">
            <input type="submit" class="button button1" value="User Details" formtarget="f2" vspace="10">
        </form>
        
        <form action="booking_one" method="POST">
            <input type="submit" class="button button1" value="Domestic tickets" formtarget="f2" vspace="10"> 
        </form>
        
        <form action="inter_one" method="POST">
            <input type="submit" class="button button1" value="International booked tickets" formtarget="f2" vspace="10"> 
        </form>
         <form action="msgfrom_admin" method="POST">
            <input type="submit" class="button button1" value="Message from Admin " formtarget="f2" vspace="10"> 
        </form>
         <form action="msg_admin.html" method="POST">
            <input type="submit" class="button button1" value="Message to Admin " formtarget="f2" vspace="10"> 
        </form>
        
        <a class="home" href="LogoutServlet1" target="_parent"><i class="fa fa-home"></i></a> 
    </body>
</html>
