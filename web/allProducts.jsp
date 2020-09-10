<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.ProductBean, java.util.Iterator, collection.*, utility.CookieHelper"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   
<link rel="icon" type="image/png" sizes="32x32" href="images/favicon.png">
<link rel="stylesheet" href="styles/styles.css">
<title>Cornhub</title>
</head>
<body>
<div class="container-fluid" style="background-color:black; font-size: 16px;">
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
	        		<a  href="login" style="color:#ffa31a; text-decoration: none;">
		        		<i class="fa fa-user-o" aria-hidden="true" style="color:#ffa31a"></i>
		        		<span id="user" class="colOrange" style="color:#ffa31a"></span>
	        		</a>	   
	        	<%} else {%> 
	            <a href="logout" style="color:#ffa31a; text-decoration: none;">
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

<%	
    		IteratorInterface iterator = new Products(); 
			Iterator<ProductBean> prodIterator = iterator.createIterator(); 
		%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.js"></script>
<div class="viewed" style="background-color: rgba(218, 213, 213, 0.938);">
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="bbb_viewed_title_container">
                    <h2 class="bbb_viewed_title" style="color:orangered">Hub</h2>
                    <div class="bbb_viewed_nav_container" style="color:orangered">
                       <div class="bbb_viewed_nav bbb_viewed_prev" style="color:orangered"><i class="fa fa-chevron-left" style="color:#292929"></i></div>
                       <div class="bbb_viewed_nav bbb_viewed_next" style="color:orangered"><i class="fa fa-chevron-right" style="color:#292929"></i></div>
                    </div>
                </div>
                <div class="bbb_viewed_slider_container" style="border-top:solid; border-top-color:#292929;border-top-width:1px">
                    <div class="owl-carousel owl-theme bbb_viewed_slider">
                    	
                    	<% 
                    		while(prodIterator.hasNext()){
    	            			ProductBean product = (ProductBean) prodIterator.next();	
                    	%>
                  		<form action="ViewProduct.action" id="<%=product.getProdName()%>" method="POST">
                  		
                  		<a href="#" onclick="document.getElementById('<%=product.getProdName()%>').submit()" method="POST">
                        <input type="hidden" name="prodId" value="<%=product.getProdId()%>">
                        <div class="owl-item" style="border:solid; border-color:#ffa31a">
                            <div class="bbb_viewed_item discount d-flex flex-column align-items-center justify-content-center text-center">
                                <div class="bbb_viewed_image"><img src="<%=product.getImagePath()%>" alt="" style="width: 100%; height:100%"></div>
                                <div class="bbb_viewed_content text-center">
                                    <div class="bbb_viewed_price" style="color:orangered">Php <%=product.getProdPrice()%></div>
                                    <div class="bbb_viewed_name"><%=product.getProdName()%></div>
                                </div>
                              
                            </div>
                        </div>
                        </a>
                        </form>
                        <%} %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
$(document).ready(function()
		{


		if($('.bbb_viewed_slider').length)
		{
		var viewedSlider = $('.bbb_viewed_slider');

		viewedSlider.owlCarousel(
		{
		loop:true,
		margin:30,
		autoplay:true,
		autoplayTimeout:6000,
		nav:false,
		dots:false,
		responsive:
		{
		0:{items:1},
		575:{items:2},
		768:{items:3},
		991:{items:4},
		1199:{items:6}
		}
		});

		if($('.bbb_viewed_prev').length)
		{
		var prev = $('.bbb_viewed_prev');
		prev.on('click', function()
		{
		viewedSlider.trigger('prev.owl.carousel');
		});
		}

		if($('.bbb_viewed_next').length)
		{
		var next = $('.bbb_viewed_next');
		next.on('click', function()
		{
		viewedSlider.trigger('next.owl.carousel');
		});
		}
		}


		});
</script>

<link rel="stylesheet" href="styles/allProducts.css">
 <footer>
        <div class="container-fluid pt-4 bg-dark text-light pl-5 pb-4">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="row">
                            <h4>Categories</h4>
                        </div>
                        <div class="row mb-4">
                            <div class="underline bg-light" style="width:80px"></div>
                        </div>
                        <p style="color:white; font-size: 16px;"><i class="fa fa-chevron-right" aria-hidden="true"></i> Food</p>
                        <p style="color:white; font-size: 16px;"><i class="fa fa-chevron-right" aria-hidden="true"></i> Clothes</p>
                        <p style="color:white; font-size: 16px;"><i class="fa fa-chevron-right" aria-hidden="true"></i> Products</p>
                        <p style="color:white; font-size: 16px;"><i class="fa fa-chevron-right" aria-hidden="true"></i> Entertainment</p>
                    </div>
                    <div class="col-md-4">
                        <div class="row">
                            <h4>About</h4>
                        </div>
                        <div class="row mb-4">
                            <div class="underline bg-light" style="width:50px"></div>
                        </div>
                        <div class="row">
                            <p style="color:white; font-size: 16px;"> Cornhub is an E-commerce website where you can shop and enjoy any 
                                corn related products that you want. Get 50 pesos off per 1000 pesos worth 
                                of corn related products.
                            </p>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="row">
                            <h4>Contacts</h4>
                        </div>
                        <div class="row mb-4">
                            <div class="underline bg-light" style="width:50px"></div>
                        </div>
                        <div class="row pl-3">
                            <p style="color:white; font-size: 16px;"><i class="fa fa-envelope" aria-hidden="true"></i> papasmurf69@gmail.com</p>
                            <p style="color:white; font-size: 16px;"><i class="fa fa-map-marker" aria-hidden="true"></i> iACADEMY Nexus , Yakal, Makati</p>
                            
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
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