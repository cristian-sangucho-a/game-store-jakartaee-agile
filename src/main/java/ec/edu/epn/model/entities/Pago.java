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
    private Date fechaDelPago;

    public Pago() {
    }

    public Pago(double totalCompra, Date fechaDelPago) {
        this.totalCompra = totalCompra;
        this.fechaDelPago = fechaDelPago;
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

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", totalCompra=" + totalCompra +
                ", fechaDelPago=" + fechaDelPago +
                '}';
    }
}
