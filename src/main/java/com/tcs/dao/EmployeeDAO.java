package com.tcs.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tcs.dto.EmployeeDTO;
@Repository
public interface EmployeeDAO {

	
	public String add(EmployeeDTO s);
	public List<EmployeeDTO> populateTable();
	public String delete(int[] id);
	public String update(ArrayList<EmployeeDTO> employees);

}
