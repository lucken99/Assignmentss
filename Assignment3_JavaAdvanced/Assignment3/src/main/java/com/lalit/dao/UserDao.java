package com.lalit.dao;

import com.lalit.model.User;
import com.lalit.util.HibernateUserUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDao {

    public void saveUser(User user) {
        Transaction transaction = null;
        try (Session session = HibernateUserUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(user);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public boolean validate(String userName, String password) {
        Transaction transaction = null;
        User user = null;
        try (Session session = HibernateUserUtil.getSessionFactory().openSession()) {
            System.out.println(2);
            transaction = session.beginTransaction();
            System.out.println(3);
            user = (User) session.createQuery("FROM User U WHERE U.username = :userName")
                    .setParameter("userName", userName)
                    .uniqueResult();
            System.out.println(4);
            if (user != null && user.getPassword().equals(password)) {
                return true;
            }
            System.out.println(5);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(6);
            if (transaction != null) {
                System.out.println(7);
                e.printStackTrace();
                transaction.rollback();
            }
            System.out.println("Error While validating!");
            e.printStackTrace();
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
