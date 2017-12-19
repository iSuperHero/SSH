package cn.jboa.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jboa.dao.ClaimVoucherDetailDao;
import cn.jboa.entity.ClaimVoucherDetail;

public class ClaimVoucherDetailDaoImpl extends HibernateDaoSupport implements
		ClaimVoucherDetailDao {

	@Override
	public Long save(ClaimVoucherDetail claimVoucherDetail) {
		return (Long) this.getHibernateTemplate().save(claimVoucherDetail);
	}

	@Override
	public void saveOrUpdate(ClaimVoucherDetail claimVoucherDetail) {
		this.getHibernateTemplate().saveOrUpdate(claimVoucherDetail);
	}

}
