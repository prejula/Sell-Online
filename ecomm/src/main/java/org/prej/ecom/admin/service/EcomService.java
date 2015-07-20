package org.prej.ecom.admin.service;

import java.util.List;

import org.prej.ecom.admin.info.EcomEntity;

/**
 * Created by ppp on 2/12/2015.
 */
public interface EcomService <T extends EcomEntity> {

    public String add(T t);

    public int delete(String id);

    public int update(T t);

    public List<T> retrieveByID(String id);
    
}
