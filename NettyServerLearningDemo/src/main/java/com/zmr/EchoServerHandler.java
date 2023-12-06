package com.zmr;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/***
 * Server 端扩展的是 ChannelInboundHandlerAdapter，消息处理完成之后，仍然需要将传入消息回送给发送者，
 * channelRead 方法是异步的，回送完消息之后可能还没有完成write()操作，在这个时间点不能释放消息
 */

// 标示一个Channel-Handler 可以被多个 Channel 安全地共享
@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // 将消息记录到控制台
        ByteBuf in = (ByteBuf) msg;
        System.out.println("Server recevied: " + in.toString(CharsetUtil.UTF_8));
        // 将接收到的消息写给发送者，而不冲刷出站消息
        ctx.write(in);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        // 将未决消息冲刷到远程节点了，并关闭该 channel
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        // 关闭该 channel
        ctx.close();
    }
}
