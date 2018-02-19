package repository;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.Channel;
import repository.config.ConfigReader;
import repository.queryhandlers.*;

public class ServerHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) {
        Channel currentChannel = ctx.channel();
        System.out.println("Client send: " + msg);
        String[] clientQuery = msg.toString().split(ConfigReader.getSeparator());
        QueryHandler.exec(currentChannel, clientQuery);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        System.out.println("exceptionCaught in ServerHandler " + ctx);
        cause.printStackTrace();
        ctx.close();
    }
}
