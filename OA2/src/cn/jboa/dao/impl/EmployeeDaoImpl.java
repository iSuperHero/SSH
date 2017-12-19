package cn.jboa.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.jboa.common.Constants;
import cn.jboa.dao.EmployeeDao;
import cn.jboa.entity.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	private static Employee empGM = null;
	private static Employee empCashier = null;
	
	@Override
	public Employee getLoginEmp(String sn) {
		return this.getHibernateTemplate().get(Employee.class, sn);
	}

	@Override
	public List<Employee> getManagerByDeptId(int id) {
		String hql = "from Employee where sysPosition.id = ? and sysDepartment.id = 1";
		return this.getHibernateTemplate().find(hql, id);
	}
	
	@Override
	public Employee getManager(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee e where e.sysDepartment.id=? and e.sysPosition.nameCn=?from Employee e where e.sysDepartment.id=? and e.sysPosition.nameCn=?";
		Employee empManager = (Employee)this.getHibernateTemplate().find(hql, employee.getSysDepartment().getId(),Constants.POSITION_FM).get(0);
		return empManager;
	}

	@Override
	public Employee getGeneralManager() {
		// TODO Auto-generated method stub
		if (empGM == null){
			String hql = "from Employee e where e.sysPosition.nameCn=?";
			empGM = (Employee) this.getHibernateTemplate().find(hql,Constants.POSITION_GM).get(0);
		}
		return empGM;
	}

	@Override
	public Employee getCashier() {
		// TODO Auto-generated method stub
		if (empCashier == null) {
			String hql = "from Employee e where e.sysPosition.nameCn=? and e.status='"
					+ Constants.EMPLOYEE_STAY + "'";
			empCashier = (Employee) this.getHibernateTemplate().find(hql,Constants.POSITION_CASHIER).get(0);
		}
		return empCashier;
	}

}
