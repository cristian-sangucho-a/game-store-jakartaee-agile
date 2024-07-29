package ec.edu.epn.model.logic;

import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.services.ManejoEntidadPersistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class ClienteDAO {
    public ClienteDAO() {
    }

    public Cliente obtenerCliente(Cliente cliente) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT v FROM Cliente v WHERE v.correo LIKE :correo and v.contrasenia LIKE :contrasenia");
            query.setParameter("correo", cliente.getCorreo());
            query.setParameter("contrasenia", cliente.getContrasenia());
            return (Cliente) query.getSingleResult();
        } finally {
            entityManager.close();
        }
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

    public int existeCliente(Cliente cliente) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try {
            // Check if the client exists with the given email and password
            Query query = entityManager.createQuery("SELECT v FROM Cliente v WHERE v.correo = :correo AND v.contrasenia = :contrasenia");
            query.setParameter("correo", cliente.getCorreo());
            query.setParameter("contrasenia", cliente.getContrasenia());
            if (!query.getResultList().isEmpty()) {
                return 0; // Client exists with the given email and password
            }

            // Check if the client exists with the given email only
            query = entityManager.createQuery("SELECT v FROM Cliente v WHERE v.correo = :correo");
            query.setParameter("correo", cliente.getCorreo());
            if (!query.getResultList().isEmpty()) {
                return 1; // Client exists with the given email only
            }

            return 2; // Client does not exist with the given email or password
        } finally {
            entityManager.close();
        }
    }

    public boolean existeCliente(String nombreBuscado, String apellidoBuscado) {
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
