package ec.edu.epn.control;

import ec.edu.epn.model.logic.CarritoDeCompras;
import ec.edu.epn.model.logic.VideojuegoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "SvActualizarCarrito", value = "/SvActualizarCarrito")
public class SvActualizarCarrito extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        CarritoDeCompras carroDeCompras = (CarritoDeCompras)  session.getAttribute("carroDeCompras");
        if(carroDeCompras == null) {
            carroDeCompras = new CarritoDeCompras();
            session.setAttribute("carroDeCompras", carroDeCompras);
        }
        carroDeCompras.actualizarCantidadVideojuego(Integer.parseInt(request.getParameter("idVideojuego")), (String) request.getParameter("accion"));
        response.sendRedirect("carritoCompras.jsp");
    }
}
