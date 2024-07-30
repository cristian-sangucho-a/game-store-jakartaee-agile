package ec.edu.epn.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Biblioteca {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nombre;
    @ManyToMany
    @JoinTable(
            name = "biblioteca_videojuego", // Join table name
            joinColumns = @JoinColumn(name = "biblioteca_id"), // Foreign key for Biblioteca
            inverseJoinColumns = @JoinColumn(name = "videojuego_id") // Foreign key for Videojuego
    )
    private List<Videojuego> videojuegos;

    public Biblioteca(String nombre) {
        videojuegos = new ArrayList<>();
        this.nombre = nombre;
    }

    public Biblioteca() {
        videojuegos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }
}
