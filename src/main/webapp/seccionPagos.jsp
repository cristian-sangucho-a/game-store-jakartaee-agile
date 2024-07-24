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
    <form action="carritoCompras.jsp">
        <button type="submit" class="btn-regresar"><i class="fas fa-arrow-left"></i></button>
    </form>
    <div class="contenedor-icono">
        <i class="fa-solid fa-bag-shopping"></i>
    </div>
    <h2>Pago con Tarjeta de Crédito</h2>
    <form id="formulario-tarjeta-credito" method="POST" action="SvPagarCarrito">
        <div class="grupo-formulario">
            <label for="numero-tarjeta">Número de Tarjeta</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-credit-card"></i></span>
                <input type="text" id="numero-tarjeta" name="numero-tarjeta" placeholder="Número de Tarjeta" required>
            </div>
        </div>
        <div class="grupo-formulario">
            <label for="cvv-tarjeta">CVV</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-lock"></i></span>
                <input type="text" id="cvv-tarjeta" name="cvv-tarjeta" placeholder="CVV" required>
            </div>
        </div>
        <div class="grupo-formulario">
            <label for="fecha-expiracion">Fecha de Expiración</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-calendar-alt"></i></span>
                <input type="text" id="fecha-expiracion" name="fecha-expiracion" placeholder="MM/AA" required>
            </div>
        </div>
        <div class="grupo-formulario">
            <label for="titular-tarjeta">Titular de la Tarjeta</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-user"></i></span>
                <input type="text" id="titular-tarjeta" name="titular-tarjeta" placeholder="Titular de la Tarjeta" required>
            </div>
        </div>
        <button type="submit" class="btn-pagar">Pagar</button>
    </form>
</section>
</body>
</html>