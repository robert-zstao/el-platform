package com.zst.el.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author robert
 * @date 2021/4/14 18:29
 * 操作日志类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OperationLog {

    private int id;

    private String model;

    private String type;

    private String desc;

    private int userId;

    private String insetDate;

    private String method;

    private String reqParams;

    private String results;

    private String url;

    private String reqIp;

    private String ipAddress;

    private String version;

}
