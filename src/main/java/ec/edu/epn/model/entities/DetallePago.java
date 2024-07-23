package ec.edu.epn.model.entities;

import jakarta.persistence.*;

@Entity
@Table
public class DetallePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Videojuego videojuego;

    public DetallePago() {
    }

    public DetallePago(int id, Videojuego videojuego) {
        this.id = id;
        this.videojuego = videojuego;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }
}
