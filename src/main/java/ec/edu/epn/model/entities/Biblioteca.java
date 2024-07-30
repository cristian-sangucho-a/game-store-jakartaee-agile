package ec.edu.epn.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table
public class Biblioteca {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany
    private ArrayList<Videojuego> videojuegos;

    public Biblioteca() {
        videojuegos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(ArrayList<Videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }
}
