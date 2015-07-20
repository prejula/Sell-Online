package org.prej.ecom.admin.service.impl;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
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
import org.prej.ecom.admin.dao.impl.DepartmentDAO;
import org.prej.ecom.admin.info.Department;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {
  
	@Mock
	private DepartmentDAO departmentDAO; 
	
	
	@InjectMocks
    private DepartmentService departmentService;

    @Test
	public void testAddDepartment() throws Exception {
    	
    	Department department = new Department();
    	department.setActive(true);
    	department.setDesc("abc");
    	department.setName("a");

    	departmentService.add(department);
	}

    @Test
    public void testGetDepartment() throws Exception
    {
    	
    	String id = "10asd";
    	List<Department> departments = new ArrayList<Department>();
    	
    	Department department = new Department();
    	department.setId(id);
    	department.setName("Clothing");
    	
    	departments.add(department);
    	
    	when(departmentDAO.retrieveByID(id)).thenReturn(departments);
    	
    	departments = departmentService.retrieveByID(id);
    	
    	assertNotNull(departments);
    	
    	for (Department dept : departments){
    		
    		assertThat(dept.getId(), is(id));
    	}
    }


    @Test
    public void testUpdateDepartment() throws Exception
    {
    	Department department = new Department();
    	department.setActive(true);
    	department.setDesc("abc");
    	department.setName("a");

    	when(departmentDAO.update(department)).thenReturn(1);
    	
    	int result = departmentService.update(department);
    	
    	assertThat(result, is(1));
    	
    	verify(departmentDAO).update(department);
    	
    	verifyNoMoreInteractions(departmentDAO);
    }

    @Test
    public void testDeleteDepartment() throws Exception
    {
    	when(departmentDAO.delete("10")).thenReturn(1);
    	
    	int result = departmentService.delete("10");
    	
    	assertThat(result, is(1));
    }
}
