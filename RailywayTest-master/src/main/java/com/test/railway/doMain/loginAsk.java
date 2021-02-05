package com.test.railway.doMain;

import java.io.Serializable;


public class loginAsk implements Serializable {

    /**
     * account : ozt1
     * password : ${__MD5(admin123,)}
     * code : 14070613
     * visitKey : ""
     * isRemain : true
     */

    private String account;
    private String password;
    private String code;
    private String visitKey;
    private boolean isRemain;

    public loginAsk(String account,String code){
        this.account=account;
        this.password="0192023a7bbd73250516f069df18b500";
        this.code=code;
        this.visitKey="";
        this.isRemain=true;
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVisitKey() {
        return visitKey;
    }

    public void setVisitKey(String visitKey) {
        this.visitKey = visitKey;
    }

    public boolean isIsRemain() {
        return isRemain;
    }

    public void setIsRemain(boolean isRemain) {
        this.isRemain = isRemain;
    }
}
