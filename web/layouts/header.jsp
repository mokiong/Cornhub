<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import= "utility.CookieHelper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="styles/styles.css">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid" style="background-color:black">
		<div class="container navbar navbar-expand-lg navbar-dark bg-black" style="background-color:black;" >
				<div class="col-md-3">
		            <a href="home" ><img class="img-logo" src="images/logo.png" style="color: #ffa31a; height:50px; width:100px"></a>
		        </div>
		        <div class="col-md 5">
		        
		        </div>
		        <div class="col-md-2">    
		            <form action = "">
			            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			              <span class="navbar-toggler-icon"></span>
			            </button>
		            </form>
		        </div>
		        <div class="col-md-1"></div>
		        <div class="col-md-2">
		        	<% 
	        		Cookie cookies[] = request.getCookies();
	    			Cookie user = CookieHelper.getCookie(cookies, "userAccount");
	        		
	    			if(user == null){
	        		
	        		%>
	        		<a href="login" style="color:#ffa31a; text-decoration: none;">
		        		<i class="fa fa-user-o" aria-hidden="true" style="color:#ffa31a"></i>
		        		<span id="user" class="colOrange" style="color:#ffa31a"></span>
	        		</a>	   
	        	<%} else {%> 
	            <a  href="logout" style="color:#ffa31a; text-decoration: none;">
	            	<i class="fa fa-user-o" aria-hidden="true" style="color:#ffa31a"></i>
	            	<span id="user" class="colOrange" style="color:#ffa31a"></span>
	            </a>
	            <%}%>
	            </div>
	          
	            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="color: #ffa31a">
	            	<i class="fa fa-cart-plus" aria-hidden="true"></i>
	            	
	            	<ul class="navbar-nav mr-auto">
		                <li class="nav-item active">
		                  <a class="nav-link" href="my-cart" style="color: #ffa31a" style="font-family:arial">My Cart<span class="sr-only">(current)</span></a>
		                </li>
	                </ul>
	            </div>
	        </div>
		</div>
		<div class = "container-fluid">
			<div class= "row">
				<div style="width: 100%; height: 2px; background-color: #ffa31a;"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
			var cookname = document.cookie;
			var sub = cookname.substring(12,cookname.length);
			var user = document.getElementById("user");
			
			if(cookname != ""){
				user.className += "colOrange";
				user.innerHTML = sub.toUpperCase();
			} else {
				user.className += "colOrange";
				user.innerHTML = "login/register";
			}
			
			
	</script>
</body>
</html>