package ec.edu.epn.model.logic;

import ec.edu.epn.model.entities.Cliente;
import ec.edu.epn.services.ManejoEntidadPersistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ClienteDAO {
    public ClienteDAO() {
    }

    public Cliente obtenerCliente(Cliente cliente) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Cliente v WHERE v.correo LIKE :correo and v.contrasenia LIKE :contrasenia");
            query.setParameter("correo", "%" + cliente.getCorreo()+ "%");
            query.setParameter("contrasenia", "%" + cliente.getContrasenia() + "%");
            return (Cliente) query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    public int existeCliente(Cliente cliente) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT v FROM Cliente v WHERE v.correo LIKE :correo AND v.contrasenia LIKE :contrasenia");
            query.setParameter("correo", "%" + cliente.getCorreo() + "%");
            query.setParameter("contrasenia", "%" + cliente.getContrasenia() + "%");
            if (query.getResultList().size() > 0) {
                return 0; // el cliente existe con su correo y contrasenia
            }
            query = entityManager.createQuery("SELECT v FROM Cliente v WHERE v.correo LIKE :correo");
            query.setParameter("correo", "%" + cliente.getCorreo() + "%");
            if (query.getResultList().size() > 0) {
                return 1; // solo el correo esta correcto
            }

            return 2; // no hay cliente
        } finally {
            entityManager.close();
        }
    }


}
