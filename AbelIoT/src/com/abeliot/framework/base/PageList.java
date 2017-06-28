package com.abeliot.framework.base;

import java.io.Serializable;
import java.util.List;

public class PageList<T> implements Serializable{

	private static final long serialVersionUID = 1843847154219527266L;

	public List<T> records = null; // 当前页的记录列表
	public int recordSum = 0; // 总记录数目
	public int totalPage = 0; // 总页数
	public int index = 0; // 第几页
	public int pageSize = 0; // 分页大小
	
	public PageList(int recordSum, int pageSize, int pageIndex, List<T> records) {
		this.records = records;
		this.recordSum = recordSum;
		if(pageSize > recordSum){
			pageSize = recordSum;
		}
		this.pageSize = pageSize;
		this.totalPage = (recordSum + pageSize - 1) / pageSize;
		this.index = pageIndex;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getRecordSum() {
		return recordSum;
	}

	public void setRecordSum(int recordSum) {
		this.recordSum = recordSum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPrevIndex() {
		int idx = index - 1;
		if (idx < 1) {
			idx = 1;
		}
		return idx;
	}

	public int getNextIndex() {
		int idx = index + 1;
		if (idx > totalPage) {
			idx = totalPage;
		}
		return idx;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("recorde sum : " + recordSum + ", page size : " + pageSize + "\n");
		sb.append("total page : " + totalPage + ", curpage " + index + "\n");
		
		for(Object obj : records){
			sb.append(obj);
		}
		
		return sb.toString();
	}
}
