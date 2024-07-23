package ec.edu.epn.control;

import ec.edu.epn.model.logic.CarritoDeCompras;
import ec.edu.epn.model.entities.Pago;
import ec.edu.epn.model.logic.ValidarTarjeta;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "SvPagarCarrito", value = "/SvPagarCarrito")
public class SvPagarCarrito  extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String numeroTarjeta = request.getParameter("numeroTarjeta");
        String fechaExpiracion = request.getParameter("fechaExpiracion");
        String cvv = request.getParameter("CVV");
        String titularDeLaTarjeta = request.getParameter("titularDeLaTarjeta");

        pagar(request, response, numeroTarjeta, fechaExpiracion, cvv, titularDeLaTarjeta);
    }

    private static void pagar(HttpServletRequest request, HttpServletResponse response, String numeroTarjeta, String fechaExpiracion, String cvv, String titularDeLaTarjeta) throws IOException {
        ValidarTarjeta  validarTarjeta = new ValidarTarjeta();
        if(!validarTarjeta.validarTarjeta(numeroTarjeta.toCharArray(), fechaExpiracion, cvv)){
            response.setContentType("text/html");
            response.getWriter().print("<html><body><script>alert('¡Pago invalido!');</script></body></html>");
            response.sendRedirect("index.jsp");
            return;
        }
        Pago pago = new Pago();
        HttpSession session = request.getSession();
        CarritoDeCompras carroDeCompras = (CarritoDeCompras) session.getAttribute("carroDeCompras");

        pago.consolidarCompra(carroDeCompras.getTotalCompra(), titularDeLaTarjeta);

        response.sendRedirect("Pago.jsp");
    }
}
