package cn.jboa.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jboa.dao.LeaveDao;
import cn.jboa.entity.Leave;
import cn.jboa.util.PageSupport;

public class LeaveDaoImpl extends HibernateDaoSupport implements LeaveDao {

	@Override
	public PageSupport getLeavePage(String createSn, String dealSn,
			String status, String startDate, String endDate, int pageNo,
			int pageSize) {
		Criteria ct = this.getSession().createCriteria(Leave.class);
		Criteria crt = this.getSession().createCriteria(Leave.class);
		Long totalCount = null;
		// 根据角色查询
		// 员工查询自己的请假单
		if (createSn != null && !createSn.equals("")) {
			ct.add(Restrictions.eq("creator.sn", createSn));
			crt.add(Restrictions.eq("creator.sn", createSn));
		}

		// 领导查询自己处理的
		if (dealSn != null && !dealSn.equals("")) {
			ct.add(Restrictions.eq("nextDeal.sn", dealSn));
			crt.add(Restrictions.eq("nextDeal.sn", dealSn));
		}

		if (status != null && !status.equals("")) {
			crt.add(Restrictions.eq("status", status));
			ct.add(Restrictions.eq("status", status));
		}
		Date dStartDate = null;
		Date dEndDate = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (startDate != null && !startDate.equals("")) {
				dStartDate = sf.parse(startDate);
				ct.add(Restrictions.ge("startTime", dStartDate));
				crt.add(Restrictions.ge("startTime", dStartDate));
			}
			if (endDate != null && !endDate.equals("")) {
				dEndDate = sf.parse(endDate);
				ct.add(Restrictions.le("endTime", dEndDate));
				crt.add(Restrictions.le("endTime", dEndDate));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		totalCount = (Long) crt.setProjection(Projections.rowCount())
				.uniqueResult();

		ct.setFirstResult((pageNo - 1) * pageSize);
		ct.setMaxResults(pageSize);
		List<Leave> list = ct.list();
		PageSupport page = new PageSupport();
		page.setCurrPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setTotalCount(Integer.parseInt(totalCount.toString()));
		page.setTotalPageCount(page.getTotalPageCount());

		page.setItem(list);

		return page;
	}

	@Override
	public Leave getLeaveById(Long sn) {
		return this.getHibernateTemplate().get(Leave.class, sn);
	}

	@Override
	public Long save(Leave leave) {
		return (Long) this.getHibernateTemplate().save(leave);
	}

	@Override
	public void saveOrUpdate(Leave leave) {
		this.getHibernateTemplate().saveOrUpdate(leave);
	}

}
