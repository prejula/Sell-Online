package org.prej.ecom.admin.service.impl;

import java.util.List;

import org.prej.ecom.admin.dao.impl.DepartmentDAO;
import org.prej.ecom.admin.info.Department;
import org.prej.ecom.admin.service.EcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ppp on 2/12/2015.
 */
@Component
public class DepartmentService implements EcomService<Department> {

	
    private DepartmentDAO departmentDAO;
    
    @Autowired
    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	@Override
    public String add(Department department) {

		return departmentDAO.add(department);
    }

    @Override
    public int delete(String id) {

    	return departmentDAO.delete(id);
    }

    @Override
    public int update(Department department) {

    	return departmentDAO.update(department);
    }

    @Override
    public List<Department> retrieveByID(String id) {

    	return departmentDAO.retrieveByID(id);
    }
}
