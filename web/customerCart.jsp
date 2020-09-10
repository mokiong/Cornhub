<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, model.Product, model.ProductBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" type="image/png" sizes="32x32" href="images/favicon.png">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cornhub</title>
</head>
<body>
	<%@ include file="./layouts/header.jsp"%>
	<%	
    		
			ArrayList<ProductBean> cart = (ArrayList<ProductBean>) request.getSession().getAttribute("customCart"); 
	%>
	<section class="jumbotron text-center">
        <div class="container">
            <h1 class="jumbotron-heading">CORN CART</h1>
         </div>
    </section>
  
    
    <div class="container mb-4">
        <div class="row">
            <div class="col-12">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col"> </th>
                                <th scope="col">Product</th>
                                <th scope="col"></th>
                                <th scope="col" class="text-center">Quantity</th>
                                <th scope="col" class="text-right">Price</th>
                                <th> </th>
                            </tr>
                        </thead>
                        <tbody>
                        <% 
                        	if(cart != null){
                        		if(!cart.isEmpty()){
                 
                        			for(ProductBean prod : cart){
            			
                        %>
                            <tr>
                                <td></td>
                                <td><%=prod.getProdName()%></td>
                                <td></td>
                                <td>
                                    <input disabled class="form-control" type="number" value="<%=prod.getStocks()%>" id="<%=prod.getProdId()%>" name="<%=prod.getProdId()%>" min="1" max="<%=prod.getStocks()%>"/></td>
                                <td class="text-right">Php <%=prod.getProdPrice()%></td>
                                <td class="text-right">
                            
                                    
                                    <form action="remove.action" method="POST">
                                    	<input type="hidden" name="prodId" value="<%=prod.getProdId()%>">
                                    	<input type="hidden" name="prodName" value="<%=prod.getProdName()%>">
					            		<input type="hidden" name="prodPrice" value="<%=prod.getProdPrice()%>">
					            		<input type="hidden" name="stocks" value="<%=prod.getStocks()%>">
                                        <input type="hidden" name="imagePath" value="<%=prod.getImagePath()%>">
                                        
                                        <button type="submit" class="btn btn-sm btn-primary btn-float" style="background-color:#ffa31a; border-color:#ffa31a">
                                            <i class="fa fa-trash" aria-hidden="true"></i>
                                        </button>
                                    </form>
                                </td>
                            </tr>
                            <%} 
                        		
                        	
                        	%>
                            
                         <%} }%>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col mb-2">
                <div class="row">
                    <div class="col-sm-12  col-md-6">
                        <a href="all-product" style="text-decoration: none;" class="shopMore-btn"><button class="btn btn-lg btn-block btn-success text-uppercase" style="background-color: #292929;border-color: #292929;">Continue Shopping</button></a>
                    </div>
                    <div class="col-sm-12 col-md-6 text-right">
                    <% 
            		Cookie cooks[] = request.getCookies();
            		
            		Cookie cookieId = CookieHelper.getCookie(cooks, "userAccount");
            		if(cookieId == null){
            	%>
                        <form action="login" method="GET" id="form1">
                <%} else { %>
                		<form action="cart-checkout" method="GET" id="form1">
                <%} %>
	                        <button type="submit" class="btn btn-lg btn-block btn-success text-uppercase checkout-btn">Checkout</button>
	                    </form>
	                    
	                </div>
                </div>
            </div>
        </div>
    </div>
    
    <%@ include file="./layouts/footer.jsp"%>
	<link rel="stylesheet" href="styles/cart.css">

  
</body>
</html>