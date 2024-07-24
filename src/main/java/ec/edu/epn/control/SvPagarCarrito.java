package ec.edu.epn.control;

import ec.edu.epn.model.entities.DetallePago;
import ec.edu.epn.model.entities.Pago;
import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.CarritoDeCompras;
import ec.edu.epn.model.logic.PagoDAO;
import ec.edu.epn.model.logic.ValidarTarjeta;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

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
            response.sendRedirect("seccionPagos.jsp");
            return;
        }
        PagoDAO pagoDAO = new PagoDAO();
        HttpSession session = request.getSession();
        Integer contadorCarrito = (Integer) session.getAttribute("contadorCarrito");
        CarritoDeCompras carroDeCompras = (CarritoDeCompras) session.getAttribute("carroDeCompras");
        double totalCarroDeCompra = carroDeCompras.getTotalCompra();
        ArrayList<Videojuego> videojuegos = carroDeCompras.getVideojuegos();
        ArrayList<DetallePago> detallesDePago =  new ArrayList<DetallePago>();
        for (Videojuego videojuego : videojuegos) {
            DetallePago detallePago = new DetallePago();
            detallePago.setVideojuego(videojuego);
            detallesDePago.add(detallePago);
        }

        //cuando ya acaba de pagarse
        carroDeCompras.borrarTodosLosVideojuegos();
        session.setAttribute("carroDeCompras",carroDeCompras);
        Pago pago = pagoDAO.consolidarCompra(totalCarroDeCompra, titularDeLaTarjeta, detallesDePago);
        contadorCarrito = carroDeCompras.getVideojuegos().toArray().length; // Obtener la cantidad de videojuegos en el carrito
        session.setAttribute("contadorCarrito", contadorCarrito); // Actualizar el contador en la sesión
        request.setAttribute("pago", pago);
        try{
            request.getRequestDispatcher("pagoExitoso.jsp").forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}


