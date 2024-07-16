package ec.edu.epn.control;
import ec.edu.epn.model.logic.CarritoDeCompras;
import ec.edu.epn.model.logic.VideojuegoDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet(name = "SvQuitarDeCarrito", value = "/SvQuitarDeCarrito")
public class SvQuitarDeCarrito extends HttpServlet{
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idVideojuego = Integer.parseInt(request.getParameter("idVideojuego"));
        VideojuegoDAO vDAO = new VideojuegoDAO();
        HttpSession session = request.getSession();
        CarritoDeCompras carroDeCompras = (CarritoDeCompras) session.getAttribute("carroDeCompras");
        if (carroDeCompras == null) {carroDeCompras = new CarritoDeCompras();}
        carroDeCompras.quitarVideojuegoDelCarrito(vDAO.obtenerVideojuegoPorId(idVideojuego));
        session.setAttribute("carroDeCompras", carroDeCompras);
        response.sendRedirect("carritoCompras.jsp");
    }

}
