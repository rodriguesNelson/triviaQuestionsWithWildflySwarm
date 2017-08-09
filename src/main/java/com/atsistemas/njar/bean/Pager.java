package com.atsistemas.njar.bean;

import com.atsistemas.njar.enums.PageSorting;

public class Pager extends AbstractBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long start;
	private Long end;
	private String orderBy;
	private PageSorting sort;

	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public Long getEnd() {
		return end;
	}

	public void setEnd(Long end) {
		this.end = end;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public PageSorting getSort() {
		return sort;
	}

	public void setSort(PageSorting sort) {
		this.sort = sort;
	}	
}
