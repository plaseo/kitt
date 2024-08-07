<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>navbar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/navbar.css"/>
</head>
<body>

    <div class = "nav">
        <a href="/" class="navitem" >Home</a>
        <a href="/cars" class="navitem" >Cars</a>

        <sec:authorize access="hasRole('SELLER')">
            <a href="/addcar" class="navitem">Add Car</a>
         </sec:authorize>
        
        <sec:authorize access="isAuthenticated()">
            <a href="/userprofile" class="navitem" >Profile</a>
        </sec:authorize>

        <sec:authorize access="hasRole('ADMIN')">
            <a href="/availableusers" class="navitem" >Available Users</a>
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
            <a href="/signup" class="navitem" >Signup</a>
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
            <a href="/login" class="navitem" >Login</a>
        </sec:authorize>

        <sec:authorize access="hasRole('BUYER')">
            <a href="/cart" class="navitem" >Cart</a>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <a href="/logout" class="navitem" >Logout</a>
        </sec:authorize>
    </div>


</body>
</html>