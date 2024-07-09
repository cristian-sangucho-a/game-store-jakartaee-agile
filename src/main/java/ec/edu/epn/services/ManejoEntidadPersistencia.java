package ec.edu.epn.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManejoEntidadPersistencia {
    private ManejoEntidadPersistencia() {
    }

    static EntityManagerFactory getEntityManagerFactoryInstance() {
        return Persistence.createEntityManagerFactory("GR01_1BP1_622_24A_PU");
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactoryInstance().createEntityManager();
    }
}
