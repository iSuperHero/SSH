package cn.jboa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jboa.dao.ClaimVoucherStatisticsDao;
import cn.jboa.entity.ClaimVoucherStatistics;
import cn.jboa.util.PageSupport;

public class ClaimVoucherStatisticsDaoImpl extends HibernateDaoSupport
		implements ClaimVoucherStatisticsDao {

	@Override
	public PageSupport getCLaimVoucherStatisticsPage(int year, int startMonth,
			int endMonth, int departmentId, int pageNo, int pageSize) {
		Criteria criteria = this.getSession().createCriteria(ClaimVoucherStatistics.class);
		Criteria crt = this.getSession().createCriteria(ClaimVoucherStatistics.class);
		if(departmentId>0){
			criteria.add(Restrictions.eq("department.id", departmentId));
			crt.add(Restrictions.eq("department.id", departmentId));
		}
		if(year!=0){
			criteria.add(Restrictions.eq("year", year));
			crt.add(Restrictions.eq("year", year));
		}
		if(startMonth!=0){
			criteria.add(Restrictions.ge("month", startMonth));
			crt.add(Restrictions.ge("month", startMonth));
		}
		if(endMonth!=0){
			criteria.add(Restrictions.le("month", endMonth));
			crt.add(Restrictions.le("month", endMonth));
		}
		//criteria.addOrder(Order.desc("year"));
		//criteria.addOrder(Order.desc("month"));
		criteria.setFirstResult((pageNo-1)*pageSize);
		criteria.setMaxResults(pageSize);
		List<ClaimVoucherStatistics> list =criteria.list();
		
		Long totalCount = (Long) crt.setProjection(Projections.rowCount()).uniqueResult();
				
		PageSupport page = new PageSupport();
		page.setCurrPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setTotalCount(Integer.parseInt(totalCount.toString()));
		page.setTotalPageCount(page.getTotalPageCount());
		page.setItem(list);
		
		return page;
	}

	@Override
	public ClaimVoucherStatistics getClaimVoucherStatisticsByDeptId(Long id) {
		return this.getHibernateTemplate().get(ClaimVoucherStatistics.class, id);
	}

}
