<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Users</title>
    <link rel="stylesheet" href="/css/availableusers.css"/>
</head>
<body>
<div class="masterdiv">
<jsp:include page="navbar.jsp"/>
<h1>HELLO!!</h1>

    <div class="availableuserspage">
    <c:forEach var ="user" items="${availableUsers}">
        <div class="useritems">
        <a href="userdetails/${user.id}">
        <t>First Name: ${user.firstName}</p>
        <p>DOB: ${user.dateOfBirth}</p>
        <p>Address: ${user.address}</p>
        <p>Email: ${user.email}</p>
        <p>Phone: ${user.phoneNumber}</p>
        <p>Role: ${user.role}</p>
        <p>Admin: ${user.isAdmin}</p>
        </a>
        
    </div>
    </c:forEach>

</div>
</body>
</html>