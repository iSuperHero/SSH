package cn.jboa.util;

import java.util.ArrayList;
import java.util.List;

public class PageSupport {

	//页面大小
	private int pageSize = 5;
	//当前页码
	private int currPageNo = 1;
	//总页数
	private int totalPageCount = 0;
	//总数量
	private int totalCount = 0;
	//结果集
	private List item = new ArrayList();
	
	public PageSupport() {
	
	}

	public PageSupport(int pageSize, int currentPageNo) {
		setPageSize(pageSize);
    	setCurrPageNo(currentPageNo);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		this.currPageNo = currPageNo;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(totalCount>=0){
			int count = totalCount / pageSize;
			if(totalCount % pageSize>0){
				count++;
			}
			this.totalPageCount = count;
		}
	}

	public List getItem() {
		return item;
	}

	public void setItem(List item) {
		this.item = item;
	}

	//开始记录数
	public int getStartRow() {
		return (currPageNo - 1) * pageSize;
	}
	
	//结束记录数
	public int getEndRow() {
		return currPageNo * pageSize;
	}
}