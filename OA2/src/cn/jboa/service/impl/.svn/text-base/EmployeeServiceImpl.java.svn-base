package cn.jboa.service.impl;

import java.util.List;

import cn.jboa.dao.EmployeeDao;
import cn.jboa.entity.Employee;

public class EmployeeServiceImpl implements cn.jboa.service.EmployeeService {

	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(String sn, String pwd) {
		Employee emp =  employeeDao.getLoginEmp(sn);
		if(null!=emp){
			if(emp.getPassword().equals(pwd)){
				return emp;
			}
		}
		  return null;
	}

	@Override
	public List<Employee> queryManagerByDeptId(int id) {
		return employeeDao.getManagerByDeptId(id);
	}

}
