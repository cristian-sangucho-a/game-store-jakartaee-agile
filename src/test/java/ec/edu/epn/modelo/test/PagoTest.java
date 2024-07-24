package ec.edu.epn.modelo.test;

import ec.edu.epn.model.entities.*;
import ec.edu.epn.model.logic.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PagoTest {
    public static CarritoDeCompras carritoDeCompras;
    public static PagoDAO pagoDAO;
    public static Pago pago;

    @Before
    public void setUpClass() {
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
        DetallePago detallePago1 = new DetallePago();
        DetallePago detallePago2 = new DetallePago();
        detallePago1.setVideojuego(videojuego1);
        detallePago2.setVideojuego(videojuego2);
        ArrayList<DetallePago> detallesPagos = new ArrayList<>();
        detallesPagos.add(detallePago1);
        detallesPagos.add(detallePago2);
        pago.setTotalCompra(totalCompra);
        pago.setFechaDelPago(fechaDelPago);
        pago.setTitularDeLaTarjeta("Cristian Sangucho");
        pago.setDetallesPagos(detallesPagos);
        pagoDAO.almacenarPago(pago);
        assertTrue(pagoDAO.obtenerPagoPorId(1).getId() == 1);
    }

    @Test
    public void given_cliente_en_insertar_datos_tarjeta_when_pague_then_factura_generada() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.JULY); // Los meses son 0-indexados (Enero es 0, Julio es 6)
        calendar.set(Calendar.DAY_OF_MONTH, 23);
        calendar.set(Calendar.HOUR_OF_DAY, 10); // 10 AM
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);


        carritoDeCompras.getVideojuegos().clear(); //Tener el carrito en 0 para la prueba
        //Suponiendo que el carrito tenga videojuegos dentro
        Videojuego videojuego1 = new Videojuego("Vid1", "Des1", 20.00, null);
        Videojuego videojuego2 = new Videojuego("Vid2", "Des2", 15.00, null);

        carritoDeCompras.agregarVideojuegoAlCarrito(videojuego1);
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuego2);
        //Proceso de pago
        double totalCompra = carritoDeCompras.getTotalCompra();
        Date fechaDelPago = calendar.getTime();
        System.out.println(fechaDelPago);
        DetallePago detallePago1 = new DetallePago();
        DetallePago detallePago2 = new DetallePago();
        detallePago1.setVideojuego(videojuego1);
        detallePago2.setVideojuego(videojuego2);
        ArrayList<DetallePago> detallesPagos = new ArrayList<>();
        detallesPagos.add(detallePago1);
        detallesPagos.add(detallePago2);
        pago.setTotalCompra(totalCompra);
        pago.setFechaDelPago(fechaDelPago);
        pago.setDetallesPagos(detallesPagos);
        pago.setTitularDeLaTarjeta("Cristian Sangucho");
        System.out.println(pago.toString());
        String comparar = "Pago{id=0, totalCompra=20.0, titularDeLaTarjeta='Cristian Sangucho', fechaDelPago=Sun Jul 23 10:30:00 UTC 2023, detallesPagos=[DetallePago{id=0, videojuego=Videojuego{id=0, titulo='Vid1', precio=20.0, Desarrollador='Des1', imageData=null}}, DetallePago{id=0, videojuego=Videojuego{id=0, titulo='Vid2', precio=15.0, Desarrollador='Des2', imageData=null}}]}";
        assertEquals(pago.toString(), comparar);
    }
}