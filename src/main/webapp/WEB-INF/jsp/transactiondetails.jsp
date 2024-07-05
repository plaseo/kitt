<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction Details</title>
</head>
<body>
    
    <jsp:include page="navbar.jsp"/>
    <div>${transaction.user.firstName} ${transaction.user.lastName}</div>
    <div>${transaction.date}</div>
    
<c:forEach var="car" items="${transaction.items}">

<div>${car.manufacturerName}</div>
<div>${car.model}</div>
<div>${car.year}</div>

</c:forEach>


<div>${transaction.totalAmount}</div>


</body>
</html>