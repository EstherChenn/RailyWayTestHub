package com.jxq.douban;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.test.common.MyWebSocketClient;
import com.test.railway.doMain.*;
import com.test.railway.method.Api;
import com.test.tools.JsonSchemaUtils;
import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.*;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author :chensuzi
 * @ClassName :ValidateActionJson
 * @Description :TODO
 * @cersion :V1.0
 * @date :2020/4/151350
 **/
public class RailwayTest {
    private static Properties properties;
    private static Api IApis;
    private static String SCHEMA_PATH = "parameters/search/schema/schemaTest.json";
    private static String SCHEMA_PATH_1 = "parameters/search/schema/test.json";


    @BeforeSuite
    public void beforeSuite() throws IOException {
        //环境配置输入流
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("env.properties");
        properties = new Properties();
        properties.load(stream);
        //读取url地址的ip地址和端口部分
        String host = properties.getProperty("railyway.host");
        //retrofit2的创建对象和create操作
        IApis = new Api(host);
        //执行网络请求操作的配置文件（url的元素内容）
        stream = this.getClass().getClassLoader().getResourceAsStream("parameters/search/SearchTagsParams.properties");
        properties.load(stream);
        // stream = this.getClass().getClassLoader().getResourceAsStream("");
        stream.close();
    }


