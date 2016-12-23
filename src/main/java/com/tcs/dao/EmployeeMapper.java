package com.tcs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tcs.dto.EmployeeDTO;

public class EmployeeMapper implements RowMapper<EmployeeDTO>
{

	public EmployeeDTO mapRow(ResultSet rs,int rowNum) throws SQLException
	{
		EmployeeDTO emp=new EmployeeDTO();
		emp.setId(rs.getInt("id"));
		emp.setFname(rs.getString("fname"));
		emp.setLname(rs.getString("lname"));
		emp.setDob(rs.getString("dob"));
		emp.setCell(rs.getInt("cell"));
		emp.setDep(rs.getInt("dep"));
		emp.setCheck(false);
		return emp;
	}
}
