package com.tcs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tcs.dto.EmployeeDTO;



@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
	
	
	private DataSource myDataSource;
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public void setDataSource(DataSource myDataSource) {
		this.myDataSource = myDataSource;
		this.jdbctemplate = new JdbcTemplate(myDataSource);
	}
	
	
	//_-_-____________------READ__________________________

	@Override
	public List<EmployeeDTO> populateTable() {
		
		
		
		String sql = "select * from employee order by id";
		List<EmployeeDTO> employeeList = new ArrayList<EmployeeDTO>();
		try{
		employeeList = jdbctemplate.query(sql ,new EmployeeMapper());
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return employeeList;
		
		
	}
//-----------------CREATE____________________________________________________
	@Override
	public String add(EmployeeDTO s) {
		
		String sql = "insert into employee values(?,?,?,?,?,?)";
		String sqlForId="SELECT MAX(id) FROM employee";
		
		int idReceived=jdbctemplate.queryForInt(sqlForId);
		
		
		jdbctemplate.update( sql, new Object[]{idReceived+1,s.getFname(),s.getLname(),s.getDob(),s.getCell(),s.getDep()} );
		
		return "success";
	}

//-------------DELETE-----------------------------------------------------------

	@Override
	public String delete(int[] id)
	{
		String sql=null;
		String result=null;
		for(int i=0;i<id.length;i++)
		{
		try
		{
			sql="delete from employee where id=?";
			jdbctemplate.update(sql,id[i]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		return result;
	}


//---------------------UPDATE-----------------------------------------------------------------
			@Override
			public String update(ArrayList<EmployeeDTO> employees)
			{
				String sql=null;
				String result=null;
				try
				{
					for(int i=0;i<employees.size();i++)
					{
						EmployeeDTO s=employees.get(i);
						sql="update employee set fname=?,lname=?,dob=?,cell=?,dep=? where id=?";
						
						jdbctemplate.update(sql,s.getFname(),s.getLname(),s.getDob(),s.getCell(),s.getDep(),s.getId());
						System.out.println("In DAO.."+s.getId());
					}
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return result;
			}

}
