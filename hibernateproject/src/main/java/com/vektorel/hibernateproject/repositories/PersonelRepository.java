/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.hibernateproject.repositories;

import com.vektorel.hibernateproject.models.Personel;
import com.vektorel.hibernateproject.util.DbConnections;
import com.vektorel.hibernateproject.util.HibernateUtil;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author fsk
 */
public class PersonelRepository extends DbConnections<Personel> {
    
    //private Session baglanti;
    //private int sonuc = -1;

    public int verification(String userName, String password) {
        int sonuc = -1;
        Session session = null;
        try {
            //openSession();
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Personel.class);
            
            //criteria.add(Restrictions.eq(userName, "username"));
            //criteria.add(Restrictions.eq(password, "password"));
            
            criteria.add(Restrictions.eq("userName", userName));
            criteria.add(Restrictions.eq("password", password));

            if (criteria.list().size() > 0) {
                //sonuc = ((int) criteria.list().get(0));
                sonuc = ((Personel) criteria.list().get(0)).getYetkiId();
                
            }else return -1;

            //closeSession();
            session.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kullanici adi ve sifre hatali");
            return -1;
        } finally {
            //closeSession();
            if(session != null || !session.isOpen()){
                session.close();
            }
        }

        return sonuc;
    }
}
