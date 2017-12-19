package cn.jboa.action;

import java.util.Map;

import cn.jboa.common.Constants;
import cn.jboa.entity.Employee;
import cn.jboa.service.ClaimVouyearStatisticsService;
import cn.jboa.util.PageSupport;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClaimVouyearStatisticsAction extends ActionSupport {

	private ClaimVouyearStatisticsService claimVouyearStatisticsService;
	private PageSupport pageSupport;
	private int startYear;
	private int endYear;
	private int pageNo;
	private int pageSize;
	public ClaimVouyearStatisticsService getClaimVouyearStatisticsService() {
		return claimVouyearStatisticsService;
	}
	public void setClaimVouyearStatisticsService(
			ClaimVouyearStatisticsService claimVouyearStatisticsService) {
		this.claimVouyearStatisticsService = claimVouyearStatisticsService;
	}
	public PageSupport getPageSupport() {
		return pageSupport;
	}
	public void setPageSupport(PageSupport pageSupport) {
		this.pageSupport = pageSupport;
	}
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
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
	
	public String findDeptYearStatisticsList(){
		Map<String, Object> session = ActionContext.getContext().getSession();
		Employee emp = (Employee)session.get(Constants.AUTH_EMPLOYEE);
		int deptId = emp.getSysDepartment().getId();
		if(pageNo==0){
			pageNo=1;
		}
		if(pageSize==0){
			pageSize=5;
		}
		
		pageSupport = claimVouyearStatisticsService.getClaimVouyearStatisticsPage(deptId, startYear, endYear, pageNo, pageSize);
				
		return "list";
	}
	
}
