<%@ page import="ec.edu.epn.model.entities.Pago" %>
<%@ page import="ec.edu.epn.model.entities.DetallePago" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: carla
  Date: 7/23/2024
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pago Exitoso</title>
    <script src="https://kit.fontawesome.com/1a501b4a16.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles_payment_successfully.css">

</head>
<body>
<% Pago pago = (Pago) request.getAttribute("pago");
    SimpleDateFormat format = new SimpleDateFormat("HH:mm dd MMM yyyy");
    String fechaFormateada = format.format(pago.getFechaDelPago());%>

<section id="confirmacion-pago">
    <h1><i class="fa fa-check-circle" aria-hidden="true"></i> Pago exitoso</h1>
    <p>Fecha de compra: <span id="fecha-compra"><%= fechaFormateada %></span></p>
    <p>Precio total: <span id="precio-total">$<%= pago.getTotalCompra() %></span></p>
    <p>Titular de la tarjeta: <span id="titular-tarjeta"><%= pago.getTitularDeLaTarjeta() %></span></p>
    <h2>Detalle de la compra:</h2>
    <ul>
        <% for(DetallePago detalle : pago.getDetallesPagos()) { %>
        <li><%= detalle.getVideojuego().getTitulo() %> - Precio: $<%= detalle.getVideojuego().getPrecio() %></li>
        <% } %>
    </ul>
    <form action="index.jsp">
        <button type="submit" class="btn-regresar">Regresar a la página de inicio</button>
    </form>
</section>
</body>
</html>
