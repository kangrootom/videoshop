package cn.itcast.util;

import java.util.ArrayList;
import java.util.List;

public class PageResult {
	
	private Integer pageNo;
	private Integer pageSize;
	private Integer totalPage;
	private Integer totalCount;
	private List pageList;
	public static Integer PAGE_PAGESIZE=3;
	public PageResult() {
	}
	public PageResult(Integer pageNo, Integer pageSize, Integer totalCount, List pageList) {
		this.pageList = pageList==null?new ArrayList<>():pageList;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		if(totalCount!=0){
			int tem = totalCount/pageSize;
			totalPage = totalCount%pageSize==0?tem:tem+1;
			this.pageNo = pageNo;
		}else{
			this.pageNo = 0;
		}
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List getPageList() {
		return pageList;
	}
	public void setPageList(List pageList) {
		this.pageList = pageList;
	}

	
}
