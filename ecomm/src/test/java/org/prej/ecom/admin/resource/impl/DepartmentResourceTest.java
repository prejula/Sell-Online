package org.prej.ecom.admin.resource.impl;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.prej.ecom.admin.service.impl.DepartmentService;
import org.springframework.http.MediaType;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentResourceTest {
  
	@Mock
	private DepartmentService departmentService; 
	
	
	@InjectMocks
    private DepartmentResource departmentResource;

    @Test
	public void testAddDepartment() throws Exception {
    	
    	/*Department department = new Department();
    	department.setActive(true);
    	department.setName("Electronics");
    	department.setDesc("All Electronic Equipments");    	
    	
    	when(departmentService.add(department)).thenReturn("100");*/
    	
		standaloneSetup(departmentResource)
                .build()
                .perform(post("/departments")
                        .content("{"
                        		+ "\"name\" : \"Electronics\", "
                        		+ "\"desc\" : \" All Electronic Equipments\", "
                        		+ "\"active\" : \"true\""
                        		+ "}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_XML))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "http://localhost/departments/"));
		
	}

    @Test
    public void testGetDepartment() throws Exception
    {
        standaloneSetup(departmentResource)
                .build()
                .perform(get("/departments/10"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testGetAllDepartments() throws Exception
    {
    	standaloneSetup(departmentResource)
    	.build()
    	.perform(get("/departments?sortyBy=descending"))
    	.andExpect(status().isOk());
    }


    @Test
    public void testUpdateDepartment() throws Exception
    {
        standaloneSetup(departmentResource)
                .build()
                .perform(put("/departments").content("{"
                        		+ "\"name\" : \"Electronics\", "
                        		+ "\"desc\" : \" All Electronic Equipments\", "
                        		+ "\"active\" : \"true\""
                        		+ "}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());


    }

    @Test
    public void testDeleteDepartment() throws Exception
    {
        standaloneSetup(departmentResource)
                .build()
                .perform(delete("/departments/10"))
                .andExpect(status().isNoContent());
    }
}
