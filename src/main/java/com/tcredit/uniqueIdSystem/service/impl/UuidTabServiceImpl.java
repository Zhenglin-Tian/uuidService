package com.tcredit.uniqueIdSystem.service.impl;

import com.tcredit.uniqueIdSystem.dao.mapper.UuidTabMapper;
import com.tcredit.uniqueIdSystem.pojo.UuidTabId;
import com.tcredit.uniqueIdSystem.pojo.UuidTabObj;
import com.tcredit.uniqueIdSystem.service.UuidTabService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class UuidTabServiceImpl implements UuidTabService {

	@Resource
	private UuidTabMapper uuidTabMapper;

	public int insert(UuidTabObj uuidTabobj) {
		return this.uuidTabMapper.insert(uuidTabobj);
	}

	public int update(UuidTabObj uuidTabobj) {
		return this.uuidTabMapper.update(uuidTabobj);
	}

	public UuidTabObj getById(UuidTabId id) {
		return this.uuidTabMapper.getById(id);
	}

	public List<UuidTabObj> queryForList(UuidTabObj query) {
		return this.uuidTabMapper.queryForList(query);
	}

}
