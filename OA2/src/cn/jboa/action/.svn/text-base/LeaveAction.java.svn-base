package cn.jboa.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.jboa.common.Constants;
import cn.jboa.entity.Employee;
import cn.jboa.entity.Leave;
import cn.jboa.service.EmployeeService;
import cn.jboa.service.LeaveService;
import cn.jboa.util.PageSupport;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LeaveAction extends ActionSupport{

	private LeaveService leaveService;
	private PageSupport pageSupport;
	private int pageNo;
	private int pageSize;
	private String status;
	private String startDate;
	private String endDate;
	private Leave leave;
	private Map statusMap;
	private Map leaveTypeMap;
	private EmployeeService employeeService;
	private List<Employee> manager;

	public List<Employee> getManager() {
		return manager;
	}

	public void setManager(List<Employee> manager) {
		this.manager = manager;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Map getLeaveTypeMap() {
		return leaveService.getLeaveTypeMap();
	}

	public void setLeaveTypeMap(Map leaveTypeMap) {
		this.leaveTypeMap = leaveTypeMap;
	}

	public Leave getLeave() {
		return leave;
	}

	public void setLeave(Leave leave) {
		this.leave = leave;
	}

	public Map getStatusMap() {
		return statusMap;
	}

	public void setStatusMap(Map statusMap) {
		this.statusMap = statusMap;
	}

	public LeaveService getLeaveService() {
		return leaveService;
	}

	public void setLeaveService(LeaveService leaveService) {
		this.leaveService = leaveService;
	}

	public PageSupport getPageSupport() {
		return pageSupport;
	}

	public void setPageSupport(PageSupport pageSupport) {
		this.pageSupport = pageSupport;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	//请假单分页查询
	public String searchLeave(){
		statusMap = leaveService.getStatusMap();
		
		String createSn = "";
		String dealSn = "";
		Map<String, Object> session = ActionContext.getContext().getSession();
		Employee emp = (Employee) session.get(Constants.AUTH_EMPLOYEE);
		if(emp.getSysPosition().getId()==1){
			createSn = emp.getSn();
		}else{
			dealSn = emp.getSn();
		}
		if(pageNo==0){
			pageNo = 1;
		}
		if(pageSize==0){
			pageSize=5;
		}
		
		String status = "";
		if(leave!=null){
			status = leave.getStatus();
		}
		
		pageSupport = leaveService.getLeavePage(createSn, dealSn, status, startDate, endDate, pageNo, pageSize);
		return "list";
	}
	
	//查询请假明细
	public String getLeaveById(){
		leave = leaveService.getLeaveById(leave.getId());
		return "view";
	}
	
	//跳转到申请请假页面
	public String toEdit(){
		Map session = ActionContext.getContext().getSession();
		int deptId = ((Employee)session.get(Constants.AUTH_EMPLOYEE)).getSysDepartment().getId();
		//若为员工，那么下一处理人应该是该部门的项目经理	
		 manager = employeeService.queryManagerByDeptId(deptId);
		for(Employee e:manager){
			System.out.println(e.getSn()+"\t"+e.getName());
		}
		session.put("manager", manager);
		return "edit";
	}
	
	//申请请假
	public String saveLeave(){
		//补充属性
		leave.setCreateTime(new Date());
		leave.setStatus("待审批");
		
		leaveService.saveLeave(leave);
		return "redirectList";
	}
	
	//跳转到审批请假
	public String toCheck(){
		leave = leaveService.getLeaveById(leave.getId());
		return "check";
	}
	
	//审批请假
	public String checkLeave(){
		Leave temp = leaveService.getLeaveById(leave.getId());
		temp.setApproveOpinion(leave.getApproveOpinion());
		temp.setModifyTime(new Date());
		temp.setStatus(leave.getStatus());
		
		leaveService.checkLeave(temp);
		return "redirectList";
	}
}
