package org.prej.ecom.admin.info;

import java.sql.Timestamp;

import org.springframework.data.annotation.Id;

public class EcomEntity {

	@Id
	private String id;

	private String name;
	
	private String desc;
	
	private boolean active;
	
	private Timestamp timestamp;
	
	private int status;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	} 
	
}
