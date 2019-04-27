

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
                background-color:#990033;
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
                width:100px;
                height:90px;
                background-color: lightgrey;
                color: #990033;
            }
            a {
  float: right;
  width: 20%;
  text-align: center;
  padding: 12px 0;
  transition: all 0.3s ease;
  color: white;
  font-size: 36px;
}

.icon-bar a:hover {
  background-color: #000;
}

.active {
  background-color: #4CAF50;
}
 </style>
    </head>
    <body class="color">
       
        <h3>Welcome ${username}</h3>
         <a class="active" href="LogoutServlet1" target="_parent"><i class="fa fa-home"></i></a> 
        <form action="user_one" method="POST">
            <input type="submit" class="button button1" value="User Details" formtarget="f2" vspace="10">
        </form>
        
        <form action="booking_one" method="POST">
            <input type="submit" class="button button1" value="BOOKED tickets" formtarget="f2" vspace="10"> 
        </form>
        
              
         <form action="guide_id.html" method="POST">
            <input type="submit" class="button button1" value="Message from Admin " formtarget="f2" vspace="10"> 
        </form>
        
         <form action="msg_admin.html" method="POST">
            <input type="submit" class="button button1" value="Message to Admin " formtarget="f2" vspace="10"> 
        </form>
        
       
    </body>
</html>
