package com.tcs.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;


import com.tcs.dto.EmployeeDTO;
import com.tcs.service.EmployeeService;



@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	List<EmployeeDTO> employeeList=new ArrayList<EmployeeDTO>();


	//Read
	@RequestMapping(value="/get",method=RequestMethod.POST) 
	public @ResponseBody List<EmployeeDTO> getData() {
System.out.println("read controller invoked");
		employeeList=employeeService.populateTable();
		return employeeList;

	}

	//Create
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public @ResponseBody String add(@RequestBody EmployeeDTO emp) throws JSONException
	{
		System.out.println("in java controller");
		System.out.println(emp.getFname());
		return employeeService.add(emp);
	}
	//Delete
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	@ResponseBody
	public String deleteData(@RequestBody int[] index)
	{
		System.out.println("Size.."+employeeList.size());
		System.out.println("Index.."+index);

		for(int i=0;i<index.length;i++)
		{
			System.out.println("Id to be deleted"+index[i]);

		}

		return employeeService.delete(index);

	}
	//Update
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	public String updateData(@RequestBody String emp) throws JSONException
	{

		ArrayList<EmployeeDTO> employees = new ArrayList<EmployeeDTO>();

		Gson gson = new Gson();
		JSONArray js = new JSONArray(emp);


		for(int i = 0 ; i<js.length(); i++)
		{

			String str=js.get(i).toString();
			EmployeeDTO employee=new EmployeeDTO();
			employee=gson.fromJson(str,EmployeeDTO.class);
			employees.add(employee);

		}


		return employeeService.update(employees); 

	}
	
	
	//Upload
		@RequestMapping(value="/upload", method=RequestMethod.POST)
		@ResponseBody
		public String uploadFile(HttpServletRequest request) throws JSONException, IOException
		{
			
								
			
			System.out.println("File upload controller invoked");
			
			//System.out.println(request.getRemoteAddr());
			//Just for commit purpose
			System.out.println(request.getContentType());
			 BufferedReader reader = request.getReader();
			 System.out.println(request.getContentLength());
			 
 			 StringBuilder sb = new StringBuilder();
			 try {
			        String line;
			        while ((line = reader.readLine()) != null) {
			            sb.append(line).append('\n');
			        }
			    } finally {
			        reader.close();
			    }
			    System.out.println(sb.toString());
			/*Map<String,Object> receivedPart=request.getParameterMap();
			for (Map.Entry<String, Object> entry : receivedPart.entrySet())
			{
			    System.out.println(entry.getKey() + "/" + entry.getValue());
			}*/
			
			/*for(MultipartFile tempFile:fileList){
				System.out.println(tempFile.getName());
			}*/
			return null;
		}	
	
}