package cn.jboa.action;

import java.util.List;
import java.util.Map;

import cn.jboa.common.Constants;
import cn.jboa.entity.ClaimVoucher;
import cn.jboa.entity.ClaimVoucherDetail;
import cn.jboa.entity.Employee;
import cn.jboa.service.ClaimVoucherService;
import cn.jboa.util.PageSupport;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClaimVoucherAction extends ActionSupport {

	private ClaimVoucherService claimVoucherService;
	private ClaimVoucher claimVoucher;
	private List<ClaimVoucherDetail> detailList;
	private List<ClaimVoucher> list;
	private String startDate;
	private String endDate;
	private String checkResult;
	private Map statusMap;
	private int pageNo;
	private String status;
	private int pageSize;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	private PageSupport pageSupport;

	public List<ClaimVoucher> getList() {
		return list;
	}

	public void setList(List<ClaimVoucher> list) {
		this.list = list;
	}


	public PageSupport getPageSupport() {
		return pageSupport;
	}

	public void setPageSupport(PageSupport pageSupport) {
		this.pageSupport = pageSupport;
	}

	public ClaimVoucherService getClaimVoucherService() {
		return claimVoucherService;
	}

	public void setClaimVoucherService(ClaimVoucherService claimVoucherService) {
		this.claimVoucherService = claimVoucherService;
	}

	public ClaimVoucher getClaimVoucher() {
		return claimVoucher;
	}

	public void setClaimVoucher(ClaimVoucher claimVoucher) {
		this.claimVoucher = claimVoucher;
	}

	public List<ClaimVoucherDetail> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<ClaimVoucherDetail> detailList) {
		this.detailList = detailList;
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

	public String getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	public Map getStatusMap() {
		return statusMap;
	}

	public void setStatusMap(Map statusMap) {
		this.statusMap = statusMap;
	}

	//报销单分页查询
	public String searchClaimVoucher(){
		statusMap = claimVoucherService.getStatus();
		
		String createSn = "";
		String dealSn = "";
		Map session = ActionContext.getContext().getSession();
		Employee ee = (Employee)session.get(Constants.AUTH_EMPLOYEE);
		if(ee.getSysPosition().getId()==1){
			createSn =  ee.getSn();
		}
		else{
			dealSn =  ee.getSn();
		}
		if(pageNo==0){
			pageNo = 1;
		}
		if(pageSize==0){
			pageSize = 5;
		}
		
		String status = "";
		if(claimVoucher!=null){
			status = claimVoucher.getStatus();
			System.out.println("status-----------"+status);
		}
		
		pageSupport = claimVoucherService.getClaimVoucherPage(createSn, dealSn, status, startDate, endDate, pageNo, pageSize);
		
		return "list";
	}
	
	//查看报销单详情
	public String getClaimVoucherById(){
		claimVoucher = claimVoucherService.getCliamVoucherById(claimVoucher.getId());
		return "view";
	}
	
	//跳转到添加报销单页面
	public String toAdd(){
		return "add";
	}
	
	//添加报销单????
	public String saveClaimVoucher(){
		Map session  = ActionContext.getContext().getSession();
		Employee creator = (Employee)session.get(Constants.AUTH_EMPLOYEE);
		claimVoucher.setCreator(creator);
		if (claimVoucher.getStatus().equals(Constants.CLAIMVOUCHER_SUBMITTED)){
			//状态是已提交,下一处理人是经理
			claimVoucher.setNextDeal((Employee)session.get(Constants.AUTH_EMPLOYEE_MANAGER));
		}
		claimVoucher.setDetailList(detailList);
		
		boolean result = claimVoucherService.saveClaimVoucher(claimVoucher);
		if(result){
			this.addActionMessage("添加报销单成功！");
		}else{
			this.addActionMessage("添加报销单失败！");
		}
		return "redirectList";
	}
	
	//删除报销单
	public String deleteClaimVoucherById(){
		Long id = claimVoucher.getId();
		claimVoucherService.deleteClaimVoucher(id);
		return "redirectList";
	}
	
	//跳转到修改页面
	public String toUpdate(){
		claimVoucher = claimVoucherService.getCliamVoucherById(claimVoucher.getId());
		return "update";
	}
	
	//修改报销单
	public String updateClaimVoucher(){
		ClaimVoucher newC = claimVoucherService.getCliamVoucherById(claimVoucher.getId());
		Map session  = ActionContext.getContext().getSession();
		Employee creator = (Employee)session.get(Constants.AUTH_EMPLOYEE);
		claimVoucher.setCreator(creator);
		
		if (claimVoucher.getStatus().equals(Constants.CLAIMVOUCHER_SUBMITTED)){
			//状态是已提交,下一处理人是经理
			newC.setNextDeal((Employee)session.get(Constants.AUTH_EMPLOYEE_MANAGER));
		}
		newC.setEvent(claimVoucher.getEvent());
		newC.setStatus(claimVoucher.getStatus());
		newC.setTotalAccount(claimVoucher.getTotalAccount());
		newC.setDetailList(detailList);
		boolean result = claimVoucherService.updateClaimVoucher(newC);
		System.out.println("-------------------"+result);
		if(result){
			this.addActionMessage("修改报销单成功！");
		}else{
			this.addActionMessage("修改报销单失败！");
		}
		return "redirectList";
		
	}
	
	//跳转到审批报销单页面
	public String toCheck(){
		claimVoucher = claimVoucherService.getCliamVoucherById(claimVoucher.getId());
		return "check";
	}
}
