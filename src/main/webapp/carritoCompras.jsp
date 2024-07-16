<%@ page import="java.util.List" %>
<%@ page import="ec.edu.epn.model.entities.Videojuego, ec.edu.epn.model.logic.CarritoDeCompras" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrito de Compras</title>
    <link rel="stylesheet" type="text/css" href="stylesCarrito.css">
</head>
<body>
<h1>Carrito de Compras</h1>
<div class="boton-volver">
    <a href="index.jsp">Volver a pagina inicio</a>
</div>
<div class="container">
    <%
        HttpSession sessionActual = request.getSession();
        CarritoDeCompras carrito = (CarritoDeCompras) sessionActual.getAttribute("carroDeCompras");
        if (carrito == null || carrito.getVideojuegos().isEmpty()) {
    %>
    <p>No hay nada en el carrito todavía.</p>
    <%
    } else {
        List<Videojuego> videojuegos = carrito.getVideojuegos();
        for (Videojuego videojuego : videojuegos) {
    %>
    <div class="card">
        <h2><%= videojuego.getTitulo() %></h2>
        <div>
            <img src="data:image/png;base64,<%=videojuego.getImageDataString()%>" alt="imagenDeVideojuego">
        </div>
        <p>Precio: $<%= videojuego.getPrecio() %></p>
        <form action="SvQuitarDeCarrito" method="POST">
            <input type="hidden" name="videojuegoId" value="<%= videojuego.getId() %>" />
            <button type="submit">Quitar del carrito</button>
        </form>
    </div>
    <%
        }
    %>
    <div class="total-price">
        <h2>Total: $<%= carrito.getTotalCompra() %></h2>
    </div>
    <form action="SvEliminarTodosLosVideojuegos" method="POST">
        <button type="submit">Vaciar Carrito</button>
    </form>
    <%
        }
    %>
</div>
</body>
</html>