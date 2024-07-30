package ec.edu.epn.model.logic;

import ec.edu.epn.model.entities.Biblioteca;
import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.services.ManejoEntidadPersistencia;
import jakarta.persistence.EntityManager;

public class BibliotecaDAO {

    public BibliotecaDAO() {
    }

    public void agregarVideojuego(Videojuego videojuegoPagado, Biblioteca bibliotecaCliente) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try {
            entityManager.getTransaction().begin();
            bibliotecaCliente.getVideojuegos().add(videojuegoPagado);
            entityManager.merge(bibliotecaCliente);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }
}
