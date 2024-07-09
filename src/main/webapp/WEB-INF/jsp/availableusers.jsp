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
            <div class="useritems">
                <tr> 
                    <th class="userinfo"><em>FIRST NAME</em></th>
                    <th class="userinfo"><em>LAST NAME</em></th>
                    <th class="userinfo"><em>DATE OF BIRTH</em></th>
                    <th class="userinfo"><em>ADDRESS</em></th>
                    <th class="userinfo"><em>EMAIL</em></th>
                    <th class="userinfo"><em>PHONE</em></th>
                    <th class="userinfo"><em>ROLE</em></th>
                    <th class="userinfo"><em>ADMIN</em></th>
                </tr>
            </div>
                <c:forEach var ="user" items="${availableUsers}">
                    <tr class="userinfo">
                        <td class="userinfo">${user.firstName}</td>
                        <td class="userinfo">${user.lastName}</td>
                        <td class="userinfo">${user.dateOfBirth}</td>
                        <td class="userinfo">${user.address}</td>
                        <td class="userinfo">${user.email}</td>
                        <td class="userinfo">${user.phoneNumber}</td>
                        <td class="userinfo">${user.role}</td>
                        <td class="userinfo">${user.isAdmin}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>