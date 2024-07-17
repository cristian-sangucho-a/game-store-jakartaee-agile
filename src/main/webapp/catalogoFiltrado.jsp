<%@ page import="java.util.List" %>
<%@ page import="ec.edu.epn.model.entities.Videojuego" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Catálogo Filtrado de Videojuegos</title>
    <!-- Enlace al archivo CSS para estilizar la página -->
    <link rel="stylesheet" href="styles1.css">
</head>
<body>
<!-- Sección para volver al inicio -->
<div class="boton-volver">
    <a href="index.jsp">Volver a página de inicio</a>
</div>
<h1>Bienvenido a la tienda de videojuegos</h1>
<!-- Contenedor que recorre todos los videojuegos y los muestra -->
<div class="cardContainer">
    <%
        List<Videojuego> videojuegos = (List<Videojuego>) request.getSession().getAttribute("videojuegos");
        for (Videojuego videojuego : videojuegos) {
    %>
    <!-- Mostrar cada videojuego como una tarjeta -->
    <div class="card">
        <h3>Titulo del videojuego: <%= videojuego.getTitulo() %></h3>
        <div>
            <!-- Imagen en base 64 para mostrar en la web -->
            <img src="data:image/png;base64,<%= videojuego.getImageDataString() %>" alt="imagenDeVideojuego">
        </div>
        <p>Desarrollado por: <%= videojuego.getDesarrollador() %></p>
        <p class="precio">Precio: <%= videojuego.getPrecio() %></p>
        <form action="SvAgregarACarrito" method="post">
            <input type="hidden" name="idVideojuego" value="<%= videojuego.getId() %>">
            <button type="submit" class="btn-agregar">Agregar al carrito</button>
        </form>
    </div>
    <%
        }
    %>
</div>
</body>
</html>
