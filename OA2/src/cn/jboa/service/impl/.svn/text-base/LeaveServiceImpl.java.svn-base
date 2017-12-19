package cn.jboa.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.jboa.common.Constants;
import cn.jboa.dao.LeaveDao;
import cn.jboa.entity.Leave;
import cn.jboa.service.LeaveService;
import cn.jboa.util.PageSupport;

public class LeaveServiceImpl implements LeaveService {

	private LeaveDao leaveDao;
	
	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

	@Override
	public PageSupport getLeavePage(String createSn, String dealSn,
			String status, String startDate, String endDate, int pageNo,
			int pageSize) {
		return leaveDao.getLeavePage(createSn, dealSn, status, startDate, endDate, pageNo, pageSize);
	}

	@Override
	public Map getStatusMap() {
		Map statusMap = new LinkedHashMap();
		statusMap.put(Constants.LEAVESTATUS_APPROVED, Constants.LEAVESTATUS_APPROVED);
		statusMap.put(Constants.LEAVESTATUS_APPROVING, Constants.LEAVESTATUS_APPROVING);
		statusMap.put(Constants.LEAVESTATUS_BACK, Constants.LEAVESTATUS_BACK);
		return statusMap;
	}

	@Override
	public Leave getLeaveById(Long sn) {
		return leaveDao.getLeaveById(sn);
	}

	@Override
	public boolean saveLeave(Leave leave) {
		boolean flag = false;
		Long result = leaveDao.save(leave);
		if(result!=null){
			flag = true;
		}
		return flag;
	}

	@Override
	public Map getLeaveTypeMap() {
		Map map = new LinkedHashMap();
		map.put(Constants.LEAVE_ANNUAL, Constants.LEAVE_ANNUAL);
		map.put(Constants.LEAVE_CASUAL, Constants.LEAVE_CASUAL);
		map.put(Constants.LEAVE_MARRIAGE, Constants.LEAVE_MARRIAGE);
		map.put(Constants.LEAVE_MATERNITY, Constants.LEAVE_MATERNITY);
		map.put(Constants.LEAVE_SICK, Constants.LEAVE_SICK);
		return map;
	}

	@Override
	public void checkLeave(Leave leave) {
		leaveDao.saveOrUpdate(leave);
	}

}
