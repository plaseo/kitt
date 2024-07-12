
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel=stylesheet href="/css/editprofile.css"/>
</head>
<body>
<div class="masterdiv">
    <jsp:include page="navbar.jsp"/>

    <h1 class="editprofileheader">Edit ${user.firstName}'s Profile</h1>
<div class="editprofilepage">
    <div class="editprofilebox">
        <form method="post" action="/editprofile">
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
            <label>Phone Number</label> <br>
            <input type="text" name="phoneNumber" value="${user.phoneNumber}" /> <br>
            <button class="submitbutton">Submit</button>
        </form>
    </div>
</div>
</div>  
</body>
</html>