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
        for (Map.Entry<Videojuego, Integer> entry : carrito.getVideojuegosDelCarrito().entrySet()) {
            Videojuego videojuego = entry.getKey();
            int cantidad = entry.getValue();
            double totalProducto = carrito.getTotalCompraPorVideojuego(videojuego.getId());
    %>
    <div class="card">
        <h2><%= videojuego.getTitulo() %></h2>
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
        <!-- Botones de acción omitidos para brevedad -->
    </div>
    <%
        }
        double totalCompra = carrito.getTotalCompra();
    %>
    <h2>Total de la Compra: $<%= totalCompra %></h2>
    <!-- Formulario de pedido omitido para brevedad -->
    <%
        }
    %>
</div>
</body>
</html>