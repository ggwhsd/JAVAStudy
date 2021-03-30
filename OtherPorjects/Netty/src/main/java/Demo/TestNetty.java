package Demo;



import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestNetty {
	public void CreateServer()
	{
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
	    EventLoopGroup workerGroup = new NioEventLoopGroup();
	 
	    try {
	        ServerBootstrap boot = new ServerBootstrap();
	        boot.group(bossGroup, workerGroup)
	            .channel(NioServerSocketChannel.class)
	            .localAddress(8080)
	            .childHandler(new ChannelInitializer<SocketChannel>() {
	                @Override
	                protected void initChannel(SocketChannel ch) throws Exception {
	                    ch.pipeline().addLast(new EchoHandler());
	                }
	            });
	 
	        // start
	        ChannelFuture future = boot.bind().sync();
	        future.channel().closeFuture().sync();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // shutdown
	        bossGroup.shutdownGracefully();
	        workerGroup.shutdownGracefully();
	    }
	}
}
