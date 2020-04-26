<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>BookStore</title>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/forms.css">
	<link rel="stylesheet" href="css/product.css">
</head>
<body>
	<%@ include file="header.html" %>
	<main>
            <%@ page language="java" %> 
            <div class="grid">
                    <article class="card product-item">
                        <header class="card__header">
                            <h1 class="product__title">Test</h1>
                        </header>
                        <div class="card__image">
                            <img src="https://images-na.ssl-images-amazon.com/images/I/51zcMqY7GQL._SX331_BO1,204,203,200_.jpg"
                                alt="">
                        </div>
                        <div class="card__content">
                            <h2 class="product__price">10</h2>
                            <p class="product__description">Description</p>
                        </div>
                        <div class="card__actions">
                            <a href="/products/" class="btn">Details</a>                         
                        </div>
                    </article>
            </div>
            
    </main>
</body>
</html>