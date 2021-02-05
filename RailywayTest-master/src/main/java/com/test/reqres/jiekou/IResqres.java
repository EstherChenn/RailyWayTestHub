package com.test.reqres.jiekou;

import com.test.reqres.receptDomain.backData;
import com.test.reqres.receptDomain.postrequest;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * @author :chensuzi
 * @ClassName :ValidateActionJson
 * @Description :网络请求接口描述文件
 * @cersion :V1.0
 * @date :2020/4/101135
 **/
public interface IResqres {
    //MovieResponseVO为返回值类型
    @GET("api/users")
    Call<ResponseBody> users(@Query("page") String type);

    @GET("/api/users/2")
    Call<ResponseBody> singleUser();

    //采用@Post表示Post方法进行请求（传入部分url地址）
    // 采用@FormUrlEncoded注解的原因:API规定采用请求格式x-www-form-urlencoded,即表单形式
    // 需要配合@Field 向服务器提交需要的字段
    //@body即非表单请求体，被@Body注解的ask将会被Gson转换成json发送到服务器，返回到Take。 // 其中返回类型为Call<*>，*是接收数据的类
   // @Headers({"Content-Type: application/json","Accept: application/json"})
    @FormUrlEncoded
    @POST("api/register")
    //Call<ResponseBody> register(@Body postrequest retest);
    Call<ResponseBody> register(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("api/login")
    Call<ResponseBody> login(@Field("email") String email, @Field("password") String password);

}
