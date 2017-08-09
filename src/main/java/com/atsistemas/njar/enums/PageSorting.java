package com.atsistemas.njar.enums;

public enum PageSorting {

	NONE("", 0), ASCENDING("ASC", 1), DESCENDING("DESC", -1);

	private String dbDesc;
	private Integer representativeNumber;

	private PageSorting(String dbDesc, Integer representativeNumber) {
		this.dbDesc = dbDesc;
		this.representativeNumber = representativeNumber;
	}
	
	public static PageSorting getFromDbDesc(String dbDesc) {
		if (null != dbDesc && dbDesc.trim().length() > 0) {
			for (PageSorting pageSorting : values()) {
				if (dbDesc.equalsIgnoreCase(pageSorting.dbDesc)) {
					return pageSorting;
				}
			}
		}
		return NONE;
	}
	
	public static PageSorting getFromRepresentativeNumber(Integer representativeNumber) {
		if (null != representativeNumber) {
			for (PageSorting pageSorting : values()) {
				if (representativeNumber.equals(pageSorting.representativeNumber)) {
					return pageSorting;
				}
			}
		}
		return NONE;
	}
}
