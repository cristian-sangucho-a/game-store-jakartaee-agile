package ec.edu.epn.modelo.test;

import ec.edu.epn.model.entities.*;
import ec.edu.epn.model.logic.*;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertTrue;

public class PagoTest {
    public static CarritoDeCompras carritoDeCompras;
    public static PagoDAO pagoDAO;
    public static Pago pago;

    @BeforeClass
    public static void setUpClass() {
        carritoDeCompras = new CarritoDeCompras();
    }

    @Test
    public void given_cliente_en_carrito_when_introduzca_tarjeta_y_pague_then_pago_almacenado() {
        carritoDeCompras.getVideojuegos().clear(); //Tener el carrito en 0 para la prueba
        pago.setId(0);
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
        pago.setId(1);
        pago.setTotalCompra(totalCompra);
        pago.setFechaDelPago(fechaDelPago);
        pagoDAO.consolidarPago(pago);
        assertTrue(pagoDAO.obtenerPagoPorId(1) == pago);
    }
}
