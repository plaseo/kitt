<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <h1>Cart</h1>

    <c:forEach var="car" items="${cartItems}">

    <img src="${car.photoUrl}"/>
    <p>${car.manufacturerName}</p>
    <p>${car.model}</p>
    <p>${car.price}</p>

    </c:forEach>
</body>
</html>