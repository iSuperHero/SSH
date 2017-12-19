package cn.jboa.dao.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jboa.common.Constants;
import cn.jboa.dao.ClaimVoucherDao;
import cn.jboa.entity.ClaimVoucher;
import cn.jboa.util.PageSupport;

public class ClaimVoucherDaoImpl extends HibernateDaoSupport implements ClaimVoucherDao {

	@Override
	public PageSupport getClaimVoucherPage(String createSn, String dealSn,
			String status, String startDate, String endDate, int pageNo,
			int pageSize) {
		//用于查询列表
		Criteria criteria = this.getSession().createCriteria(ClaimVoucher.class);
		//用于查询总记录数
		Criteria crt = this.getSession().createCriteria(ClaimVoucher.class);
		//初始化总记录数
		Long totalCount = null;
		//如果是员工登录，那么仅有查看自己提交的报销单权限
		if (createSn != null && !createSn.equals("")){
			criteria.add(Restrictions.eq("creator.sn", createSn));
			crt.add(Restrictions.eq("creator.sn", createSn));
		}
		//如果是部门经理等上级，那么查询出自己要审批的报销单
		if (dealSn != null && !dealSn.equals("")){
			criteria.add(Restrictions.eq("nextDeal.sn", dealSn));
			crt.add(Restrictions.eq("nextDeal.sn", dealSn));
		}
		//按照状态查询
		if (status != null && !status.equals("")){
			criteria.add(Restrictions.eq("status", status));
			crt.add(Restrictions.eq("status", status));
		}
		//按照指定日期范围查询
		Date dStartDate = null;
		Date dEndDate = null;
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				if(startDate != null && !startDate.equals("")){
					dStartDate = sf.parse(startDate);
					criteria.add(Restrictions.ge("createTime", dStartDate));
					crt.add(Restrictions.ge("createTime", dStartDate));
				}
				if(endDate != null && !endDate.equals("")){
					dEndDate = sf.parse(endDate);
					criteria.add(Restrictions.le("createTime", dEndDate));
					crt.add(Restrictions.le("createTime", dEndDate));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			//总记录数
			totalCount = (Long)crt.setProjection(Projections.rowCount()).uniqueResult();
			//设置起始页，页面大小
			criteria.setFirstResult((pageNo-1)*pageSize);
			criteria.setMaxResults(pageSize);
			List<ClaimVoucher> list = criteria.list();
			//设置PageSupport
			PageSupport page = new PageSupport();
			page.setCurrPageNo(pageNo);
			page.setTotalCount(Integer.parseInt(totalCount.toString()));
			page.setTotalPageCount(page.getTotalPageCount());
			System.out.println("总页数为---------------"+page.getTotalPageCount());
			page.setPageSize(pageSize);
			page.setItem(list);
			
			return page;
	}

	@Override
	public Map getStatus() {
		Map statusMap = new LinkedHashMap();
		statusMap.put(Constants.CLAIMVOUCHER_CREATED, Constants.CLAIMVOUCHER_CREATED);
		statusMap.put(Constants.CLAIMVOUCHER_SUBMITTED, Constants.CLAIMVOUCHER_SUBMITTED);
		statusMap.put(Constants.CLAIMVOUCHER_BACK, Constants.CLAIMVOUCHER_BACK);
		statusMap.put(Constants.CLAIMVOUCHER_APPROVING, Constants.CLAIMVOUCHER_APPROVING);
		statusMap.put(Constants.CLAIMVOUCHER_APPROVED, Constants.CLAIMVOUCHER_APPROVED);
		statusMap.put(Constants.CLAIMVOUCHER_PAID, Constants.CLAIMVOUCHER_PAID);
		statusMap.put(Constants.CLAIMVOUCHER_TERMINATED, Constants.CLAIMVOUCHER_TERMINATED);
		return statusMap;
	}

	@Override
	public ClaimVoucher getClaimVoucherById(Long id) {
		return this.getHibernateTemplate().get(ClaimVoucher.class, id);
	}

	@Override
	public Long save(ClaimVoucher claimVoucher) {
		return (Long) this.getHibernateTemplate().save(claimVoucher);
	}

	@Override
	public void delete(ClaimVoucher claimVoucher) {
		this.getHibernateTemplate().delete(claimVoucher);
	}

	@Override
	public void update(ClaimVoucher claimVoucher) {
		this.getHibernateTemplate().update(claimVoucher);
	}
	
	public ClaimVoucher get(Long id) {
		return this.getHibernateTemplate().get(ClaimVoucher.class, id);
	}
}
