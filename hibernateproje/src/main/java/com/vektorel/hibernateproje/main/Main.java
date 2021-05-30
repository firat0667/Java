/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.hibernateproje.main;

import com.vektorel.hibernateproje.models.Ogrenci;
import com.vektorel.hibernateproje.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;

/**
 *
 * transaction commit  rollback
 */
public class Main {
    public static void main(String[] args) {
        Session session =HibernateUtil.getSessionFactoryFactory().openSession();
        Transaction transaction= session.beginTransaction();
        
        
        
        Ogrenci ogrenci1=new Ogrenci();
        ogrenci1.setAdi("Acun");
        ogrenci1.setSoyadi("ılıcalı");
        ogrenci1.setDersAdi("javascript");
        ogrenci1.setTcKimlikNo("1234567890");
        
     //     session.save(ogrenci1);
      //  session.update(ogrenci1);
       // session.delete(ogrenci1);
       
        Criteria cc =session.createCriteria(Ogrenci.class);
        
        List<Ogrenci> liste=cc.list();
        for(Ogrenci item :liste){
            System.out.println(item.getAdi());
            System.out.println(item.getSoyadi());
            System.out.println(item.getDersAdi());
             System.out.println(item.getTcKimlikNo());
            System.out.println("------------------------");
           
            
        }
       
        transaction.commit();
        session.close();
    }
    
}
