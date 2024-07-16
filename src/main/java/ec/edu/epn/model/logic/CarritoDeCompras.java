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

    public void agregarVideojuegoAlCarrito(Videojuego videojuego) {
        videojuegos.put(videojuego, videojuegos.getOrDefault(videojuego, 0) + 1);
    }


    public void borrarTodosLosVideojuegos() {
        videojuegos.clear();
    }

    public double getTotalCompra() {
        double total = 0;
        for (Map.Entry<Videojuego, Integer> entry : videojuegos.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }
        return total;
    }
    public double getTotalCompraPorVideojuego(int videojuegoId) {
        for (Map.Entry<Videojuego, Integer> entry : videojuegos.entrySet()) {
            if (entry.getKey().getId() == videojuegoId) {
                return entry.getKey().getPrecio() * entry.getValue();
            }
        }
        return 0;
    }
    public void actualizarCantidadVideojuego(int videojuegoId, String accion) {
        Videojuego videojuegoAActualizar = null;
        for (Videojuego v : videojuegos.keySet()) {
            if (v.getId() == videojuegoId) {
                videojuegoAActualizar = v;
                break;
            }
        }
        if (videojuegoAActualizar != null) {
            int cantidadActual = videojuegos.get(videojuegoAActualizar);
            if (accion.equals("agregar")) {
                videojuegos.put(videojuegoAActualizar, cantidadActual + 1);
            } else if (accion.equals("quitar")) {
                if (cantidadActual > 1) {
                    videojuegos.put(videojuegoAActualizar, cantidadActual - 1);
                } else {
                    videojuegos.remove(videojuegoAActualizar);
                }
            }
        }
    }
}
