package org.prej.ecom.admin.resource.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.prej.ecom.admin.info.Category;
import org.prej.ecom.admin.service.impl.CategoryService;
import org.springframework.http.MediaType;

@RunWith(MockitoJUnitRunner.class)
public class CategoryResourceTest {
	
	@Mock
	private CategoryService categoryService;
	
	@InjectMocks
	private CategoryResource categoryResource;
	
	@Test
	public void testAddCategory() throws Exception
	{
		
		standaloneSetup(categoryResource)
		.build()
		.perform(post("/categories")
                        .content("{"
                        		+ "\"name\" : \"Mobiles\", "
                        		+ "\"desc\" : \" Mobile Phones\", "
                        		+ "\"active\" : \"true\", "
                        		+ "\"department\" : \"Electronics \""
                        		+ "}")
                        .contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
		
	}
	
	@Test
	public void testGetCategory() throws Exception
	{
		String id = "122";
		
		List<Category> categories = new ArrayList<Category>();
		
		Category category = new Category();
		category.setId(id);
		category.setDepartment("Electronics");
		category.setName("Mobiles");
		
		categories.add(category);
		
		when(categoryService.retrieveByID(id)).thenReturn(categories);
		
		 standaloneSetup(categoryResource)
		.build()
		.perform(get("/categories/"+ id)
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id", is(id)));
		
		
	}
	

}
