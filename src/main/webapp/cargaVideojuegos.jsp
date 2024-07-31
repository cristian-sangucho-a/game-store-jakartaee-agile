<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cargar Videojuego</title>
    <!-- Enlace al archivo CSS para estilizar la página de carga de videojuegos -->
    <link rel="stylesheet" type="text/css" href="styles_uploadVideogame.css">
</head>
<body>
<!-- Título de la página de carga de videojuegos -->
<h1>Cargar Videojuego</h1>
<!-- Contenedor para el formulario de carga de videojuegos -->
<div class="container">
    <form action="SvCargarVideojuego" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" required>
        </div>
        <div class="form-group">
            <label for="desarrollador">Desarrollador:</label>
            <input type="text" id="desarrollador" name="desarrollador" required>
        </div>
        <div class="form-group">
            <label for="precio">Precio:</label>
            <input type="number" step="0.01" id="precio" name="precio" required>
        </div>
        <div class="form-group">
            <label for="image">Imagen:</label>
            <input type="file" id="image" name="image" required>
        </div>
        <div class="form-group">
            <button type="submit" class="btn-cargar">Cargar Videojuego</button>
        </div>
    </form>
</div>
<div class="boton-volver">
    <a href="index.jsp">Volver a página de inicio</a>
</div>
</body>
</html>
