package cn.jboa.action;

import java.util.Map;

import cn.jboa.common.Constants;
import cn.jboa.entity.CheckResult;
import cn.jboa.entity.Employee;
import cn.jboa.service.CheckResultService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckResultAction extends ActionSupport {
	
	private CheckResultService checkResultService;
	
	private CheckResult checkResult;

	public CheckResultService getCheckResultService() {
		return checkResultService;
	}

	public void setCheckResultService(CheckResultService checkResultService) {
		this.checkResultService = checkResultService;
	}

	public CheckResult getCheckResult() {
		return checkResult;
	}

	public void setCheckResult(CheckResult checkResult) {
		this.checkResult = checkResult;
	}
	
	public String checkClaimVoucher(){
		//获取当前登录用户（部门经理）
		Map session  = ActionContext.getContext().getSession();
		Employee checkEmp = (Employee)session.get(Constants.AUTH_EMPLOYEE);
		checkResult.setCheckEmployee(checkEmp);
		//添加审批信息，修改审批结果，审批时间，审批人
		boolean bRet = checkResultService.checkResult(checkResult);
		if (bRet){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
}
