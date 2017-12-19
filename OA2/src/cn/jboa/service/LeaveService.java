package cn.jboa.service;

import java.util.Map;

import cn.jboa.entity.Leave;
import cn.jboa.util.PageSupport;

public interface LeaveService {

	public PageSupport getLeavePage(String createSn,String dealSn,
			String status,String startDate,String endDate,int pageNo,int pageSize);

	//查询下拉状态列表
	public Map getStatusMap();
	
	public Leave getLeaveById(Long id);
	
	public boolean saveLeave(Leave leave);
	
	public Map getLeaveTypeMap();
	
	public void checkLeave(Leave leave);
}
