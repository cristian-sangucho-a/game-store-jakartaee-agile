package ec.edu.epn.model.entities;

import jakarta.persistence.*;

/**
 * Clase DetallePago que representa el detalle de cada pago realizado.
 * Esta clase gestiona la relación entre los pagos y los videojuegos comprados,
 * manteniendo un registro de cada videojuego incluido en un pago.
 */
@Entity
@Table
public class DetallePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Videojuego asociado a este detalle de pago.
     * La relación es de muchos a uno, indicando que varios detalles de pago pueden referenciar a un mismo videojuego.
     */
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Videojuego videojuego;

    /**
     * Pago al que pertenece este detalle.
     * La relación es de muchos a uno, indicando que varios detalles de pago pueden pertenecer a un mismo pago.
     */
    @ManyToOne
    private Pago pago;

    /**
     * Constructor por defecto.
     */
    public DetallePago() {
    }

    /**
     * Constructor con parámetros para crear un detalle de pago con información específica.
     *
     * @param id El identificador único del detalle de pago.
     * @param videojuego El videojuego asociado a este detalle de pago.
     * @param pago El pago al que pertenece este detalle.
     */
    public DetallePago(int id, Videojuego videojuego, Pago pago) {
        this.id = id;
        this.videojuego = videojuego;
        this.pago = pago;
    }

    /**
     * Obtiene el ID del detalle de pago.
     *
     * @return El ID del detalle de pago.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del detalle de pago.
     *
     * @param id El ID del detalle de pago.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el videojuego asociado a este detalle de pago.
     *
     * @return El videojuego asociado.
     */
    public Videojuego getVideojuego() {
        return videojuego;
    }

    /**
     * Establece el videojuego asociado a este detalle de pago.
     *
     * @param videojuego El videojuego a asociar.
     */
    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }

    /**
     * Obtiene el pago al que pertenece este detalle.
     *
     * @return El pago asociado.
     */
    public Pago getPago() {
        return pago;
    }

    /**
     * Establece el pago al que pertenece este detalle.
     *
     * @param pago El pago a asociar.
     */
    public void setPago(Pago pago) {
        this.pago = pago;
    }

    /**
     * Representación en cadena de texto de un objeto DetallePago.
     *
     * @return Una cadena de texto que representa el objeto DetallePago.
     */
    @Override
    public String toString() {
        return "DetallePago{" +
                "id=" + id +
                ", videojuego=" + videojuego +
                '}';
    }
}