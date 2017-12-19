package cn.jboa.dao;

import java.util.List;
import java.util.Map;

import cn.jboa.entity.ClaimVoucher;
import cn.jboa.util.PageSupport;

public interface ClaimVoucherDao {

	//动态查询
	public PageSupport getClaimVoucherPage(String createSn,String dealSn,
			String status,String startDate,String endDate,int pageNo,int pageSize);
	
	//获取状态下拉列表
	public Map getStatus();
	
	//按照ID查询详细信息
	public ClaimVoucher getClaimVoucherById(Long id);
	
	//新增报销单
	public Long save(ClaimVoucher claimVoucher);
	
	//删除报销单
	public void delete(ClaimVoucher claimVoucher);
	
	//修改报销单
	public void update(ClaimVoucher claimVoucher);
	
}
