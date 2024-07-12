<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transactions</title>
    <link rel="stylesheet" href="/css/transactionreport.css"/>
</head>

<body>
    <jsp:include page="navbar.jsp"/>
    <h1>Hello!</h1>
    <table border="1" >
        <tr>
    <th>ID</th>
    <th>User</th>
    <th>Date</th>
    <th>Total Amount</th>
    </tr>
    <c:forEach var="transaction" items="${transactions}">
        <tr>
            <td>${transaction.id}</td>
            <td>${transaction.user.firstName} ${transaction.user.lastName}</td>
            <td>${transaction.date}</td>
            <td>${transaction.totalAmount}</td>
            <td><a href="/transactions/${transaction.id}"><button>Details</button></a></td>
        </tr>
    </c:forEach>
    </table>

    
</body>
</html>