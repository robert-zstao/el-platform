package com.zst.el.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author robert
 * @date 2021/4/15 18:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginLogInfo {

    private int id;

    private String userId;

    private char type; //0登录、 1. 登出

    private String desc;

    private String insetDate;

    private String reqParams;

    private String results;

    private String reqIp;

    private String ipAddress;

    private String version;
}
