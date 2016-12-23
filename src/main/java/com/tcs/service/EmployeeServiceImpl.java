package com.tcs.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tcs.dao.*;
import com.tcs.dto.*;

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeedao;

	@Override
	public List<EmployeeDTO> populateTable()
	{
		
		return employeedao.populateTable();
	}
	
	@Override
	public String add(EmployeeDTO s)
	{
		
		return employeedao.add(s);
	}

@Override	
	public String delete(int[] id)
	{
		return employeedao.delete(id);
	}

@Override
public String update(ArrayList<EmployeeDTO> employees)
{
	return employeedao.update(employees);
}
	

}
