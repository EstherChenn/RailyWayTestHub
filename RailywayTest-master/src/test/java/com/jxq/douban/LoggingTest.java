package com.jxq.douban;

import com.alibaba.fastjson.JSONObject;
import com.test.douban.HttpSearch;
import com.test.douban.domain.MovieResponseVO;
import com.test.tools.JsonSchemaUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *@ClassName :ValidateActionJson
 *@Description :TODO
 *@cersion :V1.0
 *@author :chensuzi
 *@date :2020/4/91713
 **/
public class LoggingTest {
    private static Properties properties;
    private static HttpSearch implSearch;
    private static String SCHEMA_PATH = "parameters/search/schema/SearchTagsMovie.json";

    @BeforeSuite
    public void beforeSuite() throws IOException {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("env.properties");
        properties = new Properties();
        properties.load(stream);
        String host = properties.getProperty("douban.log.host");
        implSearch = new HttpSearch(host);
        stream = this.getClass().getClassLoader().getResourceAsStream("parameters/search/SearchTagsParams.properties");
        properties.load(stream);
        stream = this.getClass().getClassLoader().getResourceAsStream("");
        stream.close();
    }

    @Test(description = "电影首页。类别:type=movie source=index")
    public void testcase1() throws IOException {
        String type = properties.getProperty("testcase1.req.type");
        String source = properties.getProperty("testcase1.req.source");

        Response<MovieResponseVO> response = implSearch.searchTags(type, source);
        MovieResponseVO body = response.body();
        Assert.assertNotNull(body, "response.body()");
//        响应返回内容想通过schema标准校验
        JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH, JSONObject.toJSONString(body));
//        再Json化成对象
        Assert.assertNotNull(body.getTags(), "tags");
    }

}
