<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Kitt's Home</title>
    <link rel=stylesheet href="/css/home.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</head>
<body>

        <jsp:include page="navbar.jsp"/>

        <h1 class="home">Welcome Home! ${user.firstName}</h1>

        <div class="homepage"></div>

    <div>
        <footer>
        CopyRight Area, Contact Us, Support
        </footer>
    </div>


    <div class="map">
        <h1>hello!</h1>
        <gmp-map
  center="43.4142989,-124.2301242"
  zoom="4"
  map-id="DEMO_MAP_ID"
  style="height: 400px"
>
  <gmp-advanced-marker
    position="37.4220656,-122.0840897"
    title="Mountain View, CA"
  ></gmp-advanced-marker>
  <gmp-advanced-marker
    position="47.648994,-122.3503845"
    title="Seattle, WA"
  ></gmp-advanced-marker>
</gmp-map>

    </div>
    <script
        src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDVZe2s7jXsjleR41xQk2bMJ0UQx5NCwjs&loading=async&libraries=maps,marker&v=beta" defer>
    </script>
    

</body>
</html>