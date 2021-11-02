package com.lalit;

import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TShirtEntityManagerEx extends TestCase {
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void setUp() throws Exception {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory( "com.lalit.jpa" );
    }

    @Override
    protected void tearDown() throws Exception {
        entityManagerFactory.close();
    }

    public void testBasicUsage() {
        // create tshirts...
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.persist( new TShirt( "NI123", "nike full sleeve",
//                "Blue","U", "XL", 800.00, 4.8, "Y") );
//        entityManager.persist( new TShirt( "PU123", "puma full sleeve",
//                "Pink", "U", "XL", 800.00, 4.0, "Y") );
        entityManager.getTransaction().commit();
        entityManager.close();

        // now pull events from the database and list them
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<TShirt> result = entityManager.createQuery( "from TShirt", TShirt.class ).getResultList();
        for (TShirt tshirt : result ) {
            System.out.println(tshirt);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
