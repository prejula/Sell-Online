package org.prej.ecom.admin.dao.impl;

import java.util.List;

import org.prej.ecom.admin.dao.EcomDAO;
import org.prej.ecom.admin.info.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class CategoryDAO implements EcomDAO<Category>{
	
	private MongoOperations mongoOperations;
	
	@Autowired
	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	public String add(Category category) {
		try {
			
			mongoOperations.insert(category);
			
			return category.getId();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int delete(String id) {
		return 0;
	}

	@Override
	public int update(Category category) {
		return 0;
	}

	@Override
	public List<Category> retrieveByID(String id) {
		return null;
	}


}
