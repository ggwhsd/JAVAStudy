package Demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

//客户端连接服务器端时候使用，作为开发者，主要功能就是继承该类中的方法
public class EchoHandler extends ChannelInboundHandlerAdapter {
    @Override
	public void channelRegistered(ChannelHandlerContext ctx) {
        System.out.println("注册:当客户端连接时，首先会触发注册，进行一些初始化的工作，然后激活连接，就可以收发消息了");
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
    	 System.out.println("激活:激活连接，就可以收发消息了");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	System.out.println("读取消息");
        ByteBuf in = (ByteBuf) msg;
        System.out.println(in.toString(CharsetUtil.UTF_8));
        ctx.write(msg);

    }
 
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
    	System.out.println("消息读取完成");
        ctx.flush();
    }
    
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
    	System.out.println("用户事件：由用户触发的自定义事件，根据evt数据，从而进行不同的处理。");
    }
    
    @Override
    public void channelInactive(ChannelHandlerContext ctx)  {
        ctx.fireChannelInactive();
        System.out.println("断开:当客户端断开时，先断开，再注销");
    }
    
    /*
     * 发送消息时，数据先被写入到socket的缓冲区。缓冲区是有大小上线的，若无法写入缓冲区，则不可写，此时状态变化。等缓冲区又有了空间了，此时状态变为是。
     */
    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx){
    	System.out.println("可写状态变更为"+ctx.channel().isWritable());
    }
    
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {
    	System.out.println("注销");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    	System.out.println("发生异常");
        cause.printStackTrace();
        ctx.close();
    }
}
