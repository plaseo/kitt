<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel=stylesheet href="/css/cart.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    
    <h1 class="shopingcartheader">Your Shopping Cart</h1>

    <div class="cartpage">
        <c:forEach var="car" items="${cartItems}">
        <div class="cartitems">
        <img src="${car.photoUrl}"/>
        <p>${car.manufacturerName}</p>
        <p>${car.model}</p>
        <p>${car.price}</p>
        <a href="/cart/remove/${car.id}"><button class="cartbutton">Remove</button></a>
        </div>
        </c:forEach>
    </div>

    <div class="checkoutflex">
    <div class="checkoutbox">
        <a class="cartpage" href="/v1/checkout/sessions"><button class="cartbutton">Checkout</button></a>
    </div>
    </div>

</body>
</html>