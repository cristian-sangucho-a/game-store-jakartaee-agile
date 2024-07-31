<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrarse</title>
    <link rel="stylesheet" href="styles_register.css">
    <script src="https://kit.fontawesome.com/1a501b4a16.js" crossorigin="anonymous"></script>
</head>
<body>
<section id="registro-usuario">
    <h2>Registro de Usuario</h2>
    <form action="SvRegistrarUsuario" method="POST">
        <div class="grupo-formulario">
            <label for="correo">Correo Electrónico</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-envelope"></i></span>
                <input type="email" id="correo" name="correo" placeholder="Correo Electrónico" required>
            </div>
        </div>
        <div class="grupo-formulario">
            <label for="nombre">Nombre</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-user"></i></span>
                <input type="text" id="nombre" name="nombre" placeholder="Nombre" required>
            </div>
        </div>
        <div class="grupo-formulario">
            <label for="apellido">Apellido</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-user"></i></span>
                <input type="text" id="apellido" name="apellido" placeholder="Apellido" required>
            </div>
        </div>
        <div class="grupo-formulario">
            <label for="contrasena">Contraseña</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-lock"></i></span>
                <input type="password" id="contrasena" name="contrasena" placeholder="Contraseña" required>
            </div>
        </div>
        <div class="grupo-formulario">
            <label for="checkAdmin">Administrador</label>
            <div class="grupo-input">
                <span class="icono-grupo-input"><i class="fas fa-lock"></i></span>
                <label for="checkAdmin"></label><input type="checkbox" id="checkAdmin" name="checkAdmin" value="true">
            </div>
        </div>
        <button type="submit">Registrar</button>
    </form>
</section>
</body>
</html>