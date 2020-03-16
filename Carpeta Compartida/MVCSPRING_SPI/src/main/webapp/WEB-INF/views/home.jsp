<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
<!-- CSS -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<title>SPI BIENES</title>
</head>
<body class="body1">
          <img src="--/resources/imagenes/logo2.png" /> 
          <img src="<c:url value="../imagenes/logo2.png"/>"/>

<div class="container">

	<br><br>
	<div class="media">
  <img src="..." class="mr-3" alt="...">
  <div class="media-body">
    <h5 class="mt-0">Media heading</h5>
    Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
  </div>
</div>
          
  <div class="card" style="width: 28rem;">
   <img  class="imagen1 card-img-top" URL="imagenes/logo.png" />
   
	
   <!--<img class="imagen2" src="imagenes/todaunavida.png" />-->
  <div class="card-body">
    <h5 class="card-title">Inicio de sesión</h5>
    <form>
	  <div class="form-group">
	    <label for="exampleInputEmail1">Usuario:</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Ingrese usuario ">
	  </di>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Contraseña:</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Ingrese contraseña ">
	  </div>
	  <div class="form-group form-check">
	  </div>
	  &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <button type="submit" class="btn btn-primary">Salir del Sistema</button> &nbsp;&nbsp;   <button type="submit" class="btn btn-primary">Ingresar al Sistema</button>
	</form>
    
  </div>
</div>     
      



</div>

           
      
 







<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>      

</body>
</html>
