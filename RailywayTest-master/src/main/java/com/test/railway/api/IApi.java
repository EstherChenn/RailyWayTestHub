package com.test.railway.api;

import com.test.railway.doMain.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @author :chensuzi
 * @ClassName :ValidateActionJson
 * @Description :TODO
 * @cersion :V1.0
 * @date :2020/4/151336
 **/
public interface IApi {
    /**
     *   登录
     */
    @POST("/api/client/login")
    Call<loginBack> login(@Body loginAsk ask);

    /**
     *  获取connectionId
     * @return
     */
    @POST("/HiCloud/Duplex/negotiate?negotiateVersion=1")
    Call<connectionId_RES> getConnectionId( );

    //ResponseBody
    @GET("/api/user/getMenu")
    Call<ResponseBody> getMenu(@Query("ssoToken") String ssoToken);

    //ResponseBody
    @GET("/api/user/getUserInfo")
    Call<ResponseBody> getUserInfo(@Query("ssoToken") String ssoToken);

    /**
     * 表明是一个表单格式的请求（Content-Type:application/x-www-form-urlencoded）
     * <code>Field("username")</code> 表示将后面的 <code>String name</code> 中name的取值作为 username 的值
     */

    @POST("pmsApi/user/getNewToken")
    Call<back> getNewToken(@Body askTest ask);

    @Headers({"Content-Type: application/json","Connection:keep-alive","Transfer-Encoding:chunked"})
    @FormUrlEncoded
    @POST("api/device/getDeviceList")
    Call<ResponseBody> getDeviceList(@Field("pageQuery") int pageQuery,@Query("ssoToken") String ssoToken);

    @POST("/api/user/changeSelfPassword")
    Call<ResponseBody> changeSelfPassword(@Query("oldPassword") String oldPassword, @Query("newPassword") String newPassword,@Query("ssoToken") String ssoToken);


    @POST("/api/whitelist/insertWhiteList")
    Call<ResponseBody> insertWhiteList(@Body dto dtoTest, @Query("ssoToken") String ssoToken);

}
