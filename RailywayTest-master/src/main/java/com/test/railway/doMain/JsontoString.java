package com.test.railway.doMain;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class JsontoString {

    /**
     * arguments : ["{\"code\":-1,\"deviceId\":\"${deviceid}\",\"hiCloudToken\":\"${TOKEN}\",\"isDemo\":false,\"message\":\"\",\"protocolHead\":\"gis_fl\",\"protocolType\":1000002,\"registerType\":2,\"success\":false}"]
     * target : Send
     * type : 1
     */

    private String target;
    private int type;
    private ArrayList<ArgumentsList> arguments;

    public JsontoString(){
        this.target="Send";
        this.type=1;
        this.arguments=getArguments();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<ArgumentsList> getArguments() {
        return arguments;
    }

    public void setArguments(String deviceid, String hiCloudToken ) {
        ArrayList<ArgumentsList> arguments = new ArrayList<ArgumentsList>();
        ArgumentsList arg =new ArgumentsList(deviceid,hiCloudToken);
        arguments.add(arg);
        //this.arguments.
        this.arguments = arguments;
    }

    public static class ArgumentsList {
        private Integer code;     // 姓名
        private String deviceId;     // 年龄
        private String hiCloudToken;   // 性别
        private Boolean isDemo;
        private String message;
        private String protocolHead;
        private Integer protocolType;
        private Integer registerType;
        private Boolean success;


        public ArgumentsList(String deviceId, String hiCloudToken) {
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
    }
}
