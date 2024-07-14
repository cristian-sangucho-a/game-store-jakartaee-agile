package ec.edu.epn.model.logic;

import ec.edu.epn.model.entities.Videojuego;

import java.util.HashMap;
import java.util.Map;

public class CarritoDeCompras {
    private Map<Videojuego, Integer> videojuegos;

    public CarritoDeCompras() {
        videojuegos = new HashMap<>();
    }

    public void quitarVideojuegoDelCarrito(Videojuego videojuego) {
        if (videojuegos.containsKey(videojuego)) {
            int cantidad = videojuegos.get(videojuego);
            if (cantidad > 1) {
                videojuegos.put(videojuego, cantidad - 1);
            } else {
                videojuegos.remove(videojuego);
            }
        }
    }

    public Map<Videojuego, Integer> getVideojuegosDelCarrito() {
        return videojuegos;
    }

    public void agregarVideojuegoAlCarrito(Videojuego videojuegoNuevo) {
    }
}
