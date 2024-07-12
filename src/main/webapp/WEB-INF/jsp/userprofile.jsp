<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <link rel="stylesheet" href="/css/userprofile.css"/>
</head>
<body>
<p>current session info: ${username}</p>

<div class="masterdiv">

    <jsp:include page ="navbar.jsp"/>

    <h1 class="userprofileheader">User Profile</h1>

    <div class = "editprofilepage">
        <div class="editprofile">
            <p>${user.username}</p>
            <p>${user.firstName}</p>
            
            <p>blah</p>
            <p>blah</p>
            <a href="/editprofile/"><button class="submitbutton">Edit Profile</button></a>
        </div>
    </div>

    <sec:authorize access="!isAuthenticated()">
        LoggedOut!
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        LoggedIn!
    </sec:authorize>

</div>
</body>
</html>