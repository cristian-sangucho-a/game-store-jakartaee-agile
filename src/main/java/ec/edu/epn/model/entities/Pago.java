package ec.edu.epn.model.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase Pago que representa el pago realizado por un cliente.
 * Esta clase gestiona la información relacionada con los pagos, incluyendo el total de la compra,
 * el titular de la tarjeta, la fecha del pago y los detalles de los pagos asociados.
 */
@Entity
@Table
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalCompra;
    private String titularDeLaTarjeta;
    private Date fechaDelPago;

    @OneToMany(mappedBy = "pago", cascade = CascadeType.ALL)
    private List<DetallePago> detallesPagos;

    /**
     * Constructor por defecto que inicializa la fecha del pago a la fecha actual del sistema.
     */
    public Pago() {
        this.fechaDelPago = new Date();
    }

    /**
     * Constructor con parámetros para crear un objeto Pago con información específica.
     *
     * @param totalCompra El total de la compra realizada.
     * @param fechaDelPago La fecha en la que se realiza el pago.
     * @param titularDeLaTarjeta El nombre del titular de la tarjeta de crédito.
     * @param detallesPagos Lista de detalles de los pagos asociados a este pago.
     */
    public Pago(double totalCompra, Date fechaDelPago, String titularDeLaTarjeta, ArrayList<DetallePago> detallesPagos) {
        this.totalCompra = totalCompra;
        this.fechaDelPago = fechaDelPago;
        this.titularDeLaTarjeta = titularDeLaTarjeta;
        this.detallesPagos = detallesPagos;
    }

    /**
     * Obtiene el ID del pago.
     *
     * @return El ID del pago.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del pago.
     *
     * @param id El ID del pago.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el total de la compra.
     *
     * @return El total de la compra.
     */
    public double getTotalCompra() {
        return totalCompra;
    }

    /**
     * Establece el total de la compra.
     *
     * @param totalCompra El total de la compra.
     */
    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    /**
     * Obtiene el nombre del titular de la tarjeta.
     *
     * @return El nombre del titular de la tarjeta.
     */
    public String getTitularDeLaTarjeta() {
        return titularDeLaTarjeta;
    }

    /**
     * Establece el nombre del titular de la tarjeta.
     *
     * @param titularDeLaTarjeta El nombre del titular de la tarjeta.
     */
    public void setTitularDeLaTarjeta(String titularDeLaTarjeta) {
        this.titularDeLaTarjeta = titularDeLaTarjeta;
    }

    /**
     * Obtiene la fecha del pago.
     *
     * @return La fecha del pago.
     */
    public Date getFechaDelPago() {
        return fechaDelPago;
    }

    /**
     * Establece la fecha del pago.
     *
     * @param fechaDelPago La fecha del pago.
     */
    public void setFechaDelPago(Date fechaDelPago) {
        this.fechaDelPago = fechaDelPago;
    }

    /**
     * Obtiene la lista de detalles de pagos asociados a este pago.
     *
     * @return La lista de detalles de pagos.
     */
    public List<DetallePago> getDetallesPagos() {
        return detallesPagos;
    }

    /**
     * Establece la lista de detalles de pagos asociados a este pago.
     *
     * @param detallesPagos La lista de detalles de pagos.
     */
    public void setDetallesPagos(ArrayList<DetallePago> detallesPagos) {
        this.detallesPagos = detallesPagos;
    }

    /**
     * Representación en cadena de texto de un objeto Pago.
     *
     * @return Una cadena de texto que representa el objeto Pago.
     */
    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", totalCompra=" + totalCompra +
                ", titularDeLaTarjeta='" + titularDeLaTarjeta + '\'' +
                ", fechaDelPago=" + fechaDelPago +
                ", detallesPagos=" + detallesPagos +
                '}';
    }
}