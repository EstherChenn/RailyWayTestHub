package com.test.railway.doMain;

import java.util.List;

public class JSONTE {

    /**
     * arguments : ["{\"code\":-1,\"deviceId\":\"44dd2d93-910e-4ac7-8acc-ac130125d958\",\"hiCloudToken\":\"SSO0068f12497024d9090f603e877a76294\",\"isDemo\":false,\"message\":\"\",\"protocolHead\":\"gis_fl\",\"protocolType\":1000002,\"registerType\":2,\"success\":false}"]
     * target : Send
     * type : 1
     */

    private String target;
    private int type;
    private List<ArgumentsListttt> arguments;

    public JSONTE(){
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

    public List<ArgumentsListttt> getArguments() {
        return arguments;
    }

    public void setArguments(List<ArgumentsListttt> arguments) {
        this.arguments = arguments;
    }
}
