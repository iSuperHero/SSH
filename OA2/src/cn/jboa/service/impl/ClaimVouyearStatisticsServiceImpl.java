package cn.jboa.service.impl;

import cn.jboa.dao.ClaimVouyearStatisticsDao;
import cn.jboa.service.ClaimVouyearStatisticsService;
import cn.jboa.util.PageSupport;

public class ClaimVouyearStatisticsServiceImpl implements
		ClaimVouyearStatisticsService {

	private ClaimVouyearStatisticsDao claimVouyearStatisticsDao;
	
	public void setClaimVouyearStatisticsDao(
			ClaimVouyearStatisticsDao claimVouyearStatisticsDao) {
		this.claimVouyearStatisticsDao = claimVouyearStatisticsDao;
	}

	@Override
	public PageSupport getClaimVouyearStatisticsPage(int deptId, int startYear,
			int endYear, int pageNo, int pageSize) {
		return claimVouyearStatisticsDao.getClaimVouyearStatisticsPage(deptId, startYear, endYear, pageNo, pageSize);
	}

}
