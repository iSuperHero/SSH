package cn.jboa.dao;

import java.util.List;

import cn.jboa.entity.ClaimVoucherStatistics;
import cn.jboa.util.PageSupport;

/**
 * 月度报销单统计
 * @author 13782
 *
 */
public interface ClaimVoucherStatisticsDao {

	//分页查询
	public PageSupport getCLaimVoucherStatisticsPage(int year, int startMonth, int endMonth, int departmentId,int pageNo,int pageSize);

	//详细查询
	public ClaimVoucherStatistics getClaimVoucherStatisticsByDeptId(Long id);
}
