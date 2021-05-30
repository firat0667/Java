/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.hibernateproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fsk
 */
@Entity
@Table(name = "personel")
public class Personel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 50)
    private String name;
    
    @Column(length = 50)
    private String surname;
    
    @Column(length = 11, unique = true)
    private String tcKimlikNumarasi;
    
    @Column(length = 11)
    private String telefonNumarasi;
    
    @Column(length = 11)
    private String sicilNo;
   
    private int yetkiId;
    
    @Column(length = 20)
    private String userName;
    
    @Column(length = 20)
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTcKimlikNumarasi() {
        return tcKimlikNumarasi;
    }

    public void setTcKimlikNumarasi(String tcKimlikNumarasi) {
        this.tcKimlikNumarasi = tcKimlikNumarasi;
    }

    public String getTelefonNumarasi() {
        return telefonNumarasi;
    }

    public void setTelefonNumarasi(String telefonNumarasi) {
        this.telefonNumarasi = telefonNumarasi;
    }

    public String getSicilNo() {
        return sicilNo;
    }

    public void setSicilNo(String sicilNo) {
        this.sicilNo = sicilNo;
    }

    public int getYetkiId() {
        return yetkiId;
    }

    public void setYetkiId(int yetkiId) {
        this.yetkiId = yetkiId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
}
