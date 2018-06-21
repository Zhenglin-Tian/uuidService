package com.tcredit.uniqueIdSystem.web.controller;

import com.tcredit.common.utils.UUIDUtil;
import com.tcredit.uniqueIdSystem.common.ErrorCode;
import com.tcredit.uniqueIdSystem.common.utils.UuidUtil;
import com.tcredit.uniqueIdSystem.pojo.UuidTabId;
import com.tcredit.uniqueIdSystem.pojo.UuidTabObj;
import com.tcredit.uniqueIdSystem.pojo.model.ResponseModel;
import com.tcredit.uniqueIdSystem.service.UuidTabService;
import com.tcredit.uniqueIdSystem.service.helper.VerifyIDCardNumber;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/personInfo")
public class PersonInfoController {
    private static final String CARD_TYPE_SFZ = "ID01";
    private static Logger logger = LoggerFactory.getLogger(PersonInfoController.class);
    @Resource
    private UuidTabService uuidTabService;
    private Gson gson = new Gson();

    @RequestMapping(value = "/dataSync",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String dataSyncuId(HttpServletRequest request,String name, String cardNo, String cardType) {

        Map<String, String[]> map = request.getParameterMap();


        logger.info("用户数据同步入参：name:" + name + ",cardNo:" + cardNo + ",cardType:" + cardType);
        ResponseModel model = new ResponseModel();
        if (StringUtils.isBlank(cardType) || CARD_TYPE_SFZ.equals(cardType)) {
            cardType = CARD_TYPE_SFZ;
            if (StringUtils.isBlank(cardNo) || StringUtils.isBlank(name)) {
                model.setCodeMessage(ErrorCode.PARAMETER_ERROR);
                return gson.toJson(model);
            }else{
                //默认是身份证
                cardNo = VerifyIDCardNumber.validIdCard(cardNo);
                if (StringUtils.isBlank(cardNo)){

                    model.setCodeMessage(ErrorCode.CARDNO__ERROR);
                    return gson.toJson(model);
                }
            }

        }

        cardNo = cardNo.toUpperCase();
        getUniqueId(name, cardNo, cardType, model);
        return gson.toJson(model);
    }

    private void getUniqueId(String name, String cardNo, String cardType, ResponseModel model) {
        UuidTabId id = new UuidTabId();
        id.setCardNo(cardNo);
        id.setName(name);
        UuidTabObj obj = this.uuidTabService.getById(id);
//		UuidTabObj obj=null;
        //如果没有查到就生成一个


        if (obj == null) {
            obj = new UuidTabObj();
            obj.setName(name);
            obj.setCardNo(cardNo);
            obj.setCardType(cardType);
            obj.setCreateTime(new Date());
            obj.setUniqueId(UUIDUtil.uuid(cardNo, name));
            try {
                //todo
                /**
                 * by zl.T提出
                 *
                 * 存在并发情况，name cardNo 字段已建立联合主键，同一个用户并发请求时会报错
                 */
                this.uuidTabService.insert(obj);
            } catch (Exception e) {
                logger.error("error:{}", e);
                obj = this.uuidTabService.getById(id);
            }
        }
        if (obj != null) {
            model.setCodeMessage(ErrorCode.SUCCESS);
            model.setUniqueId(obj.getUniqueId());
        } else {
            model.setCodeMessage(ErrorCode.ERROR);
        }

    }
}
