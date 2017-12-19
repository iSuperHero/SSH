package cn.jboa.service;

import cn.jboa.entity.CheckResult;
import cn.jboa.entity.ClaimVoucher;

public interface CheckResultService {

	public boolean checkResult(CheckResult checkResult);
	
	public ClaimVoucher updateClaimVoucherStatus(String position,String checkResult,ClaimVoucher claimVoucher);
}
