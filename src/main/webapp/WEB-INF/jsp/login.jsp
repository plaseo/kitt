<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/signin.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <p style="color: red;text-align:center">${signupsuccess}</p>

    <h1 class="signinheader">Login</h1>

    <div class = "signinpage">
        <div class="signinbox">
            <c:if test="${param.error != null}">
                    <div style="color: red;">
                        Invalid username or password.
                    </div>
                </c:if>
            <form:form method="post" action="/login">
                <label>Username</label> <br>
                <input type = "username" name="username"/> <br>
                <label>Password</label> <br>
                <input type="password" name="password" /> <br>
                <button class="signinbutton" type="submit">Sign In</button>
            </form:form>
        </div>
        
    </div>

   
      

</body>
</html>