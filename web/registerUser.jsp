<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cornhub</title>
</head>
<body class="bg-grey">
	<%@ include file="./layouts/header.jsp"%>
	<div class="container-fluid">
	 <div class="wrapper fadeInDown">
        <div id="formContent">
          <div class="container bg-black">
            <div class="fadeIn first">
                <img src="images/cornhub-logo.png" id="icon" alt="User Icon" />
              </div>
          
              <!-- Login Form -->
              <form action="RegisterUser" method="POST">
              	
                <input type="text" id="login" class="fadeIn second" name="firstName" placeholder="FIRSTNAME" required>
                <input type="text" id="login" class="fadeIn second" name="lastName" placeholder="LASTNAME" required>
                <input type="text" id="login" class="fadeIn third" name="email" placeholder="EMAIL" required>
                <input required type="password" id="password" class="fadeIn third" name="password" placeholder="PASSWORD" style="background-color: #f6f6f6;
    border: none;
    color: #0d0d0d;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 5px;
    width: 85%;
    border: 2px solid #f6f6f6;
    -webkit-transition: all 0.5s ease-in-out;
    -moz-transition: all 0.5s ease-in-out;
    -ms-transition: all 0.5s ease-in-out;
    -o-transition: all 0.5s ease-in-out;
    transition: all 0.5s ease-in-out;
    -webkit-border-radius: 5px 5px 5px 5px;
    border-radius: 5px 5px 5px 5px;">
                <input type="hidden" id="login" name="isPremium" value="false">
                <input type="hidden" id="login" name="tier" value="0">
                <input type="submit" class="fadeIn fourth bg-orange" value="Register">
              </form>     
          </div>
        </div>
      </div>
      </div>
	<%@ include file="./layouts/footer.jsp"%>
	<link rel="stylesheet" href="styles/login.css">
</body>
</html>