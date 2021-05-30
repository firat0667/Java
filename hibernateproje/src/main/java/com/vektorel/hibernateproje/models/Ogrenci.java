/*
  bir java class ın veritabanı tablosuna karsılık gelmesi için asgari ihtiyaçlar 
@entity  @table  @ıd annotasyonudur 
 */
package com.vektorel.hibernateproje.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Ogrenci")


public class Ogrenci  implements Serializable{
    @Id
    @SequenceGenerator(name="sql_ogrenci_id",sequenceName ="sql_ogrenci_id",
    initialValue = 1,allocationSize = 1)
    @GeneratedValue(generator ="sql_ogrenci_id")
    
    
    private Long id;
    @Column(length = 30,name = "Adi")
    private  String adi;
    @Column(length = 30,name = "Soyadi")
    private  String soyadi;
    @Column(length = 11,unique = true,name = "kimlikNumarası")
    private  String tcKimlikNo;
    @Column(length = 30,name = "DersAdi")
    private  String  dersAdi;

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getTcKimlikNo() {
        return tcKimlikNo;
    }

    public void setTcKimlikNo(String tcKimlikNo) {
        this.tcKimlikNo = tcKimlikNo;
    }

    public String getDersAdi() {
        return dersAdi;
    }

    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }
    
    
    
}
