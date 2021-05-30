/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.hibernateproject.main;

import com.vektorel.hibernateproject.models.Personel;
import com.vektorel.hibernateproject.util.Colors;
import com.vektorel.hibernateproject.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import com.vektorel.hibernateproject.models.Personel;

import com.vektorel.hibernateproject.repositories.PersonelRepository;

/**
 *
 * @author fsk
 */
/**
 *
 * Transaction, Commit, Rollback
 */
public class Main {

    public static void main(String[] args) {
        
        Personel oguzhan = new Personel();
        
        oguzhan.setName("Oguzhan");
        oguzhan.setSurname("Koc");
        oguzhan.setTcKimlikNumarasi("12345678910");
        oguzhan.setTelefonNumarasi("05534664698");
        oguzhan.setSicilNo("123");
        oguzhan.setYetkiId(1);
        oguzhan.setUserName("user");
        oguzhan.setPassword("root");
        
        PersonelRepository personelRepository = new PersonelRepository();
        personelRepository.save(oguzhan);
        
        
        
    }

}
