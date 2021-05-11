package baseAPI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.Logger;
import java.util.*;

//nio = new io
public class useNIO {

	private static Logger logger1 = Logger.getLogger(useNIO.class);
	public static void testByteBuffer()
	{
		
		RandomAccessFile f; //�����д�ļ������������������ݣ����ڶϵ������ļ���
		try {
			//�����ļ���
			f = new RandomAccessFile(".\\log\\nio.txt","rw");
			//���ļ����л�ȡchannel���Ա�ͨ��channel��ʽ�����ļ�
			FileChannel channel = f.getChannel();
			//����Buffer������1024���ֽ�
			ByteBuffer buf = ByteBuffer.allocate(1024); 
			//��channel�ж�ȡ���ݣ���д�뵽buf�С���ʱpositionΪд������ݸ�����limitΪ�������-1
			int bytes = channel.read(buf);
			while(bytes !=-1)
			{
				//�л�buffer״̬����д��״̬��Ϊ��ȡ״̬����ʱlimit����Ϊposition����limit������Ϊ0
				buf.flip();
				logger1.info("position:"+buf.position()+" limit:"+buf.limit());
				//��״̬��ʹ�ã���ǵ�ǰposition��λ�ã�ʵ���Ͼ��Ǳ���position�������л�Ϊд״̬֮�����д�룬����reset��
				buf.mark();
				//�Ƿ�������û�ж�
				while(buf.hasRemaining())
				{
					logger1.info((char)buf.get());
					//ÿ�ζ�ȡ֮��position����+1
					logger1.info("position:"+buf.position()+" limit:"+buf.limit());
				}
				//position�ֻص�markʱ���λ�á�
				buf.reset();
				logger1.info("after reset position:"+buf.position()+" limit:"+buf.limit());
				//������δ�������ݿ�����Buffer��ʼ����Ȼ��position�赽���һ��δ��Ԫ�������档limit������Ȼ��clear()����һ�������ó�capacity������Buffer׼����д�����ˣ����ǲ��Ḳ��δ�������ݡ�
				buf.compact();
				logger1.info("after compact position:"+buf.position()+" limit:"+buf.limit());
				//position�������0��limit�����ó� capacity��ֵ�����仰˵��Buffer ������ˡ�Buffer�е����ݲ�δ�����ֻ����Щ��Ǹ������ǿ��Դ����￪ʼ��Buffer��д���ݡ���ζ�Ų������κα�ǻ��������Щ���ݱ���������Щ��û�С�
				//���clear��ʵ����ֻ�Ǳ����һ�£��ڴ������ݻ��ڡ�
				buf.clear();
				logger1.info("after clear position:"+buf.position()+" limit:"+buf.limit());
				bytes = channel.read(buf);
			}
			//�ر��ļ���
			f.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
	private static ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
	public static void testSelector()
	{
		int port = 33333;
		
		Selector selector;
		try
		{
			//����һ��ServerSocketChannel
			ServerSocketChannel server =  ServerSocketChannel.open();
			//����Ϊ������
			server.configureBlocking(false);
			//�󶨼����˿�
			server.bind(new InetSocketAddress("127.0.0.1", port));
			//����Selector
			selector = Selector.open();
			//��ServerSocketChannelע�ᵽSelector�ϣ�ע��ѡ��Ϊ����������
			server.register(selector, SelectionKey.OP_ACCEPT);
			logger1.info("[ϵͳ��Ϣ��ʾ]NIO��������ʼ����ϣ������˿�" + port);
			while(true)
			{
				try 
				{
					//select�������������ע���channel��Ӧ��ע��ѡ����д���
					//���趨�˳�ʱʱ�䣬��ʱ���ֱ�ӷ��أ���������ֱ��������һ��channel��������ص��¼�
					selector.select(1000); //�������ó�ʱʱ�䣬��ֹ��������
					//��ȡ���¼�������ע��ѡ��
					 Set<SelectionKey> selectionKeys = selector.selectedKeys();
					 //������Щѡ�
					 Iterator<SelectionKey> selectionKeyIte = selectionKeys.iterator();
					 while(selectionKeyIte.hasNext()){
						 //��ȡһ��ע��ѡ��
						  SelectionKey selectionKey = selectionKeyIte.next();
						  //ɾ�����һ�λ�ȡѡ��Ա����½���select()֮ǰ������д������channel
						  selectionKeyIte.remove();
						  //�����Ӧchannel��ҵ���߼���ͨ��selectionKey���Ի�ȡ��Ӧ��channel
						  DoSomeThing(selectionKey,selector);
					 }
				}
				catch(Exception e)
				{
					
				}
				
			}
		}
		catch
		(Exception e)
		{
			
		}
		
		
		
	}
	public static void DoSomeThing(SelectionKey selectionKey,Selector selector)throws IOException
	{
		 ServerSocketChannel server = null;
		 SocketChannel channel = null;
		 String receiveText;
		  int count;
		  //��selectKeyΪ������
		  if(selectionKey.isAcceptable()){
			  try {
				  //��ȡ��Ӧ�ļ���ServerSocketChannel
				  server = (ServerSocketChannel) selectionKey.channel();
				  //���ո�ServerSocketChannel�������ӣ�����ֵ������channel����
				  channel = server.accept();
				  //���ø���channelΪ������
				  channel.configureBlocking(false);
				  //������channelע�ᵽselector�У�ע���¼�Ϊ�����ݣ�Ҳ����˵���������ݵ���ʱ����channelΪ�ɶ���
				  channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);
				  
			  }
			  catch (IOException e) 
			  {
				  e.printStackTrace();
			  }
		  }
		  //��selectKeyΪ���µ����ݵ���
		  else if(selectionKey.isReadable())
		  { //��ȡͨ�����󣬷�����潫ͨ���ڵ����ݶ��뻺���� 
			  channel = (SocketChannel) selectionKey.channel(); 
			  receiveBuffer.clear(); 
			  count = channel.read(receiveBuffer); //����������Ŀͻ������ݲ�Ϊ�� 
			  if(count>0)
			  { 
				  receiveText = new String(receiveBuffer.array(),0,count); 
				  logger1.info("[ϵͳ��Ϣ��ʾ]"+channel.getRemoteAddress().toString() +" ��������["+receiveText+"]"); 
				  ByteBuffer buf = ByteBuffer.allocate(1024); 
				  buf.put("sendEcho".getBytes());
				  buf.flip();
				  channel.write(buf);
				  logger1.info("[ϵͳ��Ϣ��ʾ]"+channel.getRemoteAddress().toString() +" ��������[sendEcho]"); 
		
				  }
			  else
			  { 
				  logger1.info("[ϵͳ��Ϣ��ʾ]"+channel.getRemoteAddress().toString() +"someone disconnect"); //��⵽�ͻ��˹رգ�������ߣ���ɾ����selectionKey�����¼��������һֱ�յ����selectionKey�Ķ��� 
				  //��Selector��ȡ���ö�channelע�ᣬ����Selector����Ը�channel��������
				  selectionKey.cancel(); 
			  }
			}
		  else if(selectionKey.isWritable())
		  {
			  channel = (SocketChannel) selectionKey.channel(); 
			  //logger1.info("[ϵͳ��Ϣ��ʾ]"+channel.getRemoteAddress().toString() +"someone disconnect"); //��⵽�ͻ��˹رգ�������ߣ���ɾ����selectionKey�����¼��������һֱ�յ����selectionKey�Ķ��� 
			   
		  }
		  else if(selectionKey.isConnectable())
		  {
			  channel = (SocketChannel) selectionKey.channel(); 

			  logger1.info("[ϵͳ��Ϣ��ʾ]"+channel.getRemoteAddress().toString() +" ��������[isConnectable]"); 
		  }
	}
	

	public static void main(String[] args) {
		//useNIO.testByteBuffer();
		useNIO.testSelector();
		
	}

}
