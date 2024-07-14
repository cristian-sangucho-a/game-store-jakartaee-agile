package ec.edu.epn.control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.VideojuegoDAO;

/**
 * Servlet controlador para manejar las solicitudes relacionadas con los videojuegos.
 */
@WebServlet(name = "SvVideojuego", value = "/SvVideojuego")
public class SvVideojuego extends HttpServlet {
    /**
     * Maneja las solicitudes GET del cliente.
     *
     * @param request  el HttpServletRequest que contiene la solicitud del cliente
     * @param response el HttpServletResponse que contiene la respuesta del servlet
     * @throws ServletException si ocurre un error específico del servlet
     * @throws IOException      si ocurre un error de entrada/salida
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // Obtener el valor del elemento <select>
        String categorias = request.getParameter("categorias");
        List<Videojuego> videojuegos = new ArrayList<Videojuego>();
        // Filtrar los videojuegos según la categoría seleccionada
        VideojuegoDAO videojuegoDAO = new VideojuegoDAO();
        switch (categorias) {
            case "titulo":
                videojuegos = videojuegoDAO.obtenerVideojuegoPorTitulo(request.getParameter("busqueda"));
                break;
            case "desarrollador":
                videojuegos = videojuegoDAO.obtenerVideojuegoPorDesarrollador(request.getParameter("busqueda"));
                break;
            case "rangoPrecio_0-10":
                videojuegos = videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(0, 10);
                break;
            case "rangoPrecio_10-20":
                videojuegos = videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(10, 20);
                break;
            case "rangoPrecio_20-50":
                videojuegos = videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(20, 50);
                break;
            case "rangoPrecio_50-100":
                videojuegos = videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(50, 100);
                break;
            case "rangoPrecio_100-200":
                videojuegos = videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(100, 200);
                break;
            case "rangoPrecio_200+":
                videojuegos = videojuegoDAO.obtenerVideojuegosPorRangoDePrecio(200, 999999);
                break;
            default:
                break;

        }
        HttpSession sesion = request.getSession();
        sesion.setAttribute("videojuegos", videojuegos);
        response.sendRedirect("catalogoFiltrado.jsp");


    }
}