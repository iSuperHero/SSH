package cn.jboa.action;

import java.util.Map;

import cn.jboa.common.Constants;
import cn.jboa.entity.ClaimVoucherStatistics;
import cn.jboa.entity.Employee;
import cn.jboa.service.ClaimVoucherStatisticsService;
import cn.jboa.util.PageSupport;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClaimVoucherStatisticsAction extends ActionSupport {

	private ClaimVoucherStatisticsService claimVoucherStatisticsService;
	private int year;
	private int startMonth;
	private int endMonth;
	private int pageNo;
	private int pageSize;
	private PageSupport pageSupport;
	private Long departmentId;
	private ClaimVoucherStatistics statisticsDetailOfDeptMonth;
	
	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public ClaimVoucherStatistics getStatisticsDetailOfDeptMonth() {
		return statisticsDetailOfDeptMonth;
	}

	public void setStatisticsDetailOfDeptMonth(
			ClaimVoucherStatistics statisticsDetailOfDeptMonth) {
		this.statisticsDetailOfDeptMonth = statisticsDetailOfDeptMonth;
	}

	public PageSupport getPageSupport() {
		return pageSupport;
	}

	public void setPageSupport(PageSupport pageSupport) {
		this.pageSupport = pageSupport;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(int startMonth) {
		this.startMonth = startMonth;
	}

	public int getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(int endMonth) {
		this.endMonth = endMonth;
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

	public ClaimVoucherStatisticsService getClaimVoucherStatisticsService() {
		return claimVoucherStatisticsService;
	}

	public void setClaimVoucherStatisticsService(
			ClaimVoucherStatisticsService claimVoucherStatisticsService) {
		this.claimVoucherStatisticsService = claimVoucherStatisticsService;
	}

	public String getDeptStatisticsByMonth(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Employee emp = (Employee)session.get(Constants.AUTH_EMPLOYEE);
		int departmentId = emp.getSysDepartment().getId();
		if(pageNo==0){
			pageNo=1;
		}
		if(pageSize==0){
			pageSize=5;
		}
		pageSupport = claimVoucherStatisticsService.getCLaimVoucherStatisticsPage(year, startMonth, endMonth, departmentId, pageNo, pageSize);
		
		return "list";
	}
	
	public String getDeptVoucherDetailByMonth(){
		
		statisticsDetailOfDeptMonth = claimVoucherStatisticsService.getByDeptId(departmentId);
		System.out.println(statisticsDetailOfDeptMonth.getDepartment());
		return "view";
	}
}
