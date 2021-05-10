package com.zst.el.bean;

public class EmUser {
    private Integer sgId;

    private String sgNumber;

    private String sgUserType;

    private String sgPassword;

    private String sgState;

    private String sgDelFlag;

    private String sgCreateTime;

    private String sgUpdateTime;

    private String sgRemark;

    public Integer getSgId() {
        return sgId;
    }

    public void setSgId(Integer sgId) {
        this.sgId = sgId;
    }

    public String getSgNumber() {
        return sgNumber;
    }

    public void setSgNumber(String sgNumber) {
        this.sgNumber = sgNumber == null ? null : sgNumber.trim();
    }

    public String getSgUserType() {
        return sgUserType;
    }

    public void setSgUserType(String sgUserType) {
        this.sgUserType = sgUserType == null ? null : sgUserType.trim();
    }

    public String getSgPassword() {
        return sgPassword;
    }

    public void setSgPassword(String sgPassword) {
        this.sgPassword = sgPassword == null ? null : sgPassword.trim();
    }

    public String getSgState() {
        return sgState;
    }

    public void setSgState(String sgState) {
        this.sgState = sgState == null ? null : sgState.trim();
    }

    public String getSgDelFlag() {
        return sgDelFlag;
    }

    public void setSgDelFlag(String sgDelFlag) {
        this.sgDelFlag = sgDelFlag == null ? null : sgDelFlag.trim();
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