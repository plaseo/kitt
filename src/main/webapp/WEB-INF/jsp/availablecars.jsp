<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cars</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/availablecars.css"/>
</head>

<body>

    <jsp:include page="navbar.jsp"/>
    <h1 class="availablecarsheader">Cars</h1>

    <div class="container">
        <div>
            <div class="carfilter">
                <form>
                    <label class="carfilter">Sort By Price</label>
                    <select class="searchbutton" name="price">
                        <option class="searchbutton">Lowest to Highest</option>
                        <option class="searchbutton">Highest to Lowest</option>
                    </select>   
                </form>
                </div>
        </div>
        <div>
            <div class="carfilter">
                <form method="get" action="/searchmodel">
                    <input class="" type="text" name="model" placeholder="Enter car model"/>
                    <button class="searchbutton" type="submit">Search</button>
                </form>
                </div>
        </div>
    </div>
    
    

    <div class="carpage">
        <c:forEach var ="car" items="${availableCars}">
            <div class="caritems">
                <a href="/cardetails/${car.id}">
                    <img src="${car.photoUrl}" />
                    <p>${car.manufacturerName}</p>
                    <p>${car.model}</p>
                    <p>$${car.price}</p>
                    <p>${car.year}</p>
                    <p>${car.color}</p>
                </a>
            </div>
        </c:forEach>
    </div>

    

</body>
</html>