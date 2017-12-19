package cn.jboa.service;

import java.util.List;
import java.util.Map;

import cn.jboa.entity.ClaimVoucher;
import cn.jboa.util.PageSupport;

public interface ClaimVoucherService {

	public PageSupport getClaimVoucherPage(String createSn,String dealSn,
			String status,String startDate,String endDate,int pageNo,int pageSize);

	public Map getStatus();
	
	public ClaimVoucher getCliamVoucherById(Long id);
	
	public boolean saveClaimVoucher(ClaimVoucher claimVoucher);
	
	public boolean deleteClaimVoucher(Long id);
	
	public boolean updateClaimVoucher(ClaimVoucher claimVoucher);
}
