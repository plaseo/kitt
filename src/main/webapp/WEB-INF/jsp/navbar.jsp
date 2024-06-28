<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

    <!-- sessionScope accesses attributes that are stored in HttpSession object -->



    <div class = "nav">
        <button class="navitem"><a href="/" >Home</a></button>
        <button class="navitem"><a href="/cars" >Cars</a></button>
        


        <!-- we only want the signin and the signup to display if there is no user set in the session -->
        <!-- we use the test attribute inside of the if tag to do a conditional statement -->
        <c:if test="${empty sessionScope.user}">
        <button class="navitem"><a href="/signin" >Sign-In</a></button>
        <button class="navitem"><a href="/signup" >Sign-Up</a></button>
        </c:if>

        <c:choose>
            <c:when test="${sessionScope.userRole == 'BUYER'}">
                <button class="navitem"><a href="/userprofile">User Profile</a></button>
                <button class="navitem"><a href="/cart">Cart</a></button>
                <!-- <button class="navitem"><a href="#">Cart</a></button> -->
                <button class="navitem"><a href="/logout">Logout</a></button>
            </c:when>
            <c:when test="${sessionScope.userRole == 'SELLER'}">
                <button class="navitem"><a href="/addcar">Add Car</a></button>
                <button class="navitem"><a href="#">View Reports</a></button>
                <button class="navitem"><a href="/logout">Logout</a></button>
            </c:when>
        </c:choose>

    </div>


</body>
</html>