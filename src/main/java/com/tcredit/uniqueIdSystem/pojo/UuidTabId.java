

/*
 * Copyright (c) 2008 - 2016, tcredit Co.,Ltd
 * @author renkuo.zhao
 * @version 1.0
 * created on 2016-10-21 21:48:09
 */

package com.tcredit.uniqueIdSystem.pojo;


import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class UuidTabId implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	private String name;
	private String cardNo;

	public UuidTabId(){
	}

	public UuidTabId(String name, String cardNo){
		this.name = name;
		this.cardNo = cardNo;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCardNo(String value) {
		this.cardNo = value;
	}
	
	public String getCardNo() {
		return this.cardNo;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	public boolean equals(Object other) {
		return EqualsBuilder.reflectionEquals(this, other);
	}
}