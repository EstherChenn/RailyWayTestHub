package com.test.reqres.receptDomain;

/**
 *
 *@ClassName :IntelliJ IDEA
 *@Description :TODO
 *@version :V1.0
 *@author :chensuzi
 *@date :2020/4/14 14:58
 */
public class postrequest {
    /**
     * email : eve.holt@reqres.in
     * password : pistol
     */

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public  postrequest(String email, String password){
        this.email = email;
        this.password = password;
    }
}
