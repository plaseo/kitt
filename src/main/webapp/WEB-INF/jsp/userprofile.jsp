<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="/css/userprofile.css"/>
</head>
<body>
    <jsp:include page ="navbar.jsp"/>
    <h1 class="userprofileheader">${user.firstName} Profile</h1>

    <p>${user.firstName}</p>
    <p>${user.lastName}</p>
    <p>${user.dateOfBirth}</p>
    <p>${user.email}</p>
    <p>${user.phoneNumber}</p>

    <a href="/editprofile/${user. id}"><button>Edit Profile</button></a>





</body>
</html>