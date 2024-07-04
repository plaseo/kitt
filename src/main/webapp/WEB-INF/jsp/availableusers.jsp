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
<h1 class="availableusersheader">Available Users</h1>

    <div class="availableuserspage">
    
    <c:forEach var ="user" items="${availableUsers}">
        <div class="useritems">
        <a href="userdetails/${user.id}">
        <p class="userinfo"><em>First Name:</em> ${user.firstName}</p>
        <p class="userinfo"><em>Last Name:</em> ${user.lastName}</p>
        <p class="userinfo"><em>DOB:</em> ${user.dateOfBirth}</p>
        <p class="userinfo"><em>Address:</em> ${user.address}</p>
        <p class="userinfo"><em>Email:</em> ${user.email}</p>
        <p class="userinfo"><em>Phone:</em> ${user.phoneNumber}</p>
        <p class="userinfo"><em>Role:</em> ${user.role}</p>
        <p class="userinfo"><em>Admin:</em> ${user.isAdmin}</p>
        </a>
        
    </div>
    </c:forEach>

</div>
</body>
</html>