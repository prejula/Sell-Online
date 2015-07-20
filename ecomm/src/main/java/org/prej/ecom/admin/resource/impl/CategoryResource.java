package org.prej.ecom.admin.resource.impl;

import java.util.List;

import org.prej.ecom.admin.info.Category;
import org.prej.ecom.admin.resource.EcomResource;
import org.prej.ecom.admin.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categories")
@Component
public class CategoryResource implements EcomResource<Category>{

	private CategoryService categoryService;
	
	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Category> add(@RequestBody Category category) {
			
		String categoryId = categoryService.add(category);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoryId).toUri());

		ResponseEntity<Category> responseEntity = new ResponseEntity<Category>(httpHeaders, HttpStatus.CREATED);	
		
		return responseEntity;
	}

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Category> getByID(@PathVariable String id) {
		
		return categoryService.retrieveByID(id);
	}

	@Override
	public String update(Category t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
