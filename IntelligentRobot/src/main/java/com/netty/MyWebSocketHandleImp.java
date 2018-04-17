package com.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**初始化连接时候加载各个组件(如加解码)
 * Created by liucong on 2018/4/14.
 */
public class MyWebSocketHandleImp extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(new HttpServerCodec());//Http解码
//        ch.pipeline().addLast(new HttpRequestDecoder());// new HttpResponseEncoder()
//        ch.pipeline().addLast(new HttpResponseEncoder());// new HttpResponseEncoder(

        ch.pipeline().addLast(new HttpObjectAggregator(65536));//多个消息转换成单个FullHttpRequest
//        ch.pipeline().addLast(new HttpContentCompressor());

        ch.pipeline().addLast(new ChunkedWriteHandler());
        ch.pipeline().addLast(new WebSocketHandle());
    }
}

