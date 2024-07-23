package ec.edu.epn.model.logic;

import ec.edu.epn.model.entities.Pago;
import ec.edu.epn.services.ManejoEntidadPersistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Date;
import java.util.List;

public class PagoDAO {

    public PagoDAO() {
    }

    public Pago obtenerPagoPorId(int idPago) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Pago v WHERE v.id LIKE :idPago");
            query.setParameter("idPago", "%" + idPago + "%");
            return (Pago) query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    public Pago obtenerUltimoPago() {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try {
            Query query = entityManager.createQuery("SELECT v FROM Pago v ORDER BY v.id DESC");
            query.setMaxResults(1);
            return (Pago) query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    public void consolidarPago(Pago pagoAPersistir){
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(pagoAPersistir);
            entityManager.getTransaction().commit();
        } finally {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
        }
    }

}
