package cn.jboa.dao;

import java.util.List;

import cn.jboa.entity.Leave;
import cn.jboa.util.PageSupport;

public interface LeaveDao {

	//动态分页查询
	public PageSupport getLeavePage(String createSn,String dealSn,
			String status,String startDate,String endDate,int pageNo,int pageSize);

	//按照主键查询明细
	public Leave getLeaveById(Long sn);
	
	//申请请假
	public Long save(Leave leave);
	
	//审批请假
	public void saveOrUpdate(Leave leave);
	
}
