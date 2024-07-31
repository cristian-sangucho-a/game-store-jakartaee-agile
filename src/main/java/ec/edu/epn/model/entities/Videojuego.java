/**
 * Paquete del modelo del patrón MVC
 */
package ec.edu.epn.model.entities;
/**
 * Librería para el uso de la persistencia de Jakarta
 */

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Base64;

/**
 * Clase Videojuego para la persistencia de la información
 * Contiene un id generado automáticamente
 * @see Persistence
 */
@Entity
@Table
public class Videojuego {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private double precio;
    private String Desarrollador;

    @Lob
    @Column(name = "image_data" ,columnDefinition="VARBINARY(MAX)")
    private byte[] imageData;

    /**
     * Constructor de la clase videojuego
     * @param titulo El título del videojuego
     * @param nombreDeDesarrollador El precio del videojuego
     * @param precio El desarrollador del videojuego
     */
    public Videojuego(String titulo, String nombreDeDesarrollador, double precio, byte[] imageData) {
        this.titulo = titulo;
        this.Desarrollador = nombreDeDesarrollador;
        this.precio = precio;
        this.imageData = imageData;
    }
    /**
     * Constructor público de la clase Videojuego
     */
    public Videojuego() {
    }

    /**
     * Getter del título del videojuego
     * @return un String del atributo título
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setter del título del videojuego
     * @param titulo el atributo del título del videojuego
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Getter del desarrollador del videojuego
     * @return un String con el desarrollador
     */
    public String getDesarrollador() {
        return Desarrollador;
    }

    /**
     * Setter del atributo de desarrollador
     * @param desarrollador un String con el desarrollador
     */
    public void setDesarrollador(String desarrollador) {
        this.Desarrollador = desarrollador;
    }

    /**
     * Getter del precio del videojuego
     * @return Un double del precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Setter del precio del videojuego
     * @param precio un double para el precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getId(){
        return id;
    }

    /**
     * Método sobre-escrito toString
     *
     * @return un String especificando el formato de los datos del videojuego
     * @see String
     */
    @Override
    public String toString() {
        return "Videojuego{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", Desarrollador='" + Desarrollador + '\'' +
                ", imageData=" + Arrays.toString(imageData) +
                '}';
    }

    /**
     * Setter del id del videojuego
     * @param id un entero con el id del videojuego
     */
    public void setId(int id){
        this.id = id;
    }


    public String getImageDataString(){
        return Base64.getEncoder().encodeToString(this.imageData);
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    @Override
    public boolean equals(Object obj) {
        if (titulo.equals(((Videojuego) obj).getTitulo()) &&
                precio == (((Videojuego) obj).getPrecio()) &&
                Desarrollador.equals(((Videojuego) obj).getDesarrollador()) && imageData.equals(((Videojuego) obj).getImageData())) {
            return true;
        }else return false;
    }
}
