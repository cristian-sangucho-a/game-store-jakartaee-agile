<%@ page import="java.util.*, ec.edu.epn.model.entities.Videojuego, ec.edu.epn.model.Carrito" %>
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
        Carrito carrito = (Carrito) sessionActual.getAttribute("carrito");
        if (carrito == null || carrito.getVideojuegos().isEmpty()) {
    %>
    <p>No hay nada en el carrito todavía.</p>
    <%
    } else {
        double totalCompra = carrito.getTotalCompra();
        for (Map.Entry<Videojuego, Integer> entry : carrito.getVideojuegos().entrySet()) {
            Videojuego videojuego = entry.getKey();
            int cantidad = entry.getValue();
            double totalProducto = cantidad * videojuego.getPrecio();
    %>
    <div class="card">
        <h2><%= videojuego.getTitulo() %></h2>
        <p>Cantidad: <%= cantidad %></p>
        <p>Precio: $<%= videojuego.getPrecio() %></p>
        <p>Total: $<%= totalProducto %></p>
        <form action="actualizarCarrito" method="post" style="display:inline;">
            <input type="hidden" name="accion" value="sumar">
            <input type="hidden" name="videojuegoId" value="<%= videojuego.getId() %>">
            <button type="submit">+</button>
        </form>
        <form action="actualizarCarrito" method="post" style="display:inline;">
            <input type="hidden" name="accion" value="restar">
            <input type="hidden" name="videojuegoId" value="<%= videojuego.getId() %>">
            <button type="submit">-</button>
        </form>
    </div>
    <%
        }
    %>
    <h2>Total de la Compra: $<%= totalCompra %></h2>
    <form action="realizarPedido" method="post">
        <button type="submit">Realizar Pedido</button>
    </form>
    <%
        }
    %>
</div>

<form action="eliminarVideojuegos" method="post">
    <button type="submit">Eliminar todos los videojuegos</button>
</form>

</body>
</html>