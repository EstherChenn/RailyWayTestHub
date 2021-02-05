package com.test.common;

import com.test.tools.RespVoConverterFactory;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.testng.Reporter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: jx
 * @Date: 2018/7/13 17:47
 * @Description: Http基础使用类。
 */
public class HttpBase {
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private Retrofit retrofit;
    private String host;

    /**
     * 构造方法（1个参数）
     * 只传Host
     * 可以加入自定义拦截器 -超时判断
     * 或者，默认没有使用拦截器。
     *
     * @param host 访问域名host
     */
    public HttpBase(String host) {
        //可添加响应超时拦截器
        Interceptor interceptor = new MyInterceptor();
        //初始化
        init(host, interceptor);
        //init(host, null);
    }

    /**
     * 构造方法（2个参数）
     * 只传Host，默认使用日志拦截器。
     *
     * @param host        访问域名host
     * @param interceptor 自定义拦截器
     */
    public HttpBase(String host, Interceptor interceptor) {
        init(host, interceptor);
    }

    /**
     * 初始化方法
     *
     * @param host        访问域名host
     * @param interceptor 自定义拦截器
     */
    private void init(String host, Interceptor interceptor) {
        OkHttpClient.Builder client = getHttpClient(interceptor);
        // 创建Retrofit对象
        retrofit = new Retrofit.Builder()
                .baseUrl(host)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
               // .addConverterFactory(RespVoConverterFactory.create())
                .build();
    }

    /**
     * 获取HttpClient.Builder 方法。
     * 默认添加了，基础日志拦截器
     *
     * @param interceptor 拦截器
     * @return HttpClient.Builder对象
     */
    private OkHttpClient.Builder getHttpClient(Interceptor interceptor) {
        HttpLoggingInterceptor logging = getHttpLoggingInterceptor();
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);
        if (interceptor != null) {
            builder.addInterceptor(interceptor);
        }
        builder.addInterceptor(logging);
        return builder;
    }

    /**
     * 日志拦截器
     *
     * @return
     */
    private HttpLoggingInterceptor getHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override          //表示方法重写
            public void log(String message) {
                Reporter.log("RetrofitLog--> " + message, true);
            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);//Level中还有其他等级
        return logging;
    }

    /**
     * retrofit构建方法
     *
     * @param clazz 泛型类
     * @param <T>   泛型类
     * @return 泛型类
     */
    public <T> T create(Class<T> clazz) {
        return retrofit.create(clazz);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
