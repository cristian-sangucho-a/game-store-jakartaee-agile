package ec.edu.epn.model.logic;

import ec.edu.epn.model.entities.Videojuego;

import java.util.ArrayList;

public class CarritoDeCompras {
    private ArrayList<Videojuego> videojuegos;

    public CarritoDeCompras() {
        videojuegos = new ArrayList<>();
    }

    public void quitarVideojuegoDelCarrito(Videojuego videojuego) {
        videojuegos.removeIf(v -> v.getId() == videojuego.getId());
    }


    public void agregarVideojuegoAlCarrito(Videojuego videojuego) {
        if(!contieneVideojuego(videojuego)){
            videojuegos.add(videojuego);
        }
    }
    public boolean contieneVideojuego(Videojuego videojuego) {
        return videojuegos.contains(videojuego);
    }

    public void borrarTodosLosVideojuegos() {
        videojuegos.clear();
    }

    public double getTotalCompra() {
        double total = 0;
        for (Videojuego v : videojuegos) {
            total += v.getPrecio();
        }
        return total;
    }
    public ArrayList<Videojuego> getVideojuegos() {
        return videojuegos;
    }
}
