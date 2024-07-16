<%@ page import="java.util.*, ec.edu.epn.model.entities.Videojuego, ec.edu.epn.model.logic.CarritoDeCompras" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Carrito de Compras</title>
    <link rel="stylesheet" type="text/css" href="stylesCarrito.css">
</head>
<body>
<h1>Carrito de Compras</h1>
<div class="container">
    <%
        HttpSession sessionActual = request.getSession();
        CarritoDeCompras carrito = (CarritoDeCompras) sessionActual.getAttribute("carroDeCompras");
        if (carrito == null || carrito.getVideojuegosDelCarrito().isEmpty()) {
    %>
    <p>No hay nada en el carrito todavía.</p>
    <%
    } else {
        Map<Videojuego, Integer> videojuegosAgrupados = new HashMap<>();
        for (Map.Entry<Videojuego, Integer> entry : carrito.getVideojuegosDelCarrito().entrySet()) {
            Videojuego videojuego = entry.getKey();
            int cantidadActual = entry.getValue();
            videojuegosAgrupados.merge(videojuego, cantidadActual, Integer::sum);
        }

        for (Map.Entry<Videojuego, Integer> entry : videojuegosAgrupados.entrySet()) {
            Videojuego videojuego = entry.getKey();
            int cantidad = entry.getValue();
            double totalProducto = videojuego.getPrecio() * cantidad;
    %>
    <div class="card">
        <h2><%= videojuego.getTitulo() %></h2>
        <div>
            <img src="data:image/png;base64,<%=videojuego.getImageDataString()%>" alt="imagenDeVideojuego">
        </div>
        <p>Cantidad: <%= cantidad %></p>
        <p>Precio: $<%= videojuego.getPrecio() %></p>
        <p>Total: $<%= totalProducto %></p>
        <form action="SvActualizarCarrito" method="POST">
            <input type="hidden" name="videojuegoId" value="<%= videojuego.getId() %>" />
            <input type="hidden" name="accion" value="quitar" />
            <button type="submit">-</button>
        </form>
        <form action="SvActualizarCarrito" method="POST">
            <input type="hidden" name="videojuegoId" value="<%= videojuego.getId() %>" />
            <input type="hidden" name="accion" value="agregar" />
            <button type="submit">+</button>
        </form>
    </div>
    <%
        }
        double totalCompra = carrito.getTotalCompra();
    %>
    <h2>Total de la Compra: $<%= totalCompra %></h2>
    <%
        }
    %>
</div>
</body>
</html>