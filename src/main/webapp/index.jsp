<%@ page import="java.util.List" %>
<%@ page import="ec.edu.epn.model.Videojuego" %>
<%@ page import="ec.edu.epn.model.VideojuegoDAO" %>
<%--
  Created by IntelliJ IDEA.
  User: Cristian Zambrano
  Date: 08/07/2024
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tienda de Videojuegos</title>
    <script>
        function checkSelection() {
            var categorias = document.getElementById("categorias");
            var buscarInput = document.getElementById("buscarInput");
            var selectedOption = categorias.options[categorias.selectedIndex].value;

            if (selectedOption.startsWith("rangoPrecio")) {
                buscarInput.disabled = true;
            } else {
                buscarInput.disabled = false;
            }
        }
    </script>
</head>
<header>
    <div class="logoHeader">
        <img src="/src/recursos/LogoC3J2.PNG" alt="logo de la pagina web">
        <h1>C3J2</h1>
    </div>
    <div class="busquedaVideojuegos">
        <form action="SvVideojuego">
            <input type="text" placeholder="Buscar">
            <label for="categorias">Filtrar por:</label>
            <select id="categorias" name="categorias">
                <option value="titulo">Por titulo</option>
                <option value="desarrollador">Por desarrollador</option>
                <optgroup label="Por rango de precio">
                    <option value="rangoPrecio_0-10">0 - 10 USD</option>
                    <option value="rangoPrecio_10-20">10 - 20 USD</option>
                    <option value="rangoPrecio_20-50">20 - 50 USD</option>
                    <option value="rangoPrecio_50+">50 USD o más</option>
                </optgroup>
            </select>
            <input id="botonBuscar" type="submit" value="Buscar">
        </form>
    </div>
</header>
<body>
<!--MOSTRAR EL CATALOGO-->
<h1 id="titulo">Bienvenido a la tienda de videojuegos</h1>
<%
    VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
    List<Videojuego> videojuegos = videojuegoDAO.obtenerTodosLosVideojuego();
    for (Videojuego videojuego : videojuegos) {
%>
<div class="cardContainer">
    <div class="card">
        <h4>Titulo del videojuego: <%=videojuego.getTitulo()%></h4>
        <div>
            <img src="/src/recursos/imagenVideojuegoGenerica.webp" alt="Imagen de videojuego">
        </div>
        <p>Desarrollado por: <%=videojuego.getDesarrollador()%></p>
        <p class="precio">Precio: <%=videojuego.getPrecio()%></p>
    </div>
</div>
<%
    }
%>

</body>
</html>
