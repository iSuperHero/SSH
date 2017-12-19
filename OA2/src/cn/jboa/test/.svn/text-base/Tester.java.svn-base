package cn.jboa.test;

import java.util.Date;

import oracle.net.aso.d;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jboa.entity.ClaimVoucher;
import cn.jboa.entity.ClaimVoucherDetail;
import cn.jboa.entity.Employee;
import cn.jboa.service.ClaimVoucherService;
import cn.jboa.service.EmployeeService;

public class Tester {

	@Test
	public void testLogin(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService emp = (EmployeeService) act.getBean("employeeService");
		Employee e = emp.login("001", "123");
		System.out.println(e.getName());
	}
	
	@Test
	public void testAdd(){
		ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		ClaimVoucherService cla = (ClaimVoucherService) act.getBean("claimVoucherService");
		
		Employee emp = new Employee();
		emp.setName("张三");
		
		ClaimVoucher claimVoucher = new ClaimVoucher();
		claimVoucher.setStatus("新创建");
		claimVoucher.setCreateTime(new Date());
		claimVoucher.setTotalAccount(1024d);
		claimVoucher.setCreator(emp);
		
		ClaimVoucherDetail detail = new ClaimVoucherDetail();
		detail.setItem("餐费~");
		detail.setAccount(1024d);
		detail.setDesc("I need more money");
		
		detail.setBizClaimVoucher(claimVoucher);
		claimVoucher.getCheckResultList().add(detail);
		
		boolean b = cla.saveClaimVoucher(claimVoucher);
		if(b){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}
	}
	
}
