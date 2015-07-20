package org.prej.ecom.admin.dao.impl;

import java.util.List;

import org.prej.ecom.admin.dao.EcomDAO;
import org.prej.ecom.admin.info.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.mongodb.WriteResult;

/**
 * Created by ppp on 2/12/2015.
 */
@Component
public class DepartmentDAO implements EcomDAO<Department> {
	private MongoOperations mongoOperations;

	@Autowired
	public void setMongoOperations(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public String add(Department department) {

		try {
			mongoOperations.save(department);
			
			return department.getId();
		} catch (Exception e) {
			
			return null;
		}
	}

	@Override
	public int delete(String id) {
		Query query = new Query(Criteria.where("_id").is(id));

		WriteResult departmentResult = mongoOperations.remove(query,
				Department.class);

		return departmentResult.getN() > 0 ? 1 : 0;

	}

	@Override
	public int update(Department department) {

		Query query = new Query(Criteria.where("_id").is(department.getId()));

		WriteResult departmentResult = mongoOperations.updateMulti(query,
				Update.update("desc", department.getDesc()), Department.class);

		return departmentResult.getN() > 0 ? 1 : 0;

	}

	@Override
	public List<Department> retrieveByID(String id) {

		Query query = new Query(Criteria.where("_id").is(id));

		List<Department> departments = mongoOperations.find(query,
				Department.class);

		return departments;
	}
}
