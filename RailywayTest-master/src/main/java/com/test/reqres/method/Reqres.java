package com.test.reqres.method;

import com.test.common.HttpBase;
import com.test.reqres.jiekou.IResqres;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

/**
 *
 *@ClassName :IntelliJ IDEA
 *@Description :TODO
 *@cersion :V1.0
 *@author :chensuzi
 *@date :2020/4/1010:50
 */
public class Reqres  extends HttpBase {
    //IResqres是一个接口
    private com.test.reqres.jiekou.IResqres IResqres;

    /**
     * 描述：此方法为每个接口类前置默认不修改内容
     * @param host
     */
    public Reqres(String host) {
        //[super]是一个指代变量，用于在子类中指代父类对象。-----HttpBase(String host)
        super(host);
        IResqres = super.create(IResqres.class);
    }


    /** ——————————————从此处开始写接口方法(方法需要在IResqres接口类内先定义)——————————————*/

    /** ——————————————GET——————————————*/
    public Response<ResponseBody> users(String type) throws IOException {
        Call<ResponseBody> call = IResqres.users(type);
        return call.execute();
    }

    public Response<ResponseBody> singleUser() throws IOException {
        Call<ResponseBody> call = IResqres.singleUser();
        return call.execute();
    }

    /** ——————————————POST——————————————*/
    public Response<ResponseBody> register(String email,String password) throws IOException {
        Call<ResponseBody> call = IResqres.register(email,password);
       //同步
        Call<ResponseBody> clone = call.clone();
        return clone.execute();
    }

    public Response<ResponseBody> login(String email,String password) throws IOException {
        Call<ResponseBody> call = IResqres.login(email,password);
        //同步
        Call<ResponseBody> clone = call.clone();
        return clone.execute();
    }

}
