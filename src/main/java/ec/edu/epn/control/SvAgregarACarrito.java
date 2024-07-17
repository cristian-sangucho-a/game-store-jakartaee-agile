package ec.edu.epn.control;

import ec.edu.epn.model.logic.CarritoDeCompras;
import ec.edu.epn.model.logic.VideojuegoDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SvAgregarACarrito", value = "/SvAgregarACarrito")
/**
 * Servlet controlador para manejar las solicitudes relacionadas con los videojuegos.
 */
public class SvAgregarACarrito extends HttpServlet {
    /**
     * Maneja las solicitudes POST del cliente.
     * @param request an {@link HttpServletRequest} object that contains the request the client has made of the servlet
     *
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     *
     * @throws IOException
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idVideojuego = Integer.parseInt(request.getParameter("idVideojuego"));
        VideojuegoDAO vDAO = new VideojuegoDAO();
        HttpSession session = request.getSession();
        CarritoDeCompras carroDeCompras = (CarritoDeCompras) session.getAttribute("carroDeCompras");
        if (carroDeCompras == null) {carroDeCompras = new CarritoDeCompras();}
        carroDeCompras.agregarVideojuegoAlCarrito(vDAO.obtenerVideojuegoPorId(idVideojuego));
        session.setAttribute("carroDeCompras", carroDeCompras);
        response.sendRedirect("index.jsp");
    }
}