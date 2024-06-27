<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/addcar.css"/>
</head>
<body>

    <jsp:include page="navbar.jsp"/>
    <h1 class="addcarheader">Add Car</h1>

<div class="addcarpage">
    <div class="addcarbox">
        
        <form method="post" action="/addcar">

            <label>Manufacturer Name</label><br>
            <input type="text" name="manufacturerName"/><br>
            <label>Model</label><br>
            <input type="text" name="model"/><br>
            <label>Year</label><br>
            <input type="number" name="year"/><br>
            <label>Color</label><br>
            <input type="text" name="color" /><br>
            <label>Transmission</label><br>
            <input type="text" name="transmission"/><br>
            <label>Mileage</label><br>
            <input type="number" name="mileage"/><br>
            <label>Description</label><br>
            <input type="text" name="description" /><br>
            <label>Engine Type</label><br>
            <input type="text" name="engineType"/><br>
            <label>Body Style</label><br>
            <select>
                <option value="BodyStyle.SEDAN">SEDAN</option>
                <option value="BodyStyle.HATCHBACK">HATCHBACK</option>
                <option value="BodyStyle.SUV">SUV</option>
                <option value="BodyStyle.CONVERTIBLE">CONVERTIBLE</option>
                <option value="BodyStyle.COUPE">COUPE</option>
            </select><br>
            <label>Price</label><br>
            <input type="number" name="price"/><br>
            <label>Is Available</label>
            <input type="checkbox" name="isAvailable"/><br>
            <label>Is New</label>
            <input type="checkbox" name="isNew"/><br>
            <label>VIN number</label><br>
            <input type="text" name="vin"/><br>
            <label>Main Photo</label><br>
            <input type="url" name="photoUrl"/> <br>
            <label>Photos</label><br>
            <input /><br>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>   
</body>
</html>