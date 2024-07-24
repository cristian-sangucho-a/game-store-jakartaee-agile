package ec.edu.epn.model.logic;

import ec.edu.epn.model.entities.DetallePago;
import ec.edu.epn.model.entities.Pago;
import ec.edu.epn.services.ManejoEntidadPersistencia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.Date;

/**
 * Clase PagoDAO que proporciona la lógica para operar sobre los objetos Pago en la base de datos.
 * Incluye métodos para obtener pagos por ID, obtener el último pago realizado, almacenar un nuevo pago,
 * y consolidar una compra generando un nuevo pago.
 */
public class PagoDAO {

    /**
     * Constructor por defecto de PagoDAO.
     */
    public PagoDAO() {
    }

    /**
     * Obtiene un pago por su identificador único.
     *
     * @param idPago El identificador único del pago a buscar.
     * @return El objeto Pago encontrado o null si no existe.
     */
    public Pago obtenerPagoPorId(int idPago) {
        EntityManager entityManager = ManejoEntidadPersistencia.getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Pago v WHERE v.id = :idPago");
            query.setParameter("idPago", idPago);
            return (Pago) query.getSingleResult();
        } finally {
            entityManager.close();
        }
    }

    /**
     * Obtiene el último pago realizado en la base de datos.
     *
     * @return El último objeto Pago registrado.
     */
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

    /**
     * Almacena un objeto Pago en la base de datos.
     *
     * @param pagoAPersistir El objeto Pago a persistir.
     */
    public void almacenarPago(Pago pagoAPersistir){
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

    /**
     * Consolida una compra creando un nuevo objeto Pago y almacenándolo en la base de datos.
     * Este método también asocia los detalles de pago proporcionados al nuevo pago.
     *
     * @param totalCompra El total de la compra realizada.
     * @param titularDeLaTarjeta El nombre del titular de la tarjeta de crédito.
     * @param detallesDePago La lista de objetos DetallePago asociados a la compra.
     * @return El objeto Pago creado y almacenado.
     */
    public Pago consolidarCompra(double totalCompra, String titularDeLaTarjeta, ArrayList<DetallePago> detallesDePago) {
        Pago pago = new Pago();
        pago.setTotalCompra(totalCompra);
        pago.setTitularDeLaTarjeta(titularDeLaTarjeta);
        pago.setDetallesPagos(detallesDePago);
        almacenarPago(pago);
        return pago;
    }
}