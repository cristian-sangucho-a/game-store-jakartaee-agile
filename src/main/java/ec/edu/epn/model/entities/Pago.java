package ec.edu.epn.model.entities;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalCompra;
    @Transient
    private String titularDeLaTarjeta;
    private Date fechaDelPago;

    public Pago() {
    }

    public Pago(double totalCompra, Date fechaDelPago, String titularDeLaTarjeta) {
        this.totalCompra = totalCompra;
        this.fechaDelPago = fechaDelPago;
        this.titularDeLaTarjeta = titularDeLaTarjeta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Date getFechaDelPago() {
        return fechaDelPago;
    }

    public void setFechaDelPago(Date fechaDelPago) {
        this.fechaDelPago = fechaDelPago;
    }

    public String getTitularDeLaTarjeta() {
        return titularDeLaTarjeta;
    }

    public void setTitularDeLaTarjeta(String titularDeLaTarjeta) {
        this.titularDeLaTarjeta = titularDeLaTarjeta;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", totalCompra=" + totalCompra +
                ", fechaDelPago=" + fechaDelPago +
                '}';
    }
}
