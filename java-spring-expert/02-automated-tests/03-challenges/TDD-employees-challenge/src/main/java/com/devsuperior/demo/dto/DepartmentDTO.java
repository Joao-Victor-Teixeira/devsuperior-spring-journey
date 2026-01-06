package com.devsuperior.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.devsuperior.demo.entities.Department;

public class DepartmentDTO {

	public Long id;
	public String name;

	public List<EmployeeDTO> employees = new ArrayList<>();
	
	public DepartmentDTO() {
	}

	public DepartmentDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

    public DepartmentDTO(Department entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}
}
