<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="styles_login.css">
    <script src="https://kit.fontawesome.com/1a501b4a16.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="login-container">
    <div class="login-image">
        <img src="../../recursos/wallpaper_login.jpg" alt="Login Wallpaper">
    </div>
    <section id="login-usuario">
        <h2>Iniciar Sesión</h2>
        <form action="SvIniciarSesion" method="POST">
            <div class="grupo-formulario">
                <label for="correo">Correo Electrónico</label>
                <div class="grupo-input">
                    <span class="icono-grupo-input"><i class="fas fa-envelope"></i></span>
                    <input type="email" id="correo" name="correo" placeholder="Correo Electrónico" required>
                </div>
            </div>
            <div class="grupo-formulario">
                <label for="contrasena">Contraseña</label>
                <div class="grupo-input">
                    <span class="icono-grupo-input"><i class="fas fa-lock"></i></span>
                    <input type="password" id="contrasena" name="contrasena" placeholder="Contraseña" required>
                </div>
            </div>
            <button type="submit">Iniciar Sesión</button>
        </form>
        <p class="registro-link">¿No tienes una cuenta? <a href="registrarse.jsp">Regístrate</a></p>
    </section>
</div>
</body>
</html>