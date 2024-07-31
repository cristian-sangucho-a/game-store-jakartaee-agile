package ec.edu.epn.model.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name = "cliente",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "correo")
        }
)
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String apellido;

    @Column(unique = true)
    private String correo;

    private String contrasenia;
    private boolean esAdmin;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idBiblioteca")
    private Biblioteca biblioteca;

    public Cliente() {
        biblioteca = new Biblioteca();
    }

    public Cliente(String correo, String contrasenia, boolean esAdmin) {
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
    }

    public Cliente( String nombre,  String apellido, String correo, String contrasenia, boolean esAdmin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.esAdmin = esAdmin;
        this.biblioteca = new Biblioteca(nombre+"_Biblioteca");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", esAdmin=" + esAdmin +
                '}';
    }
}
