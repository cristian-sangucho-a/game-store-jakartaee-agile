<%--
  Created by IntelliJ IDEA.
  User: carla
  Date: 7/23/2024
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Seccion de pagos</title>
    <script src="https://kit.fontawesome.com/1a501b4a16.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles_payment.css">
</head>
<body>
<section id="seccion-pago">
    <div class="contenedor-icono">
        <i class="fa-solid fa-bag-shopping"></i>
    </div>
    <h2>Pago con Tarjeta de Crédito</h2>
    <form id="formulario-tarjeta-credito">
        <div class="grupo-formulario">
            <label for="numero-tarjeta">Número de Tarjeta</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-credit-card"></i></span>
                <input type="text" id="numero-tarjeta" placeholder="Número de Tarjeta" required>
            </div>
        </div>
        <div class="grupo-formulario">
            <label for="cvv-tarjeta">CVV</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-lock"></i></span>
                <input type="text" id="cvv-tarjeta" placeholder="CVV" required>
            </div>
        </div>
        <div class="grupo-formulario">
            <label for="fecha-expiracion">Fecha de Expiración</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-calendar-alt"></i></span>
                <input type="text" id="fecha-expiracion" placeholder="MM/AA" required>
            </div>
        </div>
        <button type="submit">Pagar</button>
    </form>
    <!-- Botón para regresar al carrito de compras -->
    <form action="carritoCompras.jsp" method="GET">
        <button type="submit" class="btn-regresar">Regresar a Carrito de Compras</button>
    </form>
</section>
</body>
</html>
