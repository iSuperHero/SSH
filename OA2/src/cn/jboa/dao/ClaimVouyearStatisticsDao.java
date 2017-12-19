package cn.jboa.dao;

import cn.jboa.util.PageSupport;

public interface ClaimVouyearStatisticsDao {

	public PageSupport getClaimVouyearStatisticsPage(int deptId,int startYear,int endYear,int pageNo,int pageSize);

}
