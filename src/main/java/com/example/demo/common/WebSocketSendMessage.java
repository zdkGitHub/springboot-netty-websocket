package com.example.demo.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * 服务端发送给客户端的消息
 * */
@Data
public class WebSocketSendMessage {
    private static ObjectMapper gson = new ObjectMapper();

    private String type;

    private String userId;

    private String content;

}
