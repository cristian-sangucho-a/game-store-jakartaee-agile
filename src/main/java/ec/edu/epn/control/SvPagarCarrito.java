package ec.edu.epn.control;

import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.model.entities.DetallePago;
import ec.edu.epn.model.entities.Pago;
import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.BibliotecaDAO;
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
    /**
     * Maneja las solicitudes POST enviadas al servlet.
     * Este método recupera los datos de la tarjeta de crédito del formulario enviado, valida la tarjeta,
     * y si es válida, procede con el proceso de pago.
     *
     * @param request  Objeto {@link HttpServletRequest} que contiene la solicitud del cliente.
     * @param response Objeto {@link HttpServletResponse} que contiene la respuesta que el servlet envía al cliente.
     * @throws IOException Si ocurre un error de entrada/salida durante el procesamiento de la solicitud.
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String numeroTarjeta = request.getParameter("numero-tarjeta");
        String fechaExpiracion = request.getParameter("fecha-expiracion");
        String cvv = request.getParameter("cvv-tarjeta");
        String titularDeLaTarjeta = request.getParameter("titular-tarjeta");

        pagar(request, response, numeroTarjeta, fechaExpiracion, cvv, titularDeLaTarjeta);
    }

    /**
     * Realiza el proceso de pago utilizando los datos de la tarjeta de crédito proporcionados.
     * Valida la tarjeta, realiza el pago si la validación es exitosa, y actualiza el estado del carrito de compras.
     *
     * @param request            Objeto {@link HttpServletRequest} que contiene la solicitud del cliente.
     * @param response           Objeto {@link HttpServletResponse} que contiene la respuesta que el servlet envía al cliente.
     * @param numeroTarjeta      Número de la tarjeta de crédito proporcionada por el usuario.
     * @param fechaExpiracion    Fecha de expiración de la tarjeta de crédito proporcionada por el usuario.
     * @param cvv                Código CVV de la tarjeta de crédito proporcionada por el usuario.
     * @param titularDeLaTarjeta Nombre del titular de la tarjeta de crédito proporcionada por el usuario.
     * @throws IOException Si ocurre un error de entrada/salida durante el procesamiento de la solicitud.
     */
    private static void pagar(HttpServletRequest request, HttpServletResponse response, String numeroTarjeta, String fechaExpiracion, String cvv, String titularDeLaTarjeta) throws IOException {
        ValidarTarjeta  validarTarjeta = new ValidarTarjeta();
        if(!validarTarjeta.validarTarjeta(numeroTarjeta.toCharArray(), fechaExpiracion, cvv)){
            response.sendRedirect("ingresoTarjeta.jsp");
            return;
        }
        BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
        PagoDAO pagoDAO = new PagoDAO();
        HttpSession session = request.getSession();
        Integer contadorCarrito = (Integer) session.getAttribute("contadorCarrito");
        CarritoDeCompras carroDeCompras = (CarritoDeCompras) session.getAttribute("carroDeCompras");
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        double totalCarroDeCompra = carroDeCompras.getTotalCompra();
        ArrayList<Videojuego> videojuegos = carroDeCompras.getVideojuegos();
        ArrayList<DetallePago> detallesDePago =  new ArrayList<DetallePago>();

        for (Videojuego videojuego : videojuegos) {
            DetallePago detallePago = new DetallePago();
            detallePago.setVideojuego(videojuego);
            detallesDePago.add(detallePago);
            bibliotecaDAO.agregarVideojuego(videojuego, cliente.getBiblioteca());
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


