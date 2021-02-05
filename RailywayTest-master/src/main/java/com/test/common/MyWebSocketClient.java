package com.test.common;

import java.net.URI;

//import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class MyWebSocketClient extends WebSocketClient {

    Logger logger = Logger.getLogger(MyWebSocketClient.class);

    public MyWebSocketClient(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
// TODO Auto-generated method stub
        logger.info("------ MyWebSocket onOpen ------");
    }

    @Override
    public void onClose(int arg0, String arg1, boolean arg2) {
// TODO Auto-generated method stub
        logger.info("------ MyWebSocket onClose ------");
    }

    @Override
    public void onError(Exception arg0) {
// TODO Auto-generated method stub
        logger.info("------ MyWebSocket onError ------");
    }

    //接收到消息的回调方法
    @Override
    public void onMessage(String arg0) {
// TODO Auto-generated method stub
        logger.info("-------- 接收到服务端数据： \n" + arg0 + "\n");
    }
}