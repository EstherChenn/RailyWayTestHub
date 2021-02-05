package com.test.douban.domain;

import java.util.List;

/**
 * @Auther: jx
 * @Date: 2018/7/13 18:01
 * @Description:用于解析的json的实体类  ————接收服务器返回数据
 */
public class MovieResponseVO {

    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
