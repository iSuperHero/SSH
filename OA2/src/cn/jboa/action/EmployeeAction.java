package cn.jboa.action;

import java.util.Map;

import cn.jboa.common.Constants;
import cn.jboa.entity.Employee;
import cn.jboa.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport {

	private Employee employee;
	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	//员工登录
	public String login(){
		Employee emp = employeeService.login(employee.getSn(), employee.getPassword());
		if(emp!=null){
			System.out.println("登录成功");
			ActionContext act = ActionContext.getContext();
			Map<String,Object> session = act.getSession();
			session.put(Constants.AUTH_EMPLOYEE,emp);
			return SUCCESS;
		}else{
			System.out.println("登录失败");
			return INPUT;
		}
	}
	
	//员工注销
	public String logout(){
		ActionContext act = ActionContext.getContext();
		Map<String,Object> session = act.getSession();
		session.remove(Constants.AUTH_EMPLOYEE);
		return SUCCESS;
	}
}
