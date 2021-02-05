package com.jxq.douban;

import com.alibaba.fastjson.JSONObject;
import com.test.reqres.method.Reqres;
import com.test.tools.JsonSchemaUtils;
import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *@ClassName :ValidateActionJson
 *@Description :TODO
 *@cersion :V1.0
 *@author :chensuzi
 *@date :2020/4/91725
 **/
public class ReqresTest {
    private static Properties properties;
    private static Reqres implSearch;
    private static String SCHEMA_PATH = "parameters/search/schema/schemaTest.json";
    private static String SCHEMA_PATH_1 = "parameters/search/schema/test.json";

    @BeforeSuite
    public void beforeSuite() throws IOException {
        //环境配置输入流
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("env.properties");
        properties = new Properties();
        properties.load(stream);
        //读取url地址的ip地址和端口部分
        String host = properties.getProperty("reqres.host");
        //retrofit2的创建对象和create操作
        implSearch = new Reqres(host);
        //执行网络请求操作的配置文件（url的元素内容）
        stream = this.getClass().getClassLoader().getResourceAsStream("parameters/search/SearchTagsParams.properties");
        properties.load(stream);
       // stream = this.getClass().getClassLoader().getResourceAsStream("");
        stream.close();
        //https://blog.csdn.net/weixin_42884654/article/details/102802821?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-4&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-4
       // SqlSession sqlSession = DatabaseUtil.getSqlSession("databaseConfig.xml");
    }


    @Test
    public void testcase1() throws IOException {
        String type = properties.getProperty("testcase.req.page");

        Response<ResponseBody> response = implSearch.users(type);
        ResponseBody body = response.body();
        Assert.assertNotNull(body, "response.body()");
//        响应返回内容想通过schema标准校验
        JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH, JSONObject.toJSONString(body));
//        再Json化成对象
       // Assert.assertNotNull(body.getTags(), "tags");
    }


    @Test
    public void test1() throws IOException {
        String type = properties.getProperty("testcase.req.page");

        Response<ResponseBody> response = implSearch.users(type);
        ResponseBody body = response.body();
        JSONObject jsonObject = JSONObject.parseObject(body.string());
        //响应返回内容想通过schema标准校验
        JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH, JSONObject.toJSONString(body));

        /*System.out.println("----------------------------------------");
        System.out.println("jsonObject:" + jsonObject.getString("jsonObject"));*/
        System.out.println("----------------------------------------");
        System.out.println("【data[1].email】:" + jsonObject.getJSONArray("data").getJSONObject(1).getString("email"));
       // assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2没有问题，Go！");
        System.out.println("----------------------------------------");
        System.out.println("data:" + jsonObject.getString("data"));
    }


    @Test
    public void test2() throws IOException {
        String type = properties.getProperty("testcase.req.page");

        Response<ResponseBody> response = implSearch.singleUser();
        ResponseBody body = response.body();
        JSONObject jsonObject = JSONObject.parseObject(body.string());
        //响应返回内容想通过schema标准校验
        JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH_1, JSONObject.toJSONString(body));

    }


        @Test
    public void post_test1() throws IOException {
           // postrequest.PerceptionBean.InputTextBean pre = new postrequest.PerceptionBean.InputTextBean(text);
            Response<ResponseBody> response = implSearch.register("eve.holt@reqres.in","pistol");
            ResponseBody body = response.body();
             JSONObject jsonObject = JSONObject.parseObject(body.string());
        //响应返回内容想通过schema标准校验
      //  JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH_1, JSONObject.toJSONString(body));
            System.out.println("----------------------------------------");
            response = implSearch.register("sydney@fife","");
    }

    @Test
    public void post_test2() throws IOException {
        Response<ResponseBody> response = implSearch.login("eve.holt@reqres.in","cityslicka");
        ResponseBody body = response.body();
        JSONObject jsonObject = JSONObject.parseObject(body.string());
        //响应返回内容想通过schema标准校验
        //  JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH_1, JSONObject.toJSONString(body));
        System.out.println("----------------------------------------");
        response = implSearch.login("sydney@fife","");
    }
}
