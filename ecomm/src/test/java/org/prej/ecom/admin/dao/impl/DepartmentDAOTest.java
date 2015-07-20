package org.prej.ecom.admin.dao.impl;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.prej.ecom.admin.info.Department;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentDAOTest {
  
	@Mock
	private MongoOperations mongoOperations;
	@Mock
	private WriteResult writeResultMock;
	
	@InjectMocks
    private DepartmentDAO departmentDAO;

    @Test
	public void testAddDepartment() throws Exception {

    	Department department = new Department();
    	department.setActive(true);
    	department.setDesc("abc");
    	department.setName("a");

    	departmentDAO.add(department);
    }

    @Test
    public void testGetDepartment() throws Exception
    {
    	String id = "10";
    	
    	Department department = new Department();
    	department.setId(id);
    	department.setActive(true);
    	department.setName("Clothing");
    	department.setDesc("Clothing for men, women and children");
    	
    	List<Department> departments = new ArrayList<Department>();
    	departments.add(department);
    	
    	when( mongoOperations.find(new Query(Criteria.where("_id").is(id)), Department.class)).thenReturn(departments);
    	
    	List<Department> departmentList = departmentDAO.retrieveByID(id);
    	
    	assertNotNull(departmentList);
    	
    	for (Department dept : departmentList){
    		
    		assertThat(department.getId(), is(dept.getId()));
    		assertThat(department.getName(), is(dept.getName()));
    		assertThat(department.getDesc(), is(dept.getDesc()));
    		assertThat(department.isActive(), is(dept.isActive()));
    	}
    	
    	verify(mongoOperations).find(new Query(Criteria.where("_id").is(id)), Department.class);
    	
    	verifyNoMoreInteractions(mongoOperations);
    }

    @Test
    public void testUpdateDepartment() throws Exception
    {
    	Department department = new Department();
    	department.setActive(true);
    	department.setDesc("a1bc");
    	department.setName("a");
    	
    	when(writeResultMock.getN()).thenReturn(10);
    	
    	Query query = new Query(Criteria.where("_id").is(department.getId()));

		when(mongoOperations.updateMulti(query,
				Update.update("desc", department.getDesc()), Department.class)).thenReturn(writeResultMock);
    	
    	int result = departmentDAO.update(department);
    	
    	assertThat(result, is(1));
    	
    	verify(mongoOperations).updateMulti(query,
				Update.update("desc", department.getDesc()), Department.class);
    	
    	verifyNoMoreInteractions(mongoOperations);
    }

    @Test
    public void testDeleteDepartment() throws Exception
    {
    	
    		when(writeResultMock.getN()).thenReturn(100);
    		
    		when(mongoOperations.remove(new Query(Criteria.where("_id").is("10")),
    				Department.class)).thenReturn(writeResultMock);

    		int result = departmentDAO.delete("10");
    		
    		assertThat(result, is(1));
    		
    		verify(mongoOperations).remove(new Query(Criteria.where("_id").is("10")),
    				Department.class);
        	
        	verifyNoMoreInteractions(mongoOperations);
    }
}
