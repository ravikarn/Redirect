package com.tcs.dto;

public class EmployeeDTO {
private int id;
private String fname;
private String lname;
private String dob;
private int cell;
private int dep;
private boolean check;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public int getCell() {
	return cell;
}
public void setCell(int cell) {
	this.cell = cell;
}
public int getDep() {
	return dep;
}
public void setDep(int dep) {
	this.dep = dep;
}
public boolean isCheck() {
	return check;
}
public void setCheck(boolean check) {
	this.check = check;
	}
}


