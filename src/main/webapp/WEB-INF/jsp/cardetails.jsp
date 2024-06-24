<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Details</title>
</head>
<body>
    
    <h1>${car.year} ${car.manufacturerName} ${car.model}</h1>

    <p>Year: ${car.year}</p>
    <p>Manufacturer: ${car.manufacturerName}</p>
    <p>Model: ${car.model}</p>
    <p>Transmission: ${car.transmission}</p>
    <p>Bodystyle: ${car.bodyStyle}</p>
    <p>Color: ${car.color}</p>
    <p>Mileage: ${car.mileage}</p>
    <p>Description: ${car.description}</p>
    <img src="${car.photoUrl}"/>
    
    

</body>
</html>