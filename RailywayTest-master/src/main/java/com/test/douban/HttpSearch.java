package com.test.douban;

import com.test.common.HttpBase;
import com.test.douban.domain.MovieResponseVO;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * @Auther: jx
 * @Date: 2018/7/13 17:47
 * @Description:搜索接口的方法
 */
public class HttpSearch extends HttpBase {
    //ISearch是一个接口
    private ISearch iSearch;

    public HttpSearch(String host) {
        //[super]是一个指代变量，用于在子类中指代父类对象。-----HttpBase(String host)
        super(host);
        iSearch = super.create(ISearch.class);
    }

    // 发送同步请求并返回其响应
    public Response<MovieResponseVO> searchTags(String type, String source) throws IOException {
        // 调用接口中方法
        Call<MovieResponseVO> call = iSearch.searchTags(type, source);
        return call.execute();
    }


    //    同模块下，新增的接口可添加到这里。
//    public Response<MovieResponseVO> searchTags(String type, String source) throws IOException {
//        Call<MovieResponseVO> call = iSearch.searchTags(type, source);
//        return call.execute();
//    }
}
