package com.jlcindia.bookstore.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class HibernateTemplate {

    public int save(Object obj) {
    	System.out.println("------User Register (Hibernate Template)-------");
        Transaction tx = null;
        int id = 0;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            tx = session.beginTransaction();
            id = (int) session.save(obj);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx!= null)
                tx.rollback();
        }
        return id;
    }

    public int update(Object obj) {
    	System.out.println("-------Update User (Hibernate Template)-------");
        Transaction tx = null;
        int rowCount = 0;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            tx = session.beginTransaction();
            session.update(obj); // If you want to update via session.update()
            tx.commit();
            session.close();
            rowCount = 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx!= null)
                tx.rollback();
        }
        return rowCount;
    }

    public int delete(Class myclass, Serializable id) {
        Transaction tx = null;
        int rowCount = 0;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            tx = session.beginTransaction();
            Object obj = session.load(myclass, id);
            if (obj!= null) {
                session.delete(obj);
                rowCount = 1; // Assuming one row deleted
            }
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx!= null)
                tx.rollback();
        }
        return rowCount;
    }

    public Object load(Class myclass, Serializable id) {
        Object obj = null;
        Transaction tx = null;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            tx = session.beginTransaction();
            obj = session.load(myclass, id, LockMode.READ);
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx!= null)
                tx.rollback();
        }
        return obj;
    }

    // Additional method to execute HQL queries and return results
    public <T> T executeQuery(String hql, Class<T> clazz, Object... params) {
    	System.out.println("-------Retreving Functionality (Hibernate Template)------");
        Transaction tx = null;
        T result = null;
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            tx = session.beginTransaction();
            Query<T> query = session.createQuery(hql, clazz);
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }

             result = query.uniqueResult();
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx!= null)
                tx.rollback();
        }
        return result;
    }
    
    public <T> List<T> executeQueryList(String hql, Class<T> clazz, Object... params) {
        System.out.println("-------Retrieving List (Hibernate Template)------");
        Transaction tx = null;
        List<T> results = null;
        
        try {
            SessionFactory sf = HibernateUtil.getSessionFactory();
            Session session = sf.openSession();
            tx = session.beginTransaction();
            Query<T> query = session.createQuery(hql, clazz);
            
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
            
            results = query.getResultList();
            tx.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
        
        return results;
    }

}