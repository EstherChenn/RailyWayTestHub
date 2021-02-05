package com.test.railway.doMain;

public class ArgumentsListttt {
    private Integer code;     // 姓名
    private String deviceId;     // 年龄
    private String hiCloudToken;   // 性别
    private Boolean isDemo;
    private String message;
    private String protocolHead;
    private Integer protocolType;
    private Integer registerType;
    private Boolean success;


    public ArgumentsListttt() {
        this.code = -1;
        this.deviceId=deviceId;
        this.hiCloudToken = hiCloudToken;
        this.isDemo = false;
        this.message="";
        this.protocolHead="gis_fl";
        this.protocolType=1000002;
        this.registerType=2;
        this.success=false;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setHiCloudToken(String hiCloudToken) {
        this.hiCloudToken = hiCloudToken;
    }

    public String getHiCloudToken() {
        return hiCloudToken;
    }

    public void setisDemo(Boolean isDemo) {
        this.isDemo = isDemo;
    }

    public Boolean getisDemo() {
        return isDemo;
    }

    public void setmessage(String message) {
        this.message = message;
    }

    public String getmessage() {
        return message;
    }

    public void setprotocolHead(String protocolHead) {
        this.protocolHead = protocolHead;
    }

    public String getprotocolHead() {
        return protocolHead;
    }
    public void setregisterType(Integer registerType) {
        this.registerType = registerType;
    }

    public Integer getprotocolType() {
        return protocolType;
    }

    public void setprotocolType(Integer protocolType) {
        this.protocolType = protocolType;
    }

    public Integer getregisterType() {
        return registerType;
    }

    public void setsuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getsuccess() {
        return success;
    }
}
