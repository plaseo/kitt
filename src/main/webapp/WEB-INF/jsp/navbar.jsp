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
        <button class="navitem"><a href="/" >Home</a></button>
        <button class="navitem"><a href="/cars" >Cars</a></button>
        <button class="navitem"><a href="/availableusers" >Available Users</a></button>

        <sec:authorize access="isAuthenticated()">
            <button class="navitem"><a href="/userprofile" >Profile</a></button>
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
            <button class="navitem"><a href="/login" >Login</a></button>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <button class="navitem"><a href="/logout" >Logout</a></button>
        </sec:authorize>    

        
    </div>


</body>
</html>