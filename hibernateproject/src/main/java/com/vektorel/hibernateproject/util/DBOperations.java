/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.hibernateproject.util;

import java.util.List;

/**
 *
 * @author fsk
 */
public interface DBOperations<T> {
    
    void save(T t);
    void update(T t);
    void delete(T t);
    List<T> list(T t);
    List<T> search(String columnName, String value, T t);
    T find(Long id, T t);
    List<T> advancedList(T t);
    
}
