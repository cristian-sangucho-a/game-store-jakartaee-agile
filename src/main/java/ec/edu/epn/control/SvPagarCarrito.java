package ec.edu.epn.control;

import ec.edu.epn.model.entities.Pago;
import ec.edu.epn.model.logic.CarritoDeCompras;
import ec.edu.epn.model.logic.PagoDAO;
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
        String numeroTarjeta = request.getParameter("numero-tarjeta");
        String fechaExpiracion = request.getParameter("fecha-expiracion");
        String cvv = request.getParameter("cvv-tarjeta");
        String titularDeLaTarjeta = request.getParameter("titular-tarjeta");

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
        PagoDAO pagoDao = new PagoDAO();
        HttpSession session = request.getSession();
        CarritoDeCompras carroDeCompras = (CarritoDeCompras) session.getAttribute("carroDeCompras");
        //todo

        //cuando ya acaba de pagarse
        carroDeCompras.borrarTodosLosVideojuegos();
        session.setAttribute("carroDeCompras",carroDeCompras);
        //pagoDao.consolidarCompra(carroDeCompras.getTotalCompra(), titularDeLaTarjeta);
        Pago pago = pagoDao.consolidarCompra(carroDeCompras.getTotalCompra(), titularDeLaTarjeta);
        request.setAttribute("pago", pago);
        try{
            request.getRequestDispatcher("pagoExitoso.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("Pago.jsp");
    }
}
