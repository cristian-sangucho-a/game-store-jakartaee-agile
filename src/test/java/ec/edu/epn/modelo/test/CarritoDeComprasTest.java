
package ec.edu.epn.modelo.test;

import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.CarritoDeCompras;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class CarritoDeComprasTest {
    public static CarritoDeCompras carritoDeCompras;

    @BeforeClass
    public static void setUpClass() {
        carritoDeCompras = new CarritoDeCompras();
    }

    @Test
    public void given_cliente_en_carrito_when_elimine_juego_then_eliminar_juego_del_carrito(){
        carritoDeCompras.getVideojuegos().clear();
        Videojuego videojuegoNuevo = new Videojuego();
        videojuegoNuevo.setId(1);//Necesito que esté
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuegoNuevo);//Necesito que esté
        carritoDeCompras.quitarVideojuegoDelCarrito(videojuegoNuevo);
        assertFalse(carritoDeCompras.getVideojuegos().contains(videojuegoNuevo));
    }

    @Test
    public void given_cliente_en_carrito_when_agregue_juego_then_el_videojuego_estara_en_el_carrito(){
        carritoDeCompras.getVideojuegos().clear();
        Videojuego videojuegoAAgregar = new Videojuego();
        videojuegoAAgregar.setId(1);
        videojuegoAAgregar.setTitulo("Juego de prueba");
        videojuegoAAgregar.setDesarrollador("Jean Pierre");
        videojuegoAAgregar.setImageData(new byte[] {0, 0, 0, 0});
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuegoAAgregar);
        assertTrue(carritoDeCompras.getVideojuegos().contains(videojuegoAAgregar));
    }
    @Test
    public void given_cliente_en_carrito_when_vacie_Carrito_then_lista_vacia() {
        carritoDeCompras.getVideojuegos().clear();
        Videojuego videojuego1 = new Videojuego();
        videojuego1.setId(1);
        Videojuego videojuego2 = new Videojuego();
        videojuego2.setId(2);
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuego1);
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuego2);
        carritoDeCompras.borrarTodosLosVideojuegos();
        assertTrue(carritoDeCompras.getVideojuegos().isEmpty());
    }
    @Test
    public void given_cliente_en_carrito_when_agregue_juegos_then_mostrar_precios_totales() {
        carritoDeCompras.getVideojuegos().clear();
        Videojuego videojuego1 = new Videojuego();
        videojuego1.setId(1);
        videojuego1.setPrecio(10.0);
        Videojuego videojuego2 = new Videojuego();
        videojuego2.setId(2);
        videojuego2.setPrecio(20.0);
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuego1);
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuego2);
        assertEquals(30.0, carritoDeCompras.getTotalCompra(), 0.001);
    }

}
