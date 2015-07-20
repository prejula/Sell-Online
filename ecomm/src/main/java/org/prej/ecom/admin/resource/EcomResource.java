package org.prej.ecom.admin.resource;

import java.util.List;

import org.prej.ecom.admin.info.EcomEntity;
import org.springframework.http.ResponseEntity;


public interface EcomResource <T extends EcomEntity> {

	public ResponseEntity<T> add(T t);
	
	public List<T> getByID(String id);
	
	public String update(T t);
	
	public String delete(String id);
}
