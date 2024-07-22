package ec.edu.epn.control;

import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.CarritoDeCompras;
import ec.edu.epn.model.logic.VideojuegoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet controlador para manejar las solicitudes relacionadas con los videojuegos.
 */
@WebServlet(name = "SvEliminarTodosLosVideojuegos", value = "/SvEliminarTodosLosVideojuegos")
public class SvEliminarTodosLosVideojuegos extends HttpServlet {
    /**
     * Maneja las solicitudes GET del cliente.
     * @param request  el HttpServletRequest que contiene la solicitud del cliente
     * @param response el HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException      si ocurre un error de entrada/salida
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CarritoDeCompras carroDeCompras = (CarritoDeCompras) session.getAttribute("carroDeCompras");
        Integer contadorCarrito = (Integer) session.getAttribute("contadorCarrito");
        carroDeCompras.borrarTodosLosVideojuegos();
        //Para disminuir el contador
        contadorCarrito = carroDeCompras.getVideojuegos().toArray().length; // Obtener la cantidad de videojuegos en el carrito
        session.setAttribute("contadorCarrito", contadorCarrito); // Actualizar el contador en la sesión

        session.setAttribute("carroDeCompras", carroDeCompras);
        response.sendRedirect("carritoCompras.jsp");
    }
}