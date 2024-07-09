package ec.edu.epn.model;

import jakarta.persistence.*;

@Entity
@Table
public class Videojuego {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private double precio;
    private String Desarrollador;




    public Videojuego(String titulo, String nombreDeDesarrollador, double precio) {
        this.titulo = titulo;
        this.Desarrollador = nombreDeDesarrollador;
        this.precio = precio;
    }

    public Videojuego() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrollador() {
        return Desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.Desarrollador = desarrollador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id + '|' +
                " titulo: " + titulo + '|' +
                " dev: " + Desarrollador + '|' +
                " precio: " + precio +
                '}';
    }

    public int getId() {
        return id;
    }
}
