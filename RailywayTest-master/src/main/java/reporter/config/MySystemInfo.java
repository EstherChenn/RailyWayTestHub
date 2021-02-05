package reporter.config;

import com.vimalselvam.testng.SystemInfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Des: 可用于添加系统信息，例如：db的配置信息，人员信息，环境信息等。根据项目实际情况添加。
 * @Date: 2018/6/7 10:54
 * @Description:
 */
public class MySystemInfo implements SystemInfo {
    @Override
    public Map<String, String> getSystemInfo() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("env.properties");
        Properties properties = new Properties();
        Map<String, String> systemInfo = new HashMap<>();
        try {
            properties.load(inputStream);
            systemInfo.put("environment", properties.getProperty("Environment"));
            systemInfo.put("sqlURL", properties.getProperty("ESsql.URL"));
            systemInfo.put("redisHost", properties.getProperty("redis.host"));
            systemInfo.put("redisPort", properties.getProperty("redis.port"));
            systemInfo.put("mongodbHost", properties.getProperty("mongodb.host"));
            systemInfo.put("mongodbPort", properties.getProperty("mongodb.port"));
            systemInfo.put("测试人员", "csz");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return systemInfo;
    }
}
