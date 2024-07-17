<%@ page import="java.util.List" %>
<%@ page import="ec.edu.epn.model.entities.Videojuego, ec.edu.epn.model.logic.CarritoDeCompras" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrito de Compras</title>
    <!-- Enlace al archivo CSS para estilizar la página del carrito de compras -->
    <link rel="stylesheet" type="text/css" href="stylesCarrito.css">
</head>
<body>
<!-- Título de la página del carrito de compras -->
<h1>Carrito de Compras</h1>
<!-- Botón para volver a la página de inicio -->
<div class="boton-volver">
    <a href="index.jsp">Volver a pagina inicio</a>
</div>
<!-- Contenedor para los elementos del carrito de compras -->
<div class="container">
    <%
        // Recuperar la sesión actual y el carrito de compras de la sesión
        HttpSession sessionActual = request.getSession();
        CarritoDeCompras carrito = (CarritoDeCompras) sessionActual.getAttribute("carroDeCompras");
        // Verificar si el carrito está vacío
        if (carrito == null || carrito.getVideojuegos().isEmpty()) {
    %>
    <!-- Mensaje mostrado si el carrito está vacío -->
    <p>No hay nada en el carrito todavía.</p>
    <%
    } else {
        // Iterar sobre los videojuegos en el carrito
        List<Videojuego> videojuegos = carrito.getVideojuegos();
        for (Videojuego videojuego : videojuegos) {
    %>
    <!-- Mostrar cada videojuego como una tarjeta -->
    <div class="card">
        <h2><%= videojuego.getTitulo() %></h2>
        <div>
            <!-- Mostrar la imagen del videojuego -->
            <img src="data:image/png;base64,<%=videojuego.getImageDataString()%>" alt="imagenDeVideojuego">
        </div>
        <!-- Mostrar el precio del videojuego -->
        <p>Precio: $<%= videojuego.getPrecio() %></p>
        <!-- Botón para quitar el videojuego del carrito -->
        <form action="SvQuitarDeCarrito" method="POST">
            <input type="hidden" name="videojuegoId" value="<%= videojuego.getId() %>" />
            <button type="submit">Quitar del carrito</button>
        </form>
    </div>
    <%
        }
    %>
    <!-- Mostrar el precio total de los videojuegos en el carrito -->
    <div class="total-price">
        <h2>Total: $<%= carrito.getTotalCompra() %></h2>
    </div>
    <!-- Botón para vaciar el carrito -->
    <form action="SvEliminarTodosLosVideojuegos" method="POST">
        <button type="submit">Vaciar Carrito</button>
    </form>
    <%
        }
    %>
</div>
</body>
</html>