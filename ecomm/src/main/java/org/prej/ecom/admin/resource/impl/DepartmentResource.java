package org.prej.ecom.admin.resource.impl;

import java.util.List;

import org.prej.ecom.admin.info.Department;
import org.prej.ecom.admin.resource.EcomResource;
import org.prej.ecom.admin.service.impl.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/departments")
@Component
@PreAuthorize("hasAuthority('ROLE_DOMAIN_USER')")
public class DepartmentResource implements EcomResource<Department> {

	private DepartmentService departmentService;

	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Department> add(@RequestBody Department department) {
		
		String resourceId = departmentService.add(department);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(resourceId).toUri());

		ResponseEntity<Department> responseEntity = new ResponseEntity<Department>(httpHeaders, HttpStatus.CREATED);
		
		return responseEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Department> getByID(@PathVariable("id") String id) {

		List<Department> departmentList = departmentService.retrieveByID(id);
		return departmentList;
	}

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody List<Department> getDepartments(@RequestParam("sortyBy") String sortBy) {

		List<Department> departmentList = departmentService.retrieveByID(null);
		return departmentList;
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String update(@RequestBody Department department) {

		return departmentService.update(department) == 1 ? "ok" : "not ok";

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public @ResponseBody String delete(@PathVariable("id") String id) {

		return departmentService.delete(id) == 1 ? "ok" : "not ok";
	}

}
