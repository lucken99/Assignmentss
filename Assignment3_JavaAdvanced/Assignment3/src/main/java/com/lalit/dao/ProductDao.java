package com.lalit.dao;

import com.lalit.model.Product;
import com.lalit.util.HibernateProductUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDao {
    public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateProductUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Product> getProductList() {
        Session session = HibernateProductUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Product");
        List<Product> details = query.list();
        session.close();
        return details;
    }
    public Object getSizeSum(int id) {
        Session session = HibernateProductUtil.getSessionFactory().openSession();
        Query q1 = session.createQuery("select imageSize from Product where id='" + id + "'");
        Object obj=q1.uniqueResult();
        session.close();
        return obj;
    }

    public void deleteProductDetail(int id) {
        Session session = HibernateProductUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Product where id='" + id + "'");
        int row = q.executeUpdate();
        if (row == 0)
            System.out.println("no rows deleted");
        // commit transaction
        transaction.commit();
        session.close();
    }
    public List<Product> getProductDetailViaId(int id) {
        Session session = HibernateProductUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Product where id='"+id+"'");
        List<Product> details=query.list();
        session.close();
//	    for(UserImage img:details) {
//	    	System.out.println(img.getImageName());
//	    }
        return details;
    }

    public void editProductDetail(String title, int qty, double imgSize, int id) {
        Session session = HibernateProductUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Product set title='" + title + "' , imageSize = '" + imgSize + "', qty = '" + qty
                + "' where id = '" + id +  "'");
        int row = q.executeUpdate();
        if (row == 0)
            System.out.println("no rows deleted");
        // commit transaction
        transaction.commit();
        session.close();
    }
}
