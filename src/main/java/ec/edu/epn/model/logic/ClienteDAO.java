package ec.edu.epn.model.logic;

import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.model.entities.Videojuego;
import ec.edu.epn.services.ManejoEntidadPersistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ClienteDAO {

    public ClienteDAO() {
    }

    public void almacenarCliente(Cliente clienteAPersistir){
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(clienteAPersistir);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }

    public boolean existeEsteCliente(String nombreBuscado, String apellidoBuscado) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Cliente v WHERE v.nombre=:nombreBuscado and v.apellido=:apellidoBuscado");
            query.setParameter("nombreBuscado", nombreBuscado);
            query.setParameter("apellidoBuscado", apellidoBuscado);
            List<Cliente> clientes = query.getResultList();
            return !clientes.isEmpty();
        } finally {
            entityManager.close();
        }
    }


}
