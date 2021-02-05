package com.test.tools;

import com.alibaba.fastjson.JSONObject;
import com.test.douban.domain.MovieResponseVO;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @Auther: jx
 * @Date: 2018/7/17 17:29
 * @Description:转换Jason为字符串？？？
 */
public class RespVoConverterFactory extends Converter.Factory {
    public static RespVoConverterFactory create() {
        return new RespVoConverterFactory();
    }

    private RespVoConverterFactory() {

    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new RespVoConverter();
    }

    public class RespVoConverter implements Converter<ResponseBody, MovieResponseVO> {
        @Override
        public MovieResponseVO convert(ResponseBody value) throws IOException {
            //将其他类型的变量转换为字符串类型
            String temp = value.string();
            return JSONObject.parseObject(temp, MovieResponseVO.class);
        }
    }

}
