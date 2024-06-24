<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cars</title>
    <link rel="stylesheet" href="/css/availablecars.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>

    <h1>Cars</h1>
<div class="carpage">

<c:forEach var ="car" items="${availableCars}">

<div class="caritems">

    <b href="/cardetails/${car.id}">
        <img src="${car.photoUrl}" />
        <p>${car.manufacturerName}</p>
        <p>${car.model}</p>
        <p>$${car.price}</p>
        <p>${car.year}</p>
        <p>${car.color}</p>

    </b>
</div>

</c:forEach>

</div>

</body>
</html>