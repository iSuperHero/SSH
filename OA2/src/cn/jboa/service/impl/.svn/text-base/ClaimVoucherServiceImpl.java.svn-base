package cn.jboa.service.impl;

import java.util.Date;
import java.util.Map;

import cn.jboa.dao.ClaimVoucherDao;
import cn.jboa.dao.ClaimVoucherDetailDao;
import cn.jboa.entity.ClaimVoucher;
import cn.jboa.entity.ClaimVoucherDetail;
import cn.jboa.service.ClaimVoucherService;
import cn.jboa.util.PageSupport;

public class ClaimVoucherServiceImpl implements ClaimVoucherService {

	private ClaimVoucherDao claimVoucherDao;
	
	private ClaimVoucherDetailDao claimVoucherDetailDao;
	
	public void setClaimVoucherDetailDao(ClaimVoucherDetailDao claimVoucherDetailDao) {
		this.claimVoucherDetailDao = claimVoucherDetailDao;
	}

	public void setClaimVoucherDao(ClaimVoucherDao claimVoucherDao) {
		this.claimVoucherDao = claimVoucherDao;
	}

	@Override
	public PageSupport getClaimVoucherPage(String createSn, String dealSn,
			String status, String startDate, String endDate, int pageNo,
			int pageSize) {
		return claimVoucherDao.getClaimVoucherPage(createSn, dealSn, status, startDate, endDate, pageNo, pageSize);
	}

	@Override
	public Map getStatus() {
		return claimVoucherDao.getStatus();
	}

	@Override
	public ClaimVoucher getCliamVoucherById(Long id) {
		return claimVoucherDao.getClaimVoucherById(id);
	}

	@Override
	public boolean saveClaimVoucher(ClaimVoucher claimVoucher) {
		boolean flag = false;
		//新增创建日期
		try{
			claimVoucher.setCreateTime(new Date());
			claimVoucherDao.save(claimVoucher);
			for(ClaimVoucherDetail detail:claimVoucher.getDetailList()){
				//添加关联关系
				detail.setBizClaimVoucher(claimVoucher);
				claimVoucherDetailDao.save(detail);
			}
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteClaimVoucher(Long id) {
		boolean flag = false;
		ClaimVoucher temp = claimVoucherDao.getClaimVoucherById(id);
		claimVoucherDao.delete(temp);
		flag = true;
		return flag;
	}

	@Override
	public boolean updateClaimVoucher(ClaimVoucher claimVoucher) {
		boolean flag = false;
		claimVoucher.setModifyTime(new Date());
		claimVoucherDao.update(claimVoucher);
		if(claimVoucher.getDetailList()!=null){
			for(ClaimVoucherDetail detail:claimVoucher.getDetailList()){
				detail.setBizClaimVoucher(claimVoucher);
				System.out.println("id"+detail.getId());
				claimVoucherDetailDao.saveOrUpdate(detail);
			}
		}
		flag = true;
		return flag;
	}

}
