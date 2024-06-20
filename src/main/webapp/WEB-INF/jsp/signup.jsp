<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/signup.css"/>
</head>
<body>
    
    <jsp:include page ="navbar.jsp"/>

    <div class = "signuppage">
        <div class = "signupbox">
    <form method="post" action="/signup">

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

        <button type = "submit">Sign-Up</button>

    </form>

</div>
</div>
</body>
</html>