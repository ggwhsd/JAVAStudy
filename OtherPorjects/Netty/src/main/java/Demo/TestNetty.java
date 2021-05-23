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
	// ����server
	public void CreateServer() {
		// �������̵߳�selector
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		// �������̵߳�selector
		EventLoopGroup workerGroup = new NioEventLoopGroup();

		try {
			ServerBootstrap boot = new ServerBootstrap();
			// �������¼�ѭ���壬һ������accept��������һ����������clinet��io
			boot.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.localAddress(8080)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// ch����һ���µ����ӣ�ͨ��add��ʽ��Ϊ�����Ӵ���һ��EchoHandler����
							ch.pipeline().addLast(new EchoHandler());
						}
					});

			// start
			//// �󶨶˿ڣ�netty������IO���������첽�ģ������������أ������ܱ�֤��ɲ���
			ChannelFuture future = boot.bind().sync();
			// �ȴ�����ɡ�
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
