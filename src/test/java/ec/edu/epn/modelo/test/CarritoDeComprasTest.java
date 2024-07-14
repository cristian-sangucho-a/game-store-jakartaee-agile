
package ec.edu.epn.modelo.test;

import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.model.logic.CarritoDeCompras;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarritoDeComprasTest {
    public static CarritoDeCompras carritoDeCompras;

    @BeforeClass
    public static void setUpClass() {
        carritoDeCompras = new CarritoDeCompras();
    }

    @Test
    public void given_cliente_en_carrito_when_elimine_juego_then_eliminar_juego_del_carrito(){
        Videojuego videojuegoNuevo = new Videojuego(); //Necesito que esté
        carritoDeCompras.agregarVideojuegoAlCarrito(videojuegoNuevo);//Necesito que esté
        carritoDeCompras.quitarVideojuegoDelCarrito(videojuegoNuevo);
        assertFalse(carritoDeCompras.getVideojuegosDelCarrito().containsValue(videojuegoNuevo));
    }

    @Test
    public void given_cliente_en_carrito_when_agregue_juego_then_el_videojuego_estara_en_el_carrito(){
        Videojuego videojuegoAAgregar = new Videojuego();
        this.carritoDeCompras.agregarVideojuegoAlCarrito(videojuegoAAgregar);
        assertTrue(this.carritoDeCompras.getVideojuegosDelCarrito().containsKey(videojuegoAAgregar));
    }




}
