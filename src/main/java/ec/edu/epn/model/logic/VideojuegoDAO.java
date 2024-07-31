/**
 * Paquete Modelo del patrón MVC
 */
package ec.edu.epn.model.logic;
/**
 * Clase necesaria para abrir y cerrar conexiones
 * @see ec.edu.epn.services.ManejoEntidadPersistencia
 */

import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.services.ManejoEntidadPersistencia;
/**
 * Clase Entity que ayuda a manejar los Persistence Unit
 */
import jakarta.persistence.EntityManager;
/**
 * Clase para manejar Query's por parámetros
 */
import jakarta.persistence.Query;
import jakarta.servlet.http.Part;
/**
 * Clase para manejar listas
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/**
 * Clase VideojuegoDAO que gestiona las operaciones de base de datos para los objetos Videojuego.
 * Proporciona métodos para obtener videojuegos por diferentes criterios como título, rango de precio,
 * desarrollador, y por ID. También permite obtener todos los videojuegos disponibles en la base de datos.
 * Utiliza {@link EntityManager} para interactuar con la base de datos a través de JPA.
 */
public class VideojuegoDAO {
    /**
     * Constructor vacío para inicializar el DAO para la clase videojuego.
     */
    public VideojuegoDAO() {

    }

    /**
     * Método para obtener todos los videojuegos de la base de datos.
     * @return una lista de todos los videojuegos disponibles en la base de datos.
     */
    public List<Videojuego> obtenerTodosLosVideojuego() {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v");
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Método para obtener los videojuegos que contengan un título específico.
     * @param tituloDelVideojuego el título obtenido de un formulario para buscar coincidencias.
     * @return una lista de videojuegos que coinciden con el título proporcionado.
     */
    public List<Videojuego> obtenerVideojuegoPorTitulo(String tituloDelVideojuego) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v WHERE v.titulo LIKE :tituloDelVideojuego");
            query.setParameter("tituloDelVideojuego", "%" + tituloDelVideojuego + "%");
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Método que obtiene los videojuegos por un rango de precio específico.
     * @param precioMinimo el precio mínimo que se espera.
     * @param precioMaximo el precio máximo como límite superior.
     * @return una lista de videojuegos cuyo precio se encuentra dentro del rango especificado.
     */
    public List<Videojuego> obtenerVideojuegosPorRangoDePrecio(double precioMinimo, double precioMaximo) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v from Videojuego v where v.precio between :precioMinimo and :precioMaximo");
            query.setParameter("precioMinimo", precioMinimo);
            query.setParameter("precioMaximo", precioMaximo);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Método para obtener videojuegos desarrollados por un desarrollador específico.
     * @param nombreDeDesarrollador el nombre del desarrollador para buscar coincidencias.
     * @return una lista de videojuegos desarrollados por el desarrollador especificado.
     */
    public List<Videojuego> obtenerVideojuegoPorDesarrollador(String nombreDeDesarrollador) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v WHERE v.Desarrollador = :nombreDeDesarrollador");
            query.setParameter("nombreDeDesarrollador", nombreDeDesarrollador);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Método para obtener un videojuego por su identificador único.
     * @param IdVideojuego el identificador único del videojuego a buscar.
     * @return el videojuego que coincide con el identificador proporcionado.
     */
    public Videojuego obtenerVideojuegoPorId(int IdVideojuego) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v WHERE v.id = :IdVideojuego");
            query.setParameter("IdVideojuego", IdVideojuego);
            return (Videojuego) query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    public void almacenarVideojuego(Videojuego videojuego) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(videojuego);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }
    /**
     * Método para eliminar un videojuego por su identificador único.
     * @param IdVideojuego el identificador único del videojuego a eliminar.
     */
    public void eliminarVideojuegoPorId(int IdVideojuego) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            Videojuego videojuego = entityManager.find(Videojuego.class, IdVideojuego);
            if (videojuego != null) {
                entityManager.remove(videojuego);
            }
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }
}