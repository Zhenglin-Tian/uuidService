/*
 * Copyright (c) 2008 - 2016, tcredit Co.,Ltd
 * @author renkuo.zhao
 * @version 1.0
 * created on 2016-10-21 21:48:09
 */

package com.tcredit.uniqueIdSystem.service;

import com.tcredit.uniqueIdSystem.pojo.UuidTabId;
import com.tcredit.uniqueIdSystem.pojo.UuidTabObj;

import java.util.List;

public interface UuidTabService {

	public int insert(UuidTabObj UuidTabobj);
	public int update(UuidTabObj UuidTabobj);

	public UuidTabObj getById(UuidTabId id);
	public List<UuidTabObj> queryForList(UuidTabObj query);
}
