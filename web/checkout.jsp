<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" sizes="32x32" href="images/favicon.png">
<title>Cornub</title>
</head>
<body>
	<%@ include file="./layouts/header.jsp"%>
	<div class="card">

    <h5 class="card-header info-color white-text text-center py-4">
        <strong style="color:orangered">CHECKOUT</strong>
    </h5>

    <!--Card content-->
    <div class="card-body px-lg-5 mx-auto">

        <!-- Form -->
        
        <form class="text-center" style="color: #757575;" action="checkout" method="POST">
		
            <p><strong>Just one step away to get your high quality corn</strong></p>

         

            <!-- Name -->
            <div class="md-form mt-3">
                <input type="text" id="materialSubscriptionFormPasswords" class="form-control" name="name" required>
                <label for="materialSubscriptionFormPasswords">Name</label>
            </div>

            <!-- E-mai -->
            <div class="md-form">
                <input type="text" id="materialSubscriptionFormEmail" class="form-control"name="address" required>
                <label for="materialSubscriptionFormEmail">Address</label>
            </div>

            <!-- Sign in button -->
            <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect" type="submit" style="background-color:orangered; border-color:orangered; color:white">Submit</button>

        </form>
        <!-- Form -->

    </div>
</div>
	<%@ include file="./layouts/footer.jsp"%>
	<link rel="stylesheet" href="styles/checkout.css">
</body>
</html>