package com.netty;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**存储整个netty的全局配置
 * Created by liucong on 2018/4/2.
 */
public class NettyConfig {
    /*存储每一个客户端接入进来的channel
     */
    public static ChannelGroup group=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
