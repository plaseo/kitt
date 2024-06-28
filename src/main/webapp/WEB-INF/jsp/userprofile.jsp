<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="/css/userprofile.css"/>
</head>
<body>
<div class="masterdiv">

    <jsp:include page ="navbar.jsp"/>

    <h1 class="userprofileheader">${user.firstName} Profile</h1>

    <div class = "editprofilepage">
        <div class="editprofile">
            <p>${user.firstName}</p>
            <p>${user.lastName}</p>
            <p>${user.dateOfBirth}</p>
            <p>${user.address}</p>
            <p>${user.email}</p>
            <p>${user.phoneNumber}</p>
            <a href="/editprofile/${user. id}"><button class="submitbutton">Edit Profile</button></a>
        </div>
    </div>

</div>
</body>
</html>