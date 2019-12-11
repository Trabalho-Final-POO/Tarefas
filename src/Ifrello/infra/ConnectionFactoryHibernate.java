package Ifrello.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//GUSTAVO MARTINS PACHECO       HT3000231
//LAÍS JAQUELINE DA SILVA LOPES HT3000168


public class ConnectionFactoryHibernate {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        try {
            if (emf == null) {
                emf = Persistence.createEntityManagerFactory("TarefaPU");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return emf.createEntityManager();
    }
}
