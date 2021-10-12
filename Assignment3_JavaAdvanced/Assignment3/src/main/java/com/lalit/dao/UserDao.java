package com.lalit.dao;

import com.lalit.model.User;
import com.lalit.util.HibernateUserUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {

    public boolean validate(String username, String password) {
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUserUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            user = (User) session.createQuery("FROM User U WHERE U.username = :username")
                    .setParameter("username", username)
                    .uniqueResult();
            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println("Error While validating!");
        }
        return false;
    }

    public List<User> getUserList(){
        Session session = HibernateUserUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User");
        List<User> details=query.list();
        session.close();
        return details;
    }
    public void changePassword(String password ,String username) {
        Session session = HibernateUserUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("update User set password='" + password +"' where userName = '" + username +  "'");
        int x=query.executeUpdate();
        tx.commit();
        session.close();
    }
}
