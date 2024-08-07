<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/userdetails.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <h1 class="userdetailsheader">Edit ${user.firstName} ${user.id}</h1>
    <div class="edituserbox">                        
        <c:forEach var="role" items="${user.roles}">
            ${role.name}
        </c:forEach>

    <div class="edituserbox">
        <form:form name="input" action="/userdetails/updaterolls/{$user.id}" method="POST">
            <input type="checkbox" name="role" value="ADMIN">Admin<br>
            <input type="checkbox" name="role" value="USER">User<br>
            <input type="submit" value="Submit">
        </form:form>          
    </div>

    </div>
<div class="flexbox">
    <div class="edituserbox">
        <form:form method="POST" action="/userdetails/${user.id}">
            <label>First Name</label> <br>
            <input type="text" name="firstName" value="${user.firstName}" /> <br>
            <label>Last Name</label><br>
            <input type="text" name="lastName" value="${user.lastName}" /> <br>
            <label>Date Of Birth</label><br>
            <input type="text" name="dateOfBirth" value="${user.dateOfBirth}" /> <br>
            <label>Address</label><br>
            <input type="text" name="address" value="${user.address}" /> <br>
            <label>Username</label><br>
            <input type="text" name="username" value="${user.username}" /> <br>
            <label>Phone Number</label> <br>
            <input type="text" name="phoneNumber" value="${user.phoneNumber}" /> <br>
            <label>Roles</label><br>
            <select name="USERROLE">
                <option value="BUYER">BUYER</option>
                <option value="SELLER">SELLER</option>
                <option value="ADMIN">ADMIN</option>
            </select><br>
            <button class="submitbutton">Submit</button>
    </form:form>
    
    </div>
        
</div>

</body>
</html>