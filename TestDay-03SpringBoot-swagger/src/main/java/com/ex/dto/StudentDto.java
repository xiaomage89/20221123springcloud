package com.ex.dto;


public class StudentDto {
	
	private String name;
	private Integer no;
	private String classname;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	@Override
	public String toString() {
		return "StudentDto [name=" + name + ", no=" + no + ", classname=" + classname + "]";
	}
	public StudentDto(String name, Integer no, String classname) {
		super();
		this.name = name;
		this.no = no;
		this.classname = classname;
	}
	private void student() {
		// TODO Auto-generated method stub

	}
	
}
