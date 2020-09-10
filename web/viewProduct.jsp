<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="javax.servlet.http.Cookie"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" sizes="32x32" href="images/favicon.png">
<title>Cornhub</title>
</head>
<body class="bg-grey">
	<%@ include file="./layouts/header.jsp"%>
    
	<div class="container mt-4 mb-4">
        
    <div class="card">
        <div class="row">
            <div class="col-sm-5">
                <img src="${angProdukto.imagePath}" class="imageSize card-img-top img-responsive" style="width: 100%; height: 100%">
            </div>
            <aside class="col-sm-7">
                <article class="card-body p-5">
                    <h3 class="title mb-3">${angProdukto.prodName}</h3>
    
                    <p class="price-detail-wrap"> 
                        <span class="price h3 text-warning"> 
                            <span class="currency">Php </span><span class="num">${angProdukto.prodPrice}</span>
                        </span> 
                        <span> Stock: ${angProdukto.stocks}</span> 
                    </p> <!-- price-detail-wrap .// -->
            <dl class="item-property">
    
        <hr>
        <div class="row">
        <div class="col-sm-5">
            
            
            <span>Quantity:</span> 
            <div class="p-3">
                <input form="form1" class="form-control" type="number" value="0" min="0" max="${angProdukto.stocks}" name="quantity"/>   
            </div>
  
        </div> <!-- col.// -->
    </div> <!-- row.// -->
        <hr>
        <div class="container">
            <div class="row-sm-12">
            	<% 
            		Cookie cooks[] = request.getCookies();
            		
            		Cookie cookieId = CookieHelper.getCookie(cooks, "userAccount");
            		if(cookieId == null){
            	%>
            		<a href="login" style="text-decoration:none"><button id="butt" type="submit" class="btn btn-lg btn-outline-primary btn-block text-uppercase mt-5 shop-btn" > 
            			<i class="fa fa-cart-plus"></i> Add to cart
            		</button></a>
            	<%	
            	} else {
            	%>
            	<form id=form1 action="cart.action" method="POST" class="mt-5">
            		<input type="hidden" name="prodId" value="${angProdukto.prodId}">
            		<input type="hidden" name="prodName" value="${angProdukto.prodName}">
            		<input type="hidden" name="prodPrice" value="${angProdukto.prodPrice}">
            		<input type="hidden" name="stocks" value="${angProdukto.stocks}">
            		<input type="hidden" name="imagePath" value="${angProdukto.imagePath}">
            		<button id="butt" type="submit" class="btn btn-lg btn-outline-primary btn-block text-uppercase mt-5 shop-btn" > 
            			<i class="fa fa-cart-plus"></i> Add to cart
            		</button>
            	</form>
                <% }%>
                <form action="all-product" method="GET">
                	<button type="submit" class="btn btn-lg btn-outline-primary btn-block text-uppercase mt-2 shop-btn">View other products</button>
                </form>
            </div>
            
        </div>
        
    </article> <!-- card-body.// -->
            </aside> <!-- col.// -->
        </div> <!-- row.// -->
    </div> <!-- card.// -->
    
    
    </div>
	<%@ include file="./layouts/footer.jsp"%>
	<link rel="stylesheet" href="styles/viewProd.css">

</body>
</html>