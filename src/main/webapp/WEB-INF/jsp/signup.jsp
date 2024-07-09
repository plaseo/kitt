<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/signup.css"/>
</head>
<body>
    
    <jsp:include page ="navbar.jsp"/>   
    
    <h1 class="signupheader">Sign-Up</h1>
    
    <div class = "signuppage">
        <div class = "signupbox">
            <form:form method="post" action="/signup">
                <label>First Name</label> <br>
                <input type ="text" name = "firstName"/> <br>
                <label>Last Name</label> <br>
                <input type = "text" name ="lastName"/> <br>
                <label>Date of Birth</label> <br>
                <input type ="date" name="dateOfBirth"/> <br>
                <label>Phone Number</label> <br>
                <input type ="text" name="phoneNumber"/> <br>
                <label>Email</label> <br>
                <input type="email" name="email" /> <br>
                <label>Password</label> <br>
                <input type ="password" name ="password" /> <br>

                <button class ="signupbutton" type = "submit">Sign-Up</button>
            </form:form>
        </div>
    </div>

</body>
</html>