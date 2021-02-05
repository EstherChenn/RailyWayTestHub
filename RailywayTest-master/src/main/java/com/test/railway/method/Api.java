package com.test.railway.method;

import com.test.common.HttpBase;
import com.test.railway.api.IApi;
import com.test.railway.doMain.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Query;

import java.io.IOException;

/**
 *
 *@ClassName :IntelliJ IDEA
 *@Description :TODO
 *@version :V1.0
 *@author :chensuzi
 *@date :2020/4/15 13:36
 */
public class Api extends HttpBase {
    //IApis是一个接口
    private com.test.railway.api.IApi IApi;

    /**
     * 描述：此方法为每个接口类前置默认不修改内容
     * @param host
     */
    public Api(String host) {
        //[super]是一个指代变量，用于在子类中指代父类对象。-----HttpBase(String host)
        super(host);
        IApi = super.create(IApi.class);
    }

    /** ——————————————从此处开始写接口方法(方法需要在IApis接口类内先定义)——————————————*/

    /** ——————————————GET——————————————*/
    public Response<ResponseBody> getMenu(String ssoToken) throws IOException {
        Call<ResponseBody> call = IApi.getMenu(ssoToken);
        return call.execute();
    }

    public Response<ResponseBody> getUserInfo(String ssoToken) throws IOException {
        Call<ResponseBody> call = IApi.getUserInfo(ssoToken);
        return call.execute();
    }

    /** ——————————————POST——————————————*/
    /**
     *  登录
     *
     * @param account
     * @param code
     * @return
     * @throws IOException
     */
    public Response<loginBack> login(String account, String code) throws IOException {
        Call<loginBack> call = IApi.login(new loginAsk(account,code));
        //同步
        Call<loginBack> clone = call.clone();
        return clone.execute();
    }

    public Response<connectionId_RES> getConnectionId() throws IOException {
        Call<connectionId_RES> call = IApi.getConnectionId();
        //同步
        Call<connectionId_RES> clone = call.clone();
        return clone.execute();
    }
    public Response<ResponseBody> changeSelfPassword(String oldPassword, String newPassword, String ssoToken) throws IOException {
        Call<ResponseBody> call = IApi.changeSelfPassword(oldPassword,newPassword,ssoToken);
        //同步
        Call<ResponseBody> clone = call.clone();
        return clone.execute();
    }

    public Response<back> getNewToken(String account, String password) throws IOException {
        Call<back> call = IApi.getNewToken(new askTest(account,password));
        //同步
        Call<back> clone = call.clone();
        return clone.execute();
    }

    public Response<ResponseBody> getDeviceList(String ssoToken,int pageQuery) throws IOException {
        Call<ResponseBody> call = IApi.getDeviceList(pageQuery,ssoToken);
        //同步
        Call<ResponseBody> clone = call.clone();
        return clone.execute();
    }

    public Response<ResponseBody> insertWhiteList(dto dtoTest, String ssoToken) throws IOException {
        Call<ResponseBody> call = IApi.insertWhiteList(dtoTest,ssoToken);
        //同步
        Call<ResponseBody> clone = call.clone();
        return clone.execute();
    }
}
