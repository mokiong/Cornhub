<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.ProductBean, java.util.Iterator, collection.*, java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  	<link rel="icon" type="image/png" sizes="32x32" href="images/favicon.png">
<title>Cornhub</title>
</head>
<body>
	<%@ include file="./layouts/header.jsp"%>

	<body class="bg-light-gray">
    <div>
    	<%	
    	
    		IteratorInterface iterator = new Products(); 
			Iterator<ProductBean> prodIterator = iterator.createIterator(); 
			
		%>
    	
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="images/carouselOne.jpg" class="carouselImage d-block img-responsive" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>Corn hub</h1>
                        <p>The best quality Corn for you</p>
                        
                        <a href="all-product"><button class="btn btn-info btn-lg shop-btn">Shop now</button></a>
                    </div> 
                </div>
                <div class="carousel-item">
                    <img src="images/carouselTwo.jpg" class="carouselImage d-block img-responsive" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>Corn hub</h1>
                        <p>The best quality Corn for you</p>
                        <a href="all-product"><button class="btn btn-info btn-lg shop-btn">Shop now</button></a>
                    </div>
                </div>
                <div class="carousel-item">
                    <img src="images/carouselThree.jpg" class="carouselImage d-block img-responsive" alt="...">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>Corn hub</h1>
                        <p>The best quality Corn for you</p>
                        <a href="all-product"><button class="btn btn-info btn-lg shop-btn">Shop now</button></a>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <div class="container-fluid offer pt-3 pb-3 bg-orange d-none d-md-block">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 m-right">
                        <h4>FREE SHIPPING</h4>
                        <p><i class="fa fa-truck" aria-hidden="true"></i> orders above Php 3000</p>
                    </div>
                    <div class="col-md-4 m-right">
                        <h4>CALL US ANYTMIE</h4>
                        <p><i class="fa fa-phone-square" aria-hidden="true"></i> 096967952367</p>
                    </div>
                    <div class="col-md-4 m-right">
                        <h4>OUR LOCATION</h4>
                        <p><i class="fa fa-map-marker" aria-hidden="true"></i> PHILIPPINES</p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="container-fluid bg-gray pb-5">
        <div class="container pt-5">
            <div class="row">
                <h3>BEST SELLERS</h3>
            </div>
            <div class="row">
                <div class="underline" style="width: 100px;"></div>
            </div>
            
        </div>
        <div class="container mt-5">
            <div class="row">
            	<% 
            		
	            	if(prodIterator.hasNext()){
	            		ProductBean product = (ProductBean) prodIterator.next();			
            	%>
                <div class="col-md-3">
                    <div class="card">
                        <img src="<%=product.getImagePath()%>" class="imageSize card-img-top img-responsive">
                        <div class="card-body" style="border-top: 2px solid orangered;">
                            <h5><%=product.getProdName()%></h5>
                            <h5>Php <%=product.getProdPrice()%></h5>
                            <form action="ViewProduct.action" method="POST">
								<input type="hidden" name="prodId" value="<%=product.getProdId()%>">
								<button type="submit" class="btn btn-danger shop-btn"><i class="fa fa-cart-plus" aria-hidden="true"></i>
                            View Product</button>
							</form>
                        </div>
                    </div>
                </div>
                <%} %>
               <% 
               if(prodIterator.hasNext()){
           		ProductBean product = (ProductBean) prodIterator.next();	
            	%>
                <div class="col-md-3">
                    <div class="card">
                         <img src="<%=product.getImagePath()%>" class="imageSize card-img-top img-responsive">
                        <div class="card-body" style="border-top: 2px solid orangered;">
                            <h5><%=product.getProdName()%></h5>
                            <h5>Php <%=product.getProdPrice()%></h5>
                            <form action="ViewProduct.action" method="POST">
								<input type="hidden" name="prodId" value="<%=product.getProdId()%>">
								<button type="submit" class="btn btn-danger shop-btn"><i class="fa fa-cart-plus" aria-hidden="true"></i>
                            View Product</button>
							</form>
                        </div>
                    </div>
                </div>
                <%} %>
                <% 
                if(prodIterator.hasNext()){
            		ProductBean product = (ProductBean) prodIterator.next();
            	%>
                <div class="col-md-3">
                    <div class="card">
                         <img src="<%=product.getImagePath()%>" class="imageSize card-img-top img-responsive">
                        <div class="card-body" style="border-top: 2px solid orangered;">
                            <h5><%=product.getProdName()%></h5>
                            <h5>Php <%=product.getProdPrice()%></h5>
                            <form action="ViewProduct.action" method="POST">
								<input type="hidden" name="prodId" value="<%=product.getProdId()%>">
								<button type="submit" class="btn btn-danger shop-btn"><i class="fa fa-cart-plus" aria-hidden="true"></i>
                            View Product</button>
							</form>
                        </div>
                    </div>
                </div>
                <%} %>
                <% 
                if(prodIterator.hasNext()){
            		ProductBean product = (ProductBean) prodIterator.next();
            	%>
                <div class="col-md-3">
                    <div class="card">
                         <img src="<%=product.getImagePath()%>" class="imageSize card-img-top img-responsive">
                        <div class="card-body" style="border-top: 2px solid orangered;">
                            <h5><%=product.getProdName()%></h5>
                            <h5>Php <%=product.getProdPrice()%></h5>
                            <form action="ViewProduct.action" method="POST">
								<input type="hidden" name="prodId" value="<%=product.getProdId()%>">
								<button type="submit" class="btn btn-danger shop-btn"><i class="fa fa-cart-plus" aria-hidden="true"></i>
                            View Product</button>
							</form>
                            
                        </div>
                    </div>
                </div>
                <%} %>
            </div>
        </div>
        <div class="container mt-5">
            <div class="row">
                <h3>SPRING SEASON</h3>
            </div>
            <div class="row">
                <div class="underline" style="width: 160px;"></div>
            </div>
        </div>
        <div class="container-fluid pt-4">
            <div class="row main align-items-center">
                <div class="col-md-6 image-element align-self-stretch">
                    <div class="img-wrap" style="width: 100%; height: 100%;">
                        <img src="images/rareCorn2.png" media-simple="true" class="imageSize img-responsive">
                    </div>
                </div>
                <div class="col-md-6 text-element">
                    <div class="text-content">
                        <h2 class="mbr-title pt-2 mbr-fonts-style align-center display-2">
                            Glass Gem
                        </h2>
                        <div class="underline align-center"style="width: 60%;">
                            <div class="line"></div>
                        </div>
                        <div class="mbr-section-text">
                            <p class="mbr-text pt-3 mbr-light mbr-fonts-style align-center display-5">
                                Like many heirloom treasures, Glass Gem corn has a name, a place, and a story. 
                                Many people have contacted us looking to obtain Glass Gem seed. 
                                Demand has been very high for this rare variety. As such, 
                                our supplies are limited and vary according to the season.
                            </p>
                        </div>
                        <div class="mbr-section-btn pt-3 align-center">
                        	<form action="ViewProduct.action" method="POST">
								<input type="hidden" name="prodId" value="1908525367">
								<button type="submit" class="btn btn-danger shop-btn">PLACE ORDER
							</form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <link rel="stylesheet" href="styles/homePage.css">
    <%@ include file="./layouts/footer.jsp"%>
</body>
</body>
</html>