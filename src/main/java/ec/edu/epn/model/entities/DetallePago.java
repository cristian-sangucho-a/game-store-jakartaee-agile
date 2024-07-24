package ec.edu.epn.model.entities;

import jakarta.persistence.*;

@Entity
@Table
public class DetallePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Videojuego videojuego;
    @ManyToOne
    private Pago pago;

    public DetallePago() {
    }

    public DetallePago(int id, Videojuego videojuego, Pago pago) {
        this.id = id;
        this.videojuego = videojuego;
        this.pago = pago;
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

    @Override
    public String toString() {
        return "DetallePago{" +
                "id=" + id +
                ", videojuego=" + videojuego +
                '}';
    }

    public Pago getPago() {
        return pago;
    }
}
