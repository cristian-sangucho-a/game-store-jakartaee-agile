<%--
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
    <link rel="stylesheet" href="styles_payment.css">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f5f5f5;
        }
        #seccion-pago-exitoso {
            text-align: center;
            background: #fff;
            padding: 2em;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .contenedor-icono {
            font-size: 4em;
            color: #4caf50;
            margin-bottom: 1em;
        }
        .btn-regresar {
            background-color: #4caf50;
            color: white;
            border: none;
            padding: 0.5em 1em;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            font-size: 1em;
        }
        .btn-regresar:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<section id="seccion-pago-exitoso">
    <div class="contenedor-icono">
        <i class="fa-solid fa-check-circle"></i>
    </div>
    <h2>Pago Exitoso</h2>
    <p>Gracias por tu compra</p>
    <!-- Botón para regresar a la página principal -->
    <form action="index.jsp" method="GET">
        <button type="submit" class="btn-regresar">Regresar a la Página Principal</button>
    </form>
</section>
</body>
</html>
