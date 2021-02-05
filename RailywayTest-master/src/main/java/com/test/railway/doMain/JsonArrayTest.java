package com.test.railway.doMain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonArrayTest {

    /**
     * arguments : ["{\"code\":-1,\"deviceId\":\"${deviceid}\",\"hiCloudToken\":\"${TOKEN}\",\"isDemo\":false,\"message\":\"\",\"protocolHead\":\"gis_fl\",\"protocolType\":1000002,\"registerType\":2,\"success\":false}"]
     * target : Send
     * type : 1
     */

    private String target;
    private int type;
    private JSONArray arguments;

    public JsonArrayTest(){
        this.target="Send";
        this.type=1;
        this.arguments=arguments;
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

    public JSONArray getArguments() {
        return arguments;
    }

    public void setArguments(String deviceid, String hicloudtoken ) throws JSONException {
        JSONObject json1 = new JSONObject();
        json1.accumulate("code",-1);
        json1.accumulate("deviceId",deviceid);
        json1.accumulate("hiCloudToken",hicloudtoken);
        json1.accumulate("isDemo",false);
        json1.accumulate("message","");
        json1.accumulate("protocolHead","gis_fl");
        json1.accumulate("protocolType",1000002);
        json1.accumulate("registerType",2);
        json1.accumulate("success",false);

        this.arguments=arguments;
    }

    public void pl(){
        System.out.println(arguments.toString());
    }
}
