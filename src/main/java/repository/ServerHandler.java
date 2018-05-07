package repository;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import repository.config.ConfigReader;
import repository.queryhandlers.*;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ChannelHandlerContext currentCtx = ctx;
        System.out.println("Client query: " + msg);
        String[] clientQuery = msg.toString().split(ConfigReader.getSeparator());
        QueryHandler.exec(currentCtx, clientQuery);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("exceptionCaught in ServerHandler " + ctx);
        cause.printStackTrace();
        ctx.close();
    }
}
