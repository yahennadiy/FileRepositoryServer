package repository;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

class ServerContainer {
    private int port;

    ServerContainer(int port) {
        this.port = port;
    }

    void start() {
        EventLoopGroup producer = new NioEventLoopGroup();
        EventLoopGroup consumer = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap()
                    .group(producer, consumer)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) {
//                            System.out.println(channel.config().getSendBufferSize());
//                            System.out.println(channel.config().getReceiveBufferSize());
//                            channel.config().setSendBufferSize(10240);
                            ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast("handler", new ServerHandler());
                        }
                    });
//            bootstrap.childOption(ChannelOption.SO_SNDBUF, 10240);
//            bootstrap.childOption(ChannelOption.SO_RCVBUF, 10240);
            System.out.println("Server started, port: " + port);
            bootstrap.bind(port).sync().channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.shutdownGracefully();
            consumer.shutdownGracefully();
        }
    }
}
