package cn.jboa.service.impl;

import java.util.Date;

import cn.jboa.common.Constants;
import cn.jboa.dao.CheckResultDao;
import cn.jboa.dao.ClaimVoucherDao;
import cn.jboa.dao.EmployeeDao;
import cn.jboa.entity.CheckResult;
import cn.jboa.entity.ClaimVoucher;
import cn.jboa.entity.Employee;
import cn.jboa.service.CheckResultService;

public class CheckResultServiceImpl implements CheckResultService {

	private CheckResultDao checkResultDao;
	private EmployeeDao employeeDao;
	private ClaimVoucherDao claimVoucherDao;
	
	public void setClaimVoucherDao(ClaimVoucherDao claimVoucherDao) {
		this.claimVoucherDao = claimVoucherDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public void setCheckResultDao(CheckResultDao checkResultDao) {
		this.checkResultDao = checkResultDao;
	}

	//审批报销单（新增审批记录CheckResult）
	@Override
	public boolean checkResult(CheckResult checkResult) {
		boolean bRet = false;
		try{
			//获取CheckResult的claim_id
			Long claimId = checkResult.getClaimId();
			//通过claim_id获取报销单
			ClaimVoucher claimVoucher = (ClaimVoucher)claimVoucherDao.getClaimVoucherById(claimId);
			//获取员工
			Employee empCheck = checkResult.getCheckEmployee();
			//动态更新报销单状态
			claimVoucher = updateClaimVoucherStatus(empCheck.getSysPosition().getNameCn(),
					checkResult.getResult(),claimVoucher);
			//1.修改审批状态（chaimVoucher）
			claimVoucherDao.update(claimVoucher);
			//设置当前时间
			claimVoucher.setModifyTime(new Date(System.currentTimeMillis()));
			checkResult.setCheckTime(new Date(System.currentTimeMillis()));
			//2.新增审批记录（CheckResult）
			checkResultDao.save(checkResult);
			
			bRet = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return bRet;
	}

	//更新报销单状态
	@Override
	public ClaimVoucher updateClaimVoucherStatus(String position,
			String checkResult, ClaimVoucher claimVoucher) {
		if (checkResult.equals(Constants.CHECKRESULT_PASS)){
			//已通过
			if (position.equals(Constants.POSITION_FM)){
				if (claimVoucher.getTotalAccount() >= 5000){
					//待审批，并且处理人为总经理
					claimVoucher.setStatus(Constants.CLAIMVOUCHER_APPROVING);
					claimVoucher.setNextDeal(employeeDao.getGeneralManager());
				}else{
					//已审批，处理人为财务
					claimVoucher.setStatus(Constants.CLAIMVOUCHER_APPROVED);
					claimVoucher.setNextDeal(employeeDao.getCashier());
				}
			}else if(position.equals(Constants.POSITION_GM)){
				//财务已审批，处理人为NULL
				claimVoucher.setStatus(Constants.CLAIMVOUCHER_APPROVED);
				claimVoucher.setNextDeal(employeeDao.getCashier());
			}else{
				claimVoucher.setStatus(Constants.CLAIMVOUCHER_PAID);
				claimVoucher.setNextDeal(null);
			}
		}else if(checkResult.equals(Constants.CHECKRESULT_REJECT)){
			//已拒绝（下一处理人为Null，无人审批）
			claimVoucher.setStatus(Constants.CLAIMVOUCHER_TERMINATED);
			claimVoucher.setNextDeal(null);
			
		}else if(checkResult.equals(Constants.CHECKRESULT_BACK)){
			//已打回（更新状态并将下一处理人更新为创建者）
			claimVoucher.setStatus(Constants.CLAIMVOUCHER_BACK);
			claimVoucher.setNextDeal(claimVoucher.getCreator());
		}
		
		return  claimVoucher;
	}

}
