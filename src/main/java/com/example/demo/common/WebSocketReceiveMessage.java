package com.example.demo.common;

import lombok.Data;

/**
 * 服务端接收来自客户端的消息
 * */
@Data
public class WebSocketReceiveMessage {

    private String type;

    private String userId;

    private String content;
}
