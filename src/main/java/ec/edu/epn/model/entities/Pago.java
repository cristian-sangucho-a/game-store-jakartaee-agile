package ec.edu.epn.model.entities;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
@Entity
@Table
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalCompra;
    private String titularDeLaTarjeta;
    private Date fechaDelPago;
    @OneToMany(mappedBy = "pago", cascade = CascadeType.PERSIST)
    private ArrayList<DetallePago> detallesPagos;

    public Pago() {
    }

    public Pago(double totalCompra, Date fechaDelPago, String titularDeLaTarjeta, ArrayList<DetallePago> detallesPagos) {
        this.totalCompra = totalCompra;
        this.fechaDelPago = fechaDelPago;
        this.titularDeLaTarjeta = titularDeLaTarjeta;
        this.detallesPagos = detallesPagos;
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

    public String getTitularDeLaTarjeta() {
        return titularDeLaTarjeta;
    }

    public void setTitularDeLaTarjeta(String titularDeLaTarjeta) {
        this.titularDeLaTarjeta = titularDeLaTarjeta;
    }

    public Date getFechaDelPago() {
        return fechaDelPago;
    }

    public void setFechaDelPago(Date fechaDelPago) {
        this.fechaDelPago = fechaDelPago;
    }

    public ArrayList<DetallePago> getDetallesPagos() {
        return detallesPagos;
    }

    public void setDetallesPagos(ArrayList<DetallePago> detallesPagos) {
        this.detallesPagos = detallesPagos;
    }

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
