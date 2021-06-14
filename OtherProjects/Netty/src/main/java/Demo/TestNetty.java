package Demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestNetty {
	// 创建server
	public void CreateServer() {
		// 创建单线程的selector
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		// 创建单线程的selector
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap boot = new ServerBootstrap();
			// 有两个事件循环体，一个用来accept请求，另外一个用来处理clinet的io
			boot.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.localAddress(8080)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// ch代表一个新的连接，通过add方式，为该连接创建一个EchoHandler对象。
							ch.pipeline().addLast(new EchoHandler());
						}
					});

			// start
			//// 绑定端口，netty中所有IO操作都是异步的，它会立即返回，但不能保证完成操作
			ChannelFuture future = boot.bind().sync();
			// 等待绑定完成。
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
