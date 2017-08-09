package com.atsistemas.njar.bean;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

public abstract class AbstractBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
