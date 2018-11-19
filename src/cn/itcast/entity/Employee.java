package cn.itcast.entity;

import java.util.Date;

public class Employee {
	private Integer id;
	private String name;
	private String sex;
	private Date hiredate;
	public Employee() {
	}
	public Employee(Integer id, String name, String sex,Date hiredate) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.hiredate = hiredate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	
}
