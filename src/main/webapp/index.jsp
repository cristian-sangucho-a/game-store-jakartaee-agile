<%@ page import="java.util.List" %>
<%@ page import="ec.edu.epn.model.entities.Videojuego" %>
<%@ page import="ec.edu.epn.model.logic.VideojuegoDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tienda de Videojuegos</title>
    <script>
        //Script de js que permite verificar la selección del checkbox del documento
        function checkSelection() {
            var categorias = document.getElementById("categorias");
            var buscarInput = document.getElementById("buscarInput");
            var selectedOption = categorias.options[categorias.selectedIndex].value;

            if (selectedOption.startsWith("rangoPrecio_")) {
                buscarInput.disabled = true;
            } else {
                buscarInput.disabled = false;
            }
        }
    </script>
    <script src="https://kit.fontawesome.com/1a501b4a16.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles1.css">
</head>
<body>
<header>
    <div class="logoHeader">
        <img alt="LogoC3J2.PNG" src="data:image/png;base64,iVBOR...=" />
        <h1>C3J2</h1>
    </div>
    <div class="busquedaVideojuegos">
        <form action="SvVideojuego" method="GET">
            <input id="buscarInput" name="busqueda" type="text" placeholder="Buscar">
            <label for="categorias">Filtrar por:</label>
            <select id="categorias" name="categorias" onchange="checkSelection()">
                <option value="titulo">Por título</option>
                <option value="desarrollador">Por desarrollador</option>
                <optgroup label="Por rango de precio">
                    <option value="rangoPrecio_0-10">0 - 10 USD</option>
                    <option value="rangoPrecio_10-20">10 - 20 USD</option>
                    <option value="rangoPrecio_20-50">20 - 50 USD</option>
                    <option value="rangoPrecio_50-100">50 - 100 USD</option>
                    <option value="rangoPrecio_100-200">100 - 200 USD</option>
                    <option value="rangoPrecio_200+">200 USD o más</option>
                </optgroup>
            </select>
            <input id="botonBuscar" type="submit" value="Buscar">
        </form>
    </div>
    <a href="carritoCompras.jsp">
        <i class="fa fa-cart-arrow-down" aria-hidden="true"></i>
    </a>
</header>

<h1 id="titulo">Bienvenido a la tienda de videojuegos</h1>
<div class="cardContainer">
    <%
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        List<Videojuego> videojuegos = videojuegoDAO.obtenerTodosLosVideojuego();
        for (Videojuego videojuego : videojuegos) {
    %>
    <div class="card">
        <h3><%=videojuego.getTitulo()%></h3>
        <div>
            <img src="data:image/png;base64,<%=videojuego.getImageDataString()%>" alt="imagenDeVideojuego">
        </div>
        <p>Desarrollado por: <%=videojuego.getDesarrollador()%></p>
        <p class="precio">Precio: <%=videojuego.getPrecio()%></p>
        <form action="SvAgregarACarrito" method="post">
            <input type="hidden" name="idVideojuego" value="<%=videojuego.getId()%>">
            <button type="submit" class="btn-agregar">Agregar al carrito</button>
        </form>
    </div>
    <%
        }
    %>
</div>

<div class="boton-volver">
    <a href="index.jsp">Volver a la página principal</a>
</div>

</body>
</html>
