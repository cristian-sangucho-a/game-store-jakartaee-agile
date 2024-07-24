package ec.edu.epn.model.logic;

import ec.edu.epn.model.entities.Videojuego;
import java.util.ArrayList;

/**
 * Clase que representa un carrito de compras para videojuegos.
 * Permite agregar y quitar videojuegos del carrito, verificar si un videojuego está en el carrito,
 * borrar todos los videojuegos del carrito, calcular el total de la compra y obtener la lista de videojuegos en el carrito.
 */
public class CarritoDeCompras {
    // Lista para almacenar los videojuegos en el carrito.
    private ArrayList<Videojuego> videojuegos;

    /**
     * Constructor que inicializa el carrito de compras con una lista vacía de videojuegos.
     */
    public CarritoDeCompras() {
        videojuegos = new ArrayList<>();
    }

    /**
     * Método para quitar un videojuego del carrito de compras.
     * Si el videojuego existe en el carrito, se elimina.
     *
     * @param videojuego El videojuego a quitar del carrito.
     */
    public void quitarVideojuegoDelCarrito(Videojuego videojuego) {
        videojuegos.removeIf(v -> v.getId() == videojuego.getId());
    }

    /**
     * Método para agregar un videojuego al carrito de compras.
     * Si el videojuego no está ya en el carrito, se agrega.
     *
     * @param videojuego El videojuego a agregar al carrito.
     */
    public void agregarVideojuegoAlCarrito(Videojuego videojuego) {
        if(!contieneVideojuego(videojuego)){
            videojuegos.add(videojuego);
        }
    }

    /**
     * Método para verificar si un videojuego específico está en el carrito de compras.
     *
     * @param videojuego El videojuego a verificar.
     * @return true si el videojuego está en el carrito, false en caso contrario.
     */
    public boolean contieneVideojuego(Videojuego videojuego) {
        return videojuegos.stream().anyMatch(v -> v.getId() == videojuego.getId());
    }

    /**
     * Método para eliminar todos los videojuegos del carrito de compras.
     */
    public void borrarTodosLosVideojuegos() {
        videojuegos.clear();
    }

    /**
     * Método para calcular el total de la compra de todos los videojuegos en el carrito.
     *
     * @return El total de la compra.
     */
    public double getTotalCompra() {
        double total = 0;
        for (Videojuego v : videojuegos) {
            total += v.getPrecio();
        }
        return total;
    }

    /**
     * Método para obtener la lista de videojuegos en el carrito de compras.
     *
     * @return La lista de videojuegos en el carrito.
     */
    public ArrayList<Videojuego> getVideojuegos() {
        return this.videojuegos;
    }
}