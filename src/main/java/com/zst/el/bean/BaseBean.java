package com.zst.el.bean;

import lombok.*;

/**
 * @author robert
 * @date 2021/5/10 11:20
 */
@Data
public abstract class BaseBean {

    protected long sgId;  //SG_ID

    protected String sgCreateTime; //SG_CREATE_TIME

    protected String sgUpdateTime; //SG_UPDATE_TIME

    protected char sgDelFlag;// SG_DEL_FLAG 是否逻辑删除

    private String sgRemark; //SG_REMARK

    private char sgState; //SG_STATE


}
