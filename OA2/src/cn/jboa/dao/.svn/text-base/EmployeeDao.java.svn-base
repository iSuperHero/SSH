package cn.jboa.dao;

import java.util.List;

import cn.jboa.entity.Employee;

public interface EmployeeDao {

	//员工登录，通过工号获取员工信息
	public Employee getLoginEmp(String sn);
	
	//加载部门经理列表
	public List<Employee> getManagerByDeptId(int id);
	
	public Employee getManager(Employee employee);
	
	public Employee getGeneralManager();
	
	public Employee getCashier();//
}
