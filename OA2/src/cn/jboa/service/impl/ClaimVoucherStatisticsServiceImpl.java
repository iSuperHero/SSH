package cn.jboa.service.impl;

import cn.jboa.dao.ClaimVoucherStatisticsDao;
import cn.jboa.entity.ClaimVoucherStatistics;
import cn.jboa.service.ClaimVoucherStatisticsService;
import cn.jboa.util.PageSupport;

public class ClaimVoucherStatisticsServiceImpl implements ClaimVoucherStatisticsService{

	private ClaimVoucherStatisticsDao claimVoucherStatisticsDao;
	
	public void setClaimVoucherStatisticsDao(
			ClaimVoucherStatisticsDao claimVoucherStatisticsDao) {
		this.claimVoucherStatisticsDao = claimVoucherStatisticsDao;
	}


	@Override
	public PageSupport getCLaimVoucherStatisticsPage(int year, int startMonth,
			int endMonth, int departmentId, int pageNo, int pageSize) {
		return claimVoucherStatisticsDao.getCLaimVoucherStatisticsPage(year, startMonth, endMonth, departmentId, pageNo, pageSize);
	}


	@Override
	public ClaimVoucherStatistics getByDeptId(Long id) {
		return claimVoucherStatisticsDao.getClaimVoucherStatisticsByDeptId(id);
	}

}
