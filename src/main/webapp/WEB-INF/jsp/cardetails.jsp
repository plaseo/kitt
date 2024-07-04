<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Details</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/cardetails.css"/>
</head>
<body>
    <jsp:include page="navbar.jsp"/>
    <h1 class="cardetailheader">${car.year} ${car.manufacturerName} ${car.model}</h1>

<div class="cardetailsflex">    
    <div class="cardetailsbox">  
        <div class="carouselsize">
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-touch="true">
            <div class="carousel-inner">
                <!-- using for each loop to iterate through the photos associated with the car object -->
                <!-- varStatus="status" lets us track the iteration status -->
                <c:forEach var="photo" items="${car.photos}" varStatus="status">
                    <div class="carousel-item ${status.index == 0 ? 'active' : ''}">
                        <!-- loading each photo -->
                        <img class="d-block w-100" src="${photo.photoUrl}" alt="Car photo"/>
                    </div>
                </c:forEach>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev"/>
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next"/>
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        </div>
        
        <div class="cardetailscontent">    
            <p>Year: ${car.year}</p>
            <p>Manufacturer: ${car.manufacturerName}</p>
            <p>Model: ${car.model}</p>
            <p>Transmission: ${car.transmission}</p>
            <p>Bodystyle: ${car.bodyStyle}</p>
            <p>Color: ${car.color}</p>
            <p>Mileage: ${car.mileage}</p>
            <p>Description: ${car.description}</p>
            <a href="/cart/add/${car.id}"><button class="addtocartbutton">Add To Cart</button></a>
        </div>

    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>