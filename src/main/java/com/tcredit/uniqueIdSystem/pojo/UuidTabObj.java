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
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.Date;

public class UuidTabObj implements java.io.Serializable {
	private static final long serialVersionUID = 5454155825314635342L;

	//columns START
	   private String uniqueId;
	   private String name;
	   private String cardNo;
	   private String cardType;
	   private java.util.Date createTime=new Date();
	   private java.util.Date updateTime=new Date();
	//columns END




	public void setUniqueId(String value) {
		this.uniqueId = value;
	}

	public String getUniqueId() {
		return this.uniqueId;
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

	public void setCardType(String value) {
		this.cardType = value;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCreateTime(java.util.Date value) {
		this.createTime = value;
	}

	public java.util.Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(java.util.Date value) {
		this.updateTime = value;
	}

	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}



	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
			.append("UniqueId",getUniqueId())
			.append("Name",getName())
			.append("CardNo",getCardNo())
			.append("CardType",getCardType())
			.append("CreateTime",getCreateTime())
			.append("UpdateTime",getUpdateTime())
			.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getName())
			.append(getCardNo())
			.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof UuidTabObj == false) return false;
		if(this == obj) return true;
		UuidTabObj other = (UuidTabObj)obj;
		return new EqualsBuilder()
			.append(getName(),other.getName())
			.append(getCardNo(),other.getCardNo())
			.isEquals();
	}


}