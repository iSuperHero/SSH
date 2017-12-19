package cn.jboa.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jboa.dao.CheckResultDao;
import cn.jboa.entity.CheckResult;
import cn.jboa.entity.ClaimVoucher;

public class CheckResultDaoImpl extends HibernateDaoSupport implements
		CheckResultDao {

	@Override
	public void save(CheckResult checkResult) {
		this.getHibernateTemplate().saveOrUpdate(checkResult);
	}

}
