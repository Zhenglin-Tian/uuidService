package com.tcredit.uniqueIdSystem.dao.mapper;

import com.tcredit.uniqueIdSystem.pojo.UuidTabId;
import com.tcredit.uniqueIdSystem.pojo.UuidTabObj;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UuidTabMapper {


    int insert(UuidTabObj UuidTabobj);

    int update(UuidTabObj UuidTabobj);

    UuidTabObj getById(UuidTabId id);

    List<UuidTabObj> queryForList(UuidTabObj query);

}
