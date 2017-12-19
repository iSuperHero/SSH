package cn.jboa.service;

import cn.jboa.util.PageSupport;

public interface ClaimVouyearStatisticsService {

	public PageSupport getClaimVouyearStatisticsPage(int deptId,int startYear,int endYear,int pageNo,int pageSize);
}
