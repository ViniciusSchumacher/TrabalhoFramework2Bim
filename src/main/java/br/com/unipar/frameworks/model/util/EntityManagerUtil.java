package br.com.unipar.frameworks.model.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    private EntityManagerUtil() { }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("HibernateMaven");
            System.out.println("Conexão aberta");
        }
        return emf;
    }

    public static EntityManager getManager() {
        if (emf == null) {
            getEntityManagerFactory(); // Certifique-se de que emf é inicializado
        }
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
            System.out.println("Entity manager aberta");
        }
        return em;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println("Conexão fechada");
        }
    }
}
