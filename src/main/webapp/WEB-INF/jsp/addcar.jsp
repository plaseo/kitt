<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Car</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

    <jsp:include page="navbar.jsp"/>


    <form>

        <label>Manufacturer Name</label>
        <input type="text" name="manufacturerName"/>
        <label>Model</label>
        <input type="text" name="model"/>
        <label>Year</label>
        <input type="number" name="year"/>
        <label>Color</label>
        <input type="text" name="color" />
        <label>Transmission</label>
        <input type="text" name="transmission"/>
        <label>Mileage</label>
        <input type="number" name="mileage"/>
        <label>Description</label>
        <input type="text" name="description" />
        <label>Engine Type</label>
        <input type="text" name="engineType"/>
        <label>Body Style</label>
        <select>
            <option name="BodyStyle.SEDAN">SEDAN</option>
            <option name="BodyStyle.HATCHBACK">HATCHBACK</option>
            <option name="BodyStyle.SUV">SUV</option>
            <option name="BodyStyle.CONVERTABLE">CONVERTABLE</option>
            <option name="BodyStyle.COUPE">COUPE</option>
        </select>
        <label>Price</label>
        <input type="number" name="price"/>
        <label>Is Available</label>
        <input type="checkbox" name="isAvailable"/>
        <label>Is New</label>
        <input type="checkbox" name="isNew"/>
        <label>VIN number</label>
        <input type="text" name="vin"/>
        <label>Main Photo</label>
        <input type="url" name="photoUrl"/>  

        <label>Photos</label>
        <input />



        <button type="submit">Submit</button>
    </form>
</body>
</html>