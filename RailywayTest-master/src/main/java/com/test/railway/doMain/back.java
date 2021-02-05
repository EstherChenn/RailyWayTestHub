package com.test.railway.doMain;

/**
 * @author :chensuzi
 * @ClassName :ValidateActionJson
 * @Description :TODO
 * @cersion :V1.0
 * @date :2020/4/151439
 **/
public class back {
    /**
     * code : 200
     * success : true
     * message : 请求成功
     * result : SSO850192b0ac5641afa1bcbe3dfa4985fc
     * other : null
     */

    private int code;
    private boolean success;
    private String message;
    private String result;
    private Object other;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }
}
