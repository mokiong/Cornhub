<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" sizes="32x32" href="images/favicon.png">

<title>Cornhub</title>
</head>
<body style="background-color:#292929 ">
<%@ include file="./layouts/header.jsp"%>
<style type="text/css">
	.orangeBtn{
    background-color:white;
    border-color: #292929;
    color: #292929;
}

.orangeBtn:hover{
    background-color:#292929;
    border-color: #292929;
    color: white;
}
</style>
	<div class="container-fluid">
		<div class="jumbotron" style="margin: 30px 100px 30px 100px">
		  <h2 class="display-4 d-flex justify-content-center" style="color:orangered;">Error500</h2>
		  <h4 class="ml-4 d-flex justify-content-center">Server Error! Sorry for the inconvenience</h4>
		
		  <a href="home" class="orangeBtn" style="text-decoration: none; color:#ffa31a;"><button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect orangeBtn" type="submit">Go back</button></a>
		
		</div>	

	</div>
	<%@ include file="./layouts/footer.jsp"%>
</body>
</html>