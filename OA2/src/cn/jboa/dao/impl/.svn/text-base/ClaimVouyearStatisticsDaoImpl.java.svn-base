package cn.jboa.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jboa.dao.ClaimVouyearStatisticsDao;
import cn.jboa.entity.ClaimVouyearStatistics;
import cn.jboa.util.PageSupport;

public class ClaimVouyearStatisticsDaoImpl extends HibernateDaoSupport implements ClaimVouyearStatisticsDao {

	@Override
	public PageSupport getClaimVouyearStatisticsPage(int deptId, int startYear,
			int endYear, int pageNo, int pageSize) {
		Criteria criteria = this.getSession().createCriteria(ClaimVouyearStatistics.class);
		Criteria crt = this.getSession().createCriteria(ClaimVouyearStatistics.class);
		if(deptId>0){
			criteria.add(Restrictions.eq("dept.id", deptId));
			crt.add(Restrictions.eq("dept.id", deptId));
		}
		if(startYear!=0){
			criteria.add(Restrictions.ge("year", startYear));
			crt.add(Restrictions.ge("year", startYear));
		}
		if(endYear!=0){
			criteria.add(Restrictions.le("year", endYear));
			crt.add(Restrictions.le("year", endYear));
		}
		criteria.setFirstResult((pageNo-1)*pageSize);
		criteria.setMaxResults(pageSize);
		
		List<ClaimVouyearStatistics> list = criteria.list();
		
		Long totalCount = (Long) crt.setProjection(Projections.rowCount()).uniqueResult();
		PageSupport pageSupport  = new PageSupport(pageSize,pageNo);
		//pageSupport.setCurrPageNo(pageNo);
		//pageSupport.setPageSize(pageSize);
		pageSupport.setTotalCount(Integer.parseInt(totalCount.toString()));
		pageSupport.setTotalPageCount(pageSupport.getTotalPageCount());
		pageSupport.setItem(list);
		return pageSupport;
	}

}
