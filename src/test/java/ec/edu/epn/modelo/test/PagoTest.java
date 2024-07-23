package ec.edu.epn.modelo.test;

import ec.edu.epn.model.entities.*;
import ec.edu.epn.model.logic.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertTrue;

public class PagoTest {
    public static CarritoDeCompras carritoDeCompras;
    public static PagoDAO pagoDAO;
    public static Pago pago;

    @BeforeClass
    public static void setUpClass() {
        carritoDeCompras = new CarritoDeCompras();
        pagoDAO = new PagoDAO();
        pago = new Pago();
    }

    @Test
    public void given_cliente_en_carrito_when_introduzca_tarjeta_y_pague_then_pago_almacenado() {
        carritoDeCompras.getVideojuegos().clear(); //Tener el carrito en 0 para la prueba
        //Suponiendo que el carrito tenga videojuegos dentro
        Videojuego videojuego1 = new Videojuego();
        videojuego1.setPrecio(10.0);
        Videojuego videojuego2 = new Videojuego();
        videojuego2.setPrecio(20.0);
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuego1);
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuego2);
        //Proceso de pago
        double totalCompra = carritoDeCompras.getTotalCompra();
        Date fechaDelPago = new Date();
        DetallePago detallePago = new DetallePago();
        detallePago.setVideojuego(videojuego1);
        detallePago.setVideojuego(videojuego2);
        ArrayList<DetallePago> detallesPagos = new ArrayList<>();
        detallesPagos.add(detallePago);
        pago.setTotalCompra(totalCompra);
        pago.setFechaDelPago(fechaDelPago);
        pago.setTitularDeLaTarjeta("Cristian Sangucho");
        pago.setDetallesPagos(detallesPagos);
        pagoDAO.almacenarPago(pago);
        assertTrue(pagoDAO.obtenerPagoPorId(1).getId() == 1);
    }
}
