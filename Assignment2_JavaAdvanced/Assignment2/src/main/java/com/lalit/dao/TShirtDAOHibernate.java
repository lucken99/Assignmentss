package com.lalit.dao;

import com.lalit.TShirt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TShirtDAOHibernate {
    private static final EntityManagerFactory entityManagerFactory;

    // like SessionFactory, an EntityManagerFactory is set up once for an application
    // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
    static  {
        entityManagerFactory = Persistence.createEntityManagerFactory( "com.lalit.jpa" );
    }
    public void insertTShirtDataInDB(TShirt tShirt) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(tShirt);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<TShirt> searchTShirts(String colour, String gender, String size) {
        List<TShirt> result = new ArrayList<>();

        return result;
    }
}
