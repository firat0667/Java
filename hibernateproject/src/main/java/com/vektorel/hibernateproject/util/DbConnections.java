/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.hibernateproject.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author fsk
 */
public class DbConnections<T> implements DBOperations<T>{
    
    private Session session;
    private Transaction transaction;
    private Criteria criteria;
    
    public void openSession(){
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void closeSession() {
        transaction.commit();
        session.close();
    }
    
    

    @Override
    public void save(T t) {
        try {
            openSession();
            session.save(t);
            closeSession();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(T t) {
        try {
            openSession();
            session.update(t);
            closeSession();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(T t) {
        try {
            openSession();
            session.delete(t);
            closeSession();
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<T> list(T t) {
        try {
            List<T> list;
            //openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            criteria = session.createCriteria(t.getClass());
            list = criteria.list();
            //closeSession();
            session = HibernateUtil.getSessionFactory().openSession();
            return list;
        }catch (Exception e) {
            throw new IllegalArgumentException("Listelenirken hata olustu.");
        }
    }

    @Override
    public List<T> search(String columnName, String value, T t) {
        List<T> list;
        //openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(t.getClass());
        criteria.add(Restrictions.like(columnName, "%" + value + "%"));
        list = criteria.list();
        //closeSession();
        session.close();
        return list;
    }

    
    //--- REFLECTIONS ----
    @Override
    public T find(Long id, T t) {
        
        T clazz;
        //openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(t.getClass());
        criteria.add(Restrictions.eq("id", id));
        if(criteria.list() == null) {
            return null;
        }else {
            clazz = (T)criteria.list().get(0);
        }
        //closeSession();
        session.close();
        return clazz;
    }

    @Override
    public List<T> advancedList(T t) {
        
        List<T> list;
        //openSession();
        session = HibernateUtil.getSessionFactory().openSession();
        criteria = session.createCriteria(t.getClass());
        
        //REFLECTIONLAR
        
        Class clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try{
            for(int i = 0; i<fields.length; i++) {
                fields[i].setAccessible(true);
                if(fields[i].get(t) != null) {
                    if(fields[i].getType() == String.class) {
                        criteria.add(Restrictions.eq(fields[i].getName(), "%"+fields[i].get(t)+"%"));
                    }else {
                        criteria.add(Restrictions.eq(fields[i].getName(), fields[i].get(t)));
                    }
                }
            }
        }catch(Exception e) {
            
        }
        
        list = criteria.list();
        //closeSession();
        session.close();
        
        return list;
    }

//    public Session getSession() {
//        return session;
//    }
//
//    public void setSession(Session session) {
//        this.session = session;
//    }
//
//    public Transaction getTransaction() {
//        return transaction;
//    }
//
//    public void setTransaction(Transaction transaction) {
//        this.transaction = transaction;
//    }
//
//    public Criteria getCriteria() {
//        return criteria;
//    }
//
//    public void setCriteria(Criteria criteria) {
//        this.criteria = criteria;
//    }
    
    
    
}
