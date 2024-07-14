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
/**
 * Clase para manejar listas
 */
import java.util.List;

public class VideojuegoDAO {
    /**
     * Constructor vacío para inicializar el DAO para la clase videojuego
     */
    public VideojuegoDAO() {

    }

    /**
     * Método para obtener todos los videojuegos de la base de datos
     * @return un objeto de tipo Query que luego se parsea a List
     * @see Query
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
     * Método para obtener los videojuegos que contengan un título
     * @param tituloDelVideojuego el título obtenido de un formulario
     * @return un objeto de tipo Query que luego se parsea a List
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
     * Método que obtiene los videojuegos por un rango de precio específico
     * @param precioMinimo el precio mínimo que se espera
     * @param precioMaximo el precio máximo como límite superior
     * @return un objeto de tipo Query que luego se parsea a List
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

    public Videojuego obtenerVideojuegoPorId(int IdVideojuego) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v WHERE v.id = :IdVideojuego");
            query.setParameter("IdVideojuego", IdVideojuego);
            return (Videojuego) query.getResultList().get(0);
        } finally {
            entityManager.close();
        }
    }
}
