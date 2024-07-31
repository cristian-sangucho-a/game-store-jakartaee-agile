<%@ page import="java.util.List" %>
<%@ page import="ec.edu.epn.model.entities.Videojuego" %>
<%@ page import="ec.edu.epn.model.entities.Biblioteca" %>
<%@ page import="ec.edu.epn.model.logic.ClienteDAO" %>
<%@ page import="ec.edu.epn.model.entities.Cliente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Biblioteca de Videojuegos</title>
    <!-- Enlace al archivo CSS para estilizar la página -->
    <link rel="stylesheet" href="styles1.css">
    <link rel="stylesheet" href="stylesCarrito.css">
</head>
<body>
<!-- Sección para volver al inicio -->
<div class="boton-volver">
    <a href="index.jsp">Volver a página de inicio</a>
</div>
<h1>Tu Biblioteca de Videojuegos</h1>
<!-- Contenedor que recorre todos los videojuegos y los muestra -->
<div class="cardContainer">
    <%
        Biblioteca biblioteca = (Biblioteca) request.getAttribute("biblioteca");
        List<Videojuego> videojuegos = biblioteca.getVideojuegos();
        if (videojuegos == null || videojuegos.isEmpty()) {
    %>
    <p>No tienes videojuegos en tu biblioteca.</p>
    <%
    } else {
        for (Videojuego videojuego : videojuegos) {
    %>
    <!-- Mostrar cada videojuego como una tarjeta -->
    <div class="card">
        <h3>Título del videojuego: <%= videojuego.getTitulo() %></h3>
        <div>
            <!-- Imagen en base 64 para mostrar en la web -->
            <img src="data:image/png;base64,<%= videojuego.getImageDataString() %>" alt="imagenDeVideojuego">
        </div>
        <p>Desarrollado por: <%= videojuego.getDesarrollador() %></p>
    </div>
    <%
            }
        }
    %>
</div>
</body>
</html>