    @Test(description = "获取Token 传入:account password")
    public void getNewToken() throws IOException {
        System.out.println("-------------------登录---------------------");
        Response<loginBack> response = IApis.login("cszsq01", "14070709");
        System.out.println("-------------------getConnectionId---------------------");
        Response<connectionId_RES> response1 = IApis.getConnectionId();
        connectionId_RES body = response1.body();
        System.out.println("getConnectionId = " + body.getConnectionId());
        // System.out.println(ResponseBody.getResult());
        //  JSONObject jsonObject = JSONObject.parseObject(body.string());
        //响应返回内容想通过schema标准校验
        //  JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH_1, JSONObject.toJSONString(body));
        System.out.println("----------------------------------------");
        // System.out.println(body.getResult());
        System.out.println("----------------------------------------");
        //响应返回内容想通过schema标准校验
        JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH, JSONObject.toJSONString(body));
    }


    @Test
    public void getMenuTest() throws IOException {
        //获取token
        Response<back> response = IApis.getNewToken("csz", "admin123");
        back body = response.body();
        System.out.println("\n----------------------------------------");
        Response<ResponseBody> MenuRsponse = IApis.getUserInfo(body.getResult());
        System.out.println("\n----------------------------------------");
        ResponseBody MenuBody = MenuRsponse.body();
        Assert.assertNotNull(MenuBody, "MenuRsponse.body()");

        //响应返回内容想通过schema标准校验
        JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH, JSONObject.toJSONString(body));
    }


    @Test
    public void getDeviceListTest() throws IOException {
        Response<back> response = IApis.getNewToken("csz", "admin123");
        back body = response.body();
        System.out.println(body.getResult());
        //响应返回内容想通过schema标准校验
        JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH_1, JSONObject.toJSONString(body));
        System.out.println("----------------------------------------");
        System.out.println(body.getResult());
        System.out.println("------------------getDeviceListTest----------------------");
        Response<ResponseBody> response1 = IApis.getDeviceList(body.getResult(), 1);
        //    response = IApis.register("sydney@fife","");
    }

    @Test
    public void changeSelfPasswordTest() throws IOException {
        Response<back> response = IApis.getNewToken("csz", "admin123");
        back body = response.body();
        System.out.println("----------------------------------------");
        Response<ResponseBody> Response = IApis.changeSelfPassword("admin123", "admin123", body.getResult());
        ResponseBody Body = Response.body();
        // System.out.println(body.isSuccess());
        //响应返回内容想通过schema标准校验
        //  JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH_1, JSONObject.toJSONString(body));
        System.out.println("----------------------------------------");
        //    response = IApis.register("sydney@fife","");
    }

    @Test
    public void insertWhiteListTest() throws IOException {
        Response<back> response = IApis.getNewToken("csz", "admin123");
        back body = response.body();
        System.out.println("----------------------------------------");
        dto dto1 = new dto("com.dewmobile.kuaiya", "5.8.3", "kuaiya", true, "快牙");

        Response<ResponseBody> Response = IApis.insertWhiteList(dto1, body.getResult());
        ResponseBody Body = Response.body();
        // System.out.println(body.isSuccess());
        //响应返回内容想通过schema标准校验
        //  JsonSchemaUtils.assertResponseJsonSchema(SCHEMA_PATH_1, JSONObject.toJSONString(body));
        System.out.println("----------------------------------------");
        //    response = IApis.register("sydney@fife","");
    }

    @Test
    public void test1() throws IOException {
        try {
            //   String myUrl = "ws://121.40.165.18:8800";
            String myUrl = "ws://10.6.2.25:45509";
            URI myURI = new URI(myUrl);
            // 此处的WebSocket服务端URI，上面服务端第2点有详细说明
            MyWebSocketClient myClient = new MyWebSocketClient(myURI);
            myClient.connectBlocking();

            //  myClient.connect();
            while (myClient.getReadyState().equals(("CLOSED"))) {
                myClient.connect();
            }
            // 往websocket服务端发送数据
            System.out.println(myClient.getReadyState() + "连接成功");
            myClient.send("123");
            myClient.send("456");
            myClient.close();
        } catch (Exception e) {
            //打印输出异常
            e.printStackTrace();
        }
    }

    private static void sendLine(String line, OutputStream outPipe)
            throws IOException {
        outPipe.write(line.getBytes());
        outPipe.flush();
    }

    /**
     * @author Miracle Luna
     * @version 1.0
     * @date 2019/7/5 18:06
     */
    public class ArgumentsList {
        private Integer code;     // 姓名
        private String deviceId;     // 年龄
        private String hiCloudToken;   // 性别
        private Boolean isDemo;
        private String message;
        private String protocolHead;
        private Integer protocolType;
        private Integer registerType;
        private Boolean success;


        public ArgumentsList(String deviceId, String hiCloudToken) {
            this.code = -1;
            this.deviceId = deviceId;
            this.hiCloudToken = hiCloudToken;
            this.isDemo = false;
            this.message = "";
            this.protocolHead = "gis_fl";
            this.protocolType = 1000002;
            this.registerType = 2;
            this.success = false;
        }

    }

    /**
     * Socket客户端
     */
    @Test
    public void main1() throws IOException {
        try {
            String deviceid = "14070709";
            System.out.println("-------------------登录---------------------");
            Response<loginBack> response = IApis.login("cszsq01", deviceid);
            loginBack body1 = response.body();
            System.out.println("-------------------getConnectionId---------------------");
            Response<connectionId_RES> response1 = IApis.getConnectionId();
            connectionId_RES body = response1.body();
            System.out.println("getConnectionId = " + body.getConnectionId());
            System.out.println("------------------- Socket连接---------------------");
            OutputStream out;
            InputStream in;
            //创建Socket对象
            Socket socket = new Socket("10.6.2.25", 45509);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            MyWebSocketClient myClient = new MyWebSocketClient(new URI("ws://10.6.2.25:45509/HiCloud/Duplex?id=" + body.getConnectionId()));
            myClient.connectBlocking();
            myClient.send("{\"protocol\":\"json\",\"version\":1}\u001E");
            myClient.send("{\"type\":6}\u001E"); //{"type":6}
            System.out.println("-------------------JsontoString---------------------");

            JSONTE JT = new JSONTE();
            List<ArgumentsListttt> arguments = new ArrayList();
            // ArgumentsListttt arg = new ArgumentsListttt(deviceid,body1.getResult().getItem1().getToken());
            ArgumentsListttt arg = new ArgumentsListttt();
            arg.setDeviceId(deviceid);
            arg.setHiCloudToken(body1.getResult().getItem1().getToken());
            /*arg.setCode(-1);
            arg.setisDemo(false);
            arg.setmessage("");
            arg.setprotocolHead("gis_fl");
            arg.setprotocolType(1000002);
            arg.setregisterType(2);
            arg.setsuccess(false);*/
            arguments.add(arg);
            JT.setArguments(arguments);
            // System.out.println("jsonObject : " + JSONObject.toJSONString(JT) );
            System.out.println("\n-------------------JsontoString--END-------------------");
            /*JsonArrayTest ja=new JsonArrayTest();
            ja.setArguments(deviceid,body1.getResult().getItem1().getToken());
            ja.pl();*/
            String t = "{\"arguments\":[\"{\"code\":-1,\"deviceId\":\""
                    + deviceid + "\",\"hiCloudToken\":\"" + body1.getResult().getItem1().getToken() + "\",\"isDemo\":false,\"message\":\"\",\"protocolHead\":\"gis_fl\",\"protocolType\":1000002,\"registerType\":2,\"success\":false}\"],\"target\":\"Send\",\"type\":1}\u001E";
            String t1 = JSONObject.toJSONString(JT);
            System.out.println("t1 : " + t1);
            System.out.println("-------------------Socket---------------------");
            myClient.send(t1+"\u001E");
          /*  myClient.send("{\"ArgumentsListttt\":[\"{\\\"code\\\":-1,\\\"hiCloudToken\\\":\\\""+ body1.getResult().getItem1().getToken() +"\\\",\\\"message\\\":\\\"\\\",\\\"protocolHead\\\":\\\"gis_fl\\\",\\\"protocolType\\\":10000030,\\\"success\\\":false}\"],\"target\":\"Send\",\"type\":1}\u001E");
            myClient.send("{\"ArgumentsListttt\":[\"{\\\"code\\\":-1,\\\"hiCloudToken\\\":\\\"" + body1.getResult().getItem1().getToken() +"\\\",\\\"message\\\":\\\"\\\",\\\"protocolHead\\\":\\\"gis_fl\\\",\\\"protocolType\\\":1000000,\\\"success\\\":false}\"],\"target\":\"Send\",\"type\":1}\u001E");
            myClient.send("{\"ArgumentsListttt\":[\"{\\\"code\\\":-1,\\\"electricQuantity\\\":78,\\\"hiCloudToken\\\":\\\""+ body1.getResult().getItem1().getToken() +"\\\",\\\"message\\\":\\\"\\\",\\\"protocolHead\\\":\\\"gis_fl\\\",\\\"protocolType\\\":10000014,\\\"success\\\":false,\\\"userId\\\":\\\"3d6d42b3-0465-435e-a8d4-ac5700e03b61\\\"}\"],\"target\":\"Send\",\"type\":1}\u001E");
            myClient.send("{\"ArgumentsListttt\":[\"{\\\"code\\\":-1,\\\"hiCloudToken\\\":\\\""+ body1.getResult().getItem1().getToken() +"\\\",\\\"message\\\":\\\"\\\",\\\"protocolHead\\\":\\\"gis_fl\\\",\\\"protocolType\\\":1000000,\\\"success\\\":false}\"],\"target\":\"Send\",\"type\":1}\u001E");
*/

            //  myClient.close();
            //   sendLine( "{protocol:json,version:1}u001E", out );
            BufferedReader bin = new BufferedReader(
                    new InputStreamReader(in));
            String line;
            while ((line = bin.readLine()) != null)
                System.out.println(line);
            /*MyWebSocketClient myClient = new MyWebSocketClient(new URI("ws://10.6.2.25:45509/HiCloud/Duplex?id="+ body.getConnectionId()));
            myClient.connect();
            myClient.send("123");*/
            //根据输入输出流和服务端连接
            OutputStream outputStream = socket.getOutputStream();//获取一个输出流，向服务端发送信息
            PrintWriter printWriter = new PrintWriter(outputStream);//将输出流包装成打印流

            printWriter.flush();
            socket.shutdownOutput();//关闭输出流


            InputStream inputStream = socket.getInputStream();//获取一个输入流，接收服务端的信息
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//包装成字符流，提高效率
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//缓冲区
            String info = "";
            String temp = null;//临时变量
            while ((temp = bufferedReader.readLine()) != null) {
                info += temp;
                System.out.println("客户端接收服务端发送信息：" + info);
            }

            //关闭相对应的资源
            bufferedReader.close();
            inputStream.close();
            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (Exception e) {
            //打印输出异常
            e.printStackTrace();
        }
    }

}
