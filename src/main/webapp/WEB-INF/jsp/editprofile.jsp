<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel=stylesheet href="/css/editprofile.css"/>
</head>
<body>

    <jsp:include page="navbar.jsp"/>

    <h1 class="editprofileheader">Edit Profile</h1>
<div class="editprofilepage">
    <div class="editprofilebox">
        <form:form method="post" action="/editprofile">
            <label>First Name</label> <br>
            <input type="text" name="firstName" value="${user.firstName}" /> <br>
            <label>Last Name</label><br>
            <input type="text" name="lastName" value="${user.lastName}" /> <br>
            <label>Date Of Birth</label><br>
            <input type="text" name="dateOfBirth" value="${user.dateOfBirth}" /> <br>
            <label>Address</label><br>
            <input type="text" name="address" value="${user.address}" /> <br>
            <label>Email</label><br>
            <input type="text" name="username" value="${user.username}" /> <br>
            <label>Phone Number</label> <br>
            <input type="text" name="phoneNumber" value="${user.phoneNumber}" /> <br>
            <button class="submitbutton">Submit</button>
        </form:form>
    </div> 
</div> 
</body>
</html>