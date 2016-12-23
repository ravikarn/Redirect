package com.tcs.service;
import com.tcs.dto.EmployeeDTO;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
List<EmployeeDTO> populateTable();
String add(EmployeeDTO s);
String delete(int[] index);
String update(ArrayList<EmployeeDTO> employees);
}
