/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.hibernateproje.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author firat
 */
public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY;
    
    static {
        try {
            SESSION_FACTORY=new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            
            System.err.println("SessionFactory initialize olurken hata meydaan geldi"+ex);
            throw  new ExceptionInInitializerError();
        }
    }
    public  static  SessionFactory getSessionFactoryFactory(){
        return  SESSION_FACTORY;
    }
    
}
