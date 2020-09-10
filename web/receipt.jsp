<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.DiscountedOrderBean, java.util.ArrayList, model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/png" sizes="32x32" href="images/favicon.png">
<title>Cornhub</title>
</head>

<body style="background-color:#292929;">
	
	<%@ include file="./layouts/header.jsp"%>
	<%
	String orderType = (String)request.getAttribute("orderType");
	
	
	ArrayList<ProductBean> arraycart = (ArrayList<ProductBean>)request.getSession().getAttribute("customCart");
	
	%>
	<div class="container-fluid">
		<div class="jumbotron" style="margin: 30px 100px 30px 100px">
		  <h2 class="display-4 d-flex justify-content-center" style="color:orangered"><strong>Cornhub</strong></h2>
		  <h4 class="ml-4 d-flex justify-content-center">${order.customerName}</h4>
		  <h4 class="ml-4 d-flex justify-content-center">${order.shippingAddress}</h4>
		  <h4 class="ml-4 d-flex justify-content-center"><strong>CASH ON DELIVER</strong></h4>
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
                             
                            </tr>
                        </thead>
                        <tbody>
                        	<%
                        		for(ProductBean prod : arraycart){
                        			
                        		
                        	%>
                             <tr>
                                <td><img src="   " /> </td>
                                <td><%=prod.getProdName()%></td>
                                <td></td>
                                <td class="text-center"><%=prod.getStocks()%></td>
                                <td class="text-right">Php <%=prod.getStocks() * prod.getProdPrice()%> </td>
                               
                            </tr>
                            <%} %>
                            <tr>
                               
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><strong>    </strong></td>
                                <td class="text-right"></td>
                            </tr>
                            <tr>
                                
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><strong>Shipping</strong></td>
                                <td class="text-right">Php ${order.shippingFee}</td>
                            </tr>
                            <tr>
                               
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><strong>VAT%</strong></td>
                                <td class="text-right">Php ${order.cartPrice * .12}</td>
                            </tr>
                            <tr>
                               
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><strong>Discount</strong></td>
                                <td class="text-right"><strong>Php ${order.withNormalDiscount}</strong></td>
                                </tr>
                            <tr>
                               
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><strong>Total</strong></td>
                                <td class="text-right"><strong>Php ${order.withVAT}</strong></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col mb-2">
                <div class="row">
                    
                    <div class="col-sm-12 col-md-6 text-right">
                        <form action="final" method="POST" id="form1">
	                        <button type="submit" class="btn btn-lg btn-block btn-success text-uppercase checkout-btn">Submit order</button>
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