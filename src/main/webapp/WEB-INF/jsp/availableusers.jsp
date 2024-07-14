<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Users</title>
    <link rel="stylesheet" href="/css/availableusers.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <h1 class="availableusersheader">Available Users</h1>

    <div class="availableuserspage">
        <div>
            <table>
            <div class="">
                <tr> 
                    <th class="userinfo" >&nbsp<i class="fa-solid fa-user" style="color: #2ea34f;">&nbsp&nbsp<em>FIRST NAME</em></i>&nbsp</th>
                    <th class="userinfo">&nbsp<i class="fa-solid fa-user" style="color: #2ea34f;">&nbsp&nbsp<em>LAST NAME</em></i>&nbsp</th>
                    <th class="userinfo">&nbsp<i class="fa-solid fa-cake-candles" style="color: #2ea34f;">&nbsp&nbsp<em> DATE OF BIRTH</em></i>&nbsp</th>
                    <th class="userinfo">&nbsp<i class="fa-solid fa-map-location-dot" style="color: #2ea34f;">&nbsp&nbsp<em>ADDRESS</em></i>&nbsp</th>
                    <th class="userinfo">&nbsp<i class="fa-solid fa-envelope" style="color: #2ea34f;">&nbsp&nbsp<em>EMAIL</em></i>&nbsp</th>
                    <th class="userinfo">&nbsp<i class="fa-solid fa-phone-flip" style="color: #2ea34f;">&nbsp&nbsp<em>PHONE</em></i>&nbsp</th>
                    <th class="userinfo">&nbsp<i class="fa-solid fa-users-gear" style="color: #2ea34f;">&nbsp&nbsp<em>ROLES</em></i>&nbsp</th>
                </tr>
            </div>
                <c:forEach var ="user" items="${availableUsers}">
                    <tr class="userinfo">
                        <td class="userinfo">${user.firstName}</td>
                        <td class="userinfo">${user.lastName}</td>
                        <td class="userinfo">${user.dateOfBirth}</td>
                        <td class="userinfo">${user.address}</td>
                        <td class="userinfo">${user.username}</td>
                        <td class="userinfo">${user.phoneNumber}</td>
                        <td class="userinfo">${user.roles}</td>
                        <td>
                            <a href="/userdetails/${user.id}">
                                <button class="btn"><i class="fa-solid fa-pen" style="color: #2ea44f; background-color: black"></i></button>
                            </a>
                        </td>
                        <!-- <td><a href="/userdetails/${user.id}"><button type="submit" i class="fa-solid fa-pen"></button></a></td> -->
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <script src="https://kit.fontawesome.com/fae6cf0705.js" crossorigin="anonymous"></script>
</body>
</html>