package com.nagarro.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.model.User;
import com.nagarro.model.UserProduct;

import com.nagarro.util.HibernateUtil;

public class UserProductDao {
	public void saveUserProduct(UserProduct userProduct) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(userProduct);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
        	if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
	public List<UserProduct> getUserProductList(){
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Query query = session.createQuery("from UserProduct");
	    List<UserProduct> details=query.list();
	    session.close();
	    return details;
    }
	
	public Object getSizeSum(String userName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query q1 = session.createQuery("select SUM(productSize) from UserProduct where UserName='" + userName + "'");
		Object obj=q1.uniqueResult();
		session.close();
		return obj;
	}
	public void deleteProductDetail(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("delete from UserProduct where id='" + id + "'");
		int row = q.executeUpdate();
		if (row == 0)
			System.out.println("no rows deleted");
		// commit transaction
        transaction.commit();
        session.close();
	}
	public List<UserProduct> getImageDetailViaId(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
    	Query query = session.createQuery("from UserProduct where id='"+id+"'");
	    List<UserProduct> details=query.list();
	    session.close();

	    return details;
	}
	
	public void editProductDetail(String productTitle, long productSize, int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query q = session.createQuery("update UserProduct set productTitle='" + productTitle + "' , productSize = '" + productSize
				+ "' where id = '" + id +  "'");
		int row = q.executeUpdate();
		if (row == 0)
			System.out.println("no rows deleted");
		// commit transaction
        transaction.commit();
        session.close();
	}
}
