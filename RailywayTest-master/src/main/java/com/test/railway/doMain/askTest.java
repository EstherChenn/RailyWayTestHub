package com.test.railway.doMain;

/**
 * @author :chensuzi
 * @ClassName :ValidateActionJson
 * @Description :TODO
 * @cersion :V1.0
 * @date :2020/4/151438
 **/
public class askTest {
    /**
     * account : csz
     * password : admin123
     */

    private String account;
    private String password;

    public askTest(String account, String password) {
        this.account = account;
        this.password = password;
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
}
