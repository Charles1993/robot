package com.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by liucong on 2018/4/14.
 */
public class AppMain {
    public void run(final int port) throws InterruptedException{
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workGroup=new NioEventLoopGroup();
        try{
            ServerBootstrap b=new ServerBootstrap();//NIO启动辅助类
            b.group(bossGroup,workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new MyWebSocketHandleImp());
            ChannelFuture future = b.bind(port).sync();//绑定本地端口并同步等待完成，future是一个通道状态类
            future.channel().closeFuture().sync();

        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
            System.out.print("启动连接线程异常shutdown.......");
        }
    }

    public static void main(String[] args){
        AppMain server = new AppMain();
        try {
            server.run(8888);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
