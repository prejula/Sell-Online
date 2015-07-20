package org.prej.ecom.admin.dao.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.prej.ecom.admin.info.Category;
import org.springframework.data.mongodb.core.MongoOperations;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDAOTest {

	@Mock
	private MongoOperations mongoOperations;
	
	@InjectMocks
	private CategoryDAO categoryDAO;
	
	@Test
	public void testAddCategory() throws Exception
	{
		Category category = new Category();
		category.setId("sa2323");
		category.setActive(true);
		category.setName("Mobiles");
		category.setDesc("Mobile phones");
		category.setDepartment("Electronics");

		String result = categoryDAO.add(category);
		
		assertThat(result, is("sa2323"));
		
		verify(mongoOperations).insert(category);
		
		verifyNoMoreInteractions(mongoOperations);
		
	}
	
	public void testGetCategory() throws Exception
	{
		String id = "112";
		
		List<Category> categories = categoryDAO.retrieveByID(id);
		
	}
	
}
