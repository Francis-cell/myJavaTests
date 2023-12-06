package com.zmr;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/***
 * Client 端扩展的是 SimpleChannelInboundHandler，当 channelRead0 方法完成之后，你已经有了传入消息，并且已经处理完它了，
 * 当该方法返回时，SimpleChannelInboundHandler 负责释放指向保存该消息的 ByteBuf 的内存引用
 */

@ChannelHandler.Sharable
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    /** 在到服务器的连接已经建立之后将被调用 */
    @Override
    public  void channelActive(ChannelHandlerContext ctx) {
        // 当被通知 Channel 是活跃的时候，发送一条消息
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
    }

    /** 当从服务器接收到一条消息时被调用(ByteBuf: Netty 的字节容器) */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        // 记录已接收消息的转储
        System.out.println(
                "Client received: " + in.toString(CharsetUtil.UTF_8)
        );
    }

    /** 在处理过程中引发异常时被调用 */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
