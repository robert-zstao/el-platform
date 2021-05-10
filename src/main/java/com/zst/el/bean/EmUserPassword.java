package com.zst.el.bean;

public class EmUserPassword {
    private Integer sgId;

    private Integer sgUserId;

    private String sgState;

    private String sgPassword;

    private Integer sgCreateUser;

    private String sgCreateTime;

    private String sgUpdateTime;

    private String sgRemark;

    public Integer getSgId() {
        return sgId;
    }

    public void setSgId(Integer sgId) {
        this.sgId = sgId;
    }

    public Integer getSgUserId() {
        return sgUserId;
    }

    public void setSgUserId(Integer sgUserId) {
        this.sgUserId = sgUserId;
    }

    public String getSgState() {
        return sgState;
    }

    public void setSgState(String sgState) {
        this.sgState = sgState == null ? null : sgState.trim();
    }

    public String getSgPassword() {
        return sgPassword;
    }

    public void setSgPassword(String sgPassword) {
        this.sgPassword = sgPassword == null ? null : sgPassword.trim();
    }

    public Integer getSgCreateUser() {
        return sgCreateUser;
    }

    public void setSgCreateUser(Integer sgCreateUser) {
        this.sgCreateUser = sgCreateUser;
    }

    public String getSgCreateTime() {
        return sgCreateTime;
    }

    public void setSgCreateTime(String sgCreateTime) {
        this.sgCreateTime = sgCreateTime == null ? null : sgCreateTime.trim();
    }

    public String getSgUpdateTime() {
        return sgUpdateTime;
    }

    public void setSgUpdateTime(String sgUpdateTime) {
        this.sgUpdateTime = sgUpdateTime == null ? null : sgUpdateTime.trim();
    }

    public String getSgRemark() {
        return sgRemark;
    }

    public void setSgRemark(String sgRemark) {
        this.sgRemark = sgRemark == null ? null : sgRemark.trim();
    }
}