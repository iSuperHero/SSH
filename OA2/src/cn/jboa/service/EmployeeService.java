package cn.jboa.service;

import java.util.List;

import cn.jboa.entity.Employee;

public interface EmployeeService {

	public Employee login(String sn,String pwd);
	
	public List<Employee> queryManagerByDeptId(int id);
}
