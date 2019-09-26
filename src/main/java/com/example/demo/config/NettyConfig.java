package com.example.demo.config;


import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NettyConfig {
    //存储每一个客户端接入进来的对象
    public static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //用于点对点
    public static Map<String, Channel> channelMap = new ConcurrentHashMap<>();
}
