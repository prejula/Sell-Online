package org.prej.ecom.admin.service.impl;

import java.util.List;

import org.prej.ecom.admin.dao.impl.CategoryDAO;
import org.prej.ecom.admin.info.Category;
import org.prej.ecom.admin.service.EcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService implements EcomService<Category>{
	
	private CategoryDAO categoryDAO;
	
	@Autowired
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	@Override
	public String add(Category category) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Category> retrieveByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
