package org.prej.ecom.admin.info;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@Document(collection = "department")
public class Department extends EcomEntity{

	
}
