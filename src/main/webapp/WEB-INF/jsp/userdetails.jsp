<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Edit ${user.firstName} ${user.lastName}</h1>

    <div class="edituserbox">
        <form method="post" action="/userdetails">
            <label>First Name</label> <br>
            <input type="text" name="firstName" value="${user.firstName}" /> <br>
            <label>Last Name</label><br>
            <input type="text" name="lastName" value="${user.lastName}" /> <br>
            <label>Date Of Birth</label><br>
            <input type="text" name="dateOfBirth" value="${user.dateOfBirth}" /> <br>
            <label>Address</label><br>
            <input type="text" name="address" value="${user.address}" /> <br>
            <label>Email</label><br>
            <input type="text" name="email" value="${user.email}" /> <br>
            <label>Password</label><br>
            <input type="text" name="password" value="${user.password}" /> <br>
            <label>Phone Number</label> <br>
            <input type="text" name="phoneNumber" value="${user.phoneNumber}" /> <br>
            <label>Role</label><br>
            <input type="text" name="role" value="${user.role}" /> <br>
            <label>Is Admin</label><br>
            <input type="text" name="isAdmin" value="${user.isAdmin}" /> <br>
            <button class="submitbutton">Submit</button>
        </form>
    </div>

</body>
</html>