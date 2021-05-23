package Demo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

//�ͻ������ӷ�������ʱ��ʹ�ã���Ϊ�����ߣ���Ҫ���ܾ��Ǽ̳и����еķ���
public class EchoHandler extends ChannelInboundHandlerAdapter {
    @Override
	public void channelRegistered(ChannelHandlerContext ctx) {
        System.out.println("ע��:���ͻ�������ʱ�����Ȼᴥ��ע�ᣬ����һЩ��ʼ���Ĺ�����Ȼ�󼤻����ӣ��Ϳ����շ���Ϣ��");
    }
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
    	 System.out.println("����:�������ӣ��Ϳ����շ���Ϣ��");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	System.out.println("��ȡ��Ϣ");
        ByteBuf in = (ByteBuf) msg;
        System.out.println(in.toString(CharsetUtil.UTF_8));
        ctx.write(msg);

    }
 
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
    	System.out.println("��Ϣ��ȡ���");
        ctx.flush();
    }
    
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) {
    	System.out.println("�û��¼������û��������Զ����¼�������evt���ݣ��Ӷ����в�ͬ�Ĵ���");
    }
    
    @Override
    public void channelInactive(ChannelHandlerContext ctx)  {
        ctx.fireChannelInactive();
        System.out.println("�Ͽ�:���ͻ��˶Ͽ�ʱ���ȶϿ�����ע��");
    }
    
    /*
     * ������Ϣʱ�������ȱ�д�뵽socket�Ļ����������������д�С���ߵģ����޷�д�뻺�������򲻿�д����ʱ״̬�仯���Ȼ����������˿ռ��ˣ���ʱ״̬��Ϊ�ǡ�
     */
    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx){
    	System.out.println("��д״̬���Ϊ"+ctx.channel().isWritable());
    }
    
    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) {
    	System.out.println("ע��");
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    	System.out.println("�����쳣");
        cause.printStackTrace();
        ctx.close();
    }
}
