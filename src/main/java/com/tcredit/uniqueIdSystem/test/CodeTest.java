package com.tcredit.uniqueIdSystem.test;
import com.tcredit.uniqueIdSystem.common.utils.UuidUtil;
import com.tcredit.uniqueIdSystem.pojo.UuidTabId;
import com.tcredit.uniqueIdSystem.pojo.UuidTabObj;
import com.tcredit.uniqueIdSystem.service.UuidTabService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Component
public class CodeTest {
    @Autowired
    private UuidTabService uuidTabService;
    public void execute() {
        new Worker().start();
    }

    private class Worker extends Thread {
        @Override
        public void run() {
            int i=0;
            while (i<100){
                UuidTabObj obj =new UuidTabObj();
                obj.setName("张侃");
                obj.setCardNo("130406199302121511");
                obj.setCardType("ID01");
                obj.setCreateTime(new Date());
                UuidTabId id=new UuidTabId();
                id.setCardNo("130406199302121511");
                id.setName("张侃");
                obj.setUniqueId(UuidUtil.getUUID());
                UuidTabObj oo=uuidTabService.getById(id);
                if(oo==null){
                    uuidTabService.insert(obj);
                }
                i++;

            }
        }
    }
}
