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
			ServerSocketChannel server =  ServerSocketChannel.open();
			server.configureBlocking(false);
			server.bind(new InetSocketAddress("127.0.0.1", port));
			selector = Selector.open();
			server.register(selector, SelectionKey.OP_ACCEPT);
			logger1.info("[ϵͳ��Ϣ��ʾ]NIO��������ʼ����ϣ������˿�" + port);
			while(true)
			{
				try 
				{
					selector.select(1000); //�������ó�ʱʱ�䣬��ֹ��������
					 Set<SelectionKey> selectionKeys = selector.selectedKeys();
					 Iterator<SelectionKey> selectionKeyIte = selectionKeys.iterator();
					 while(selectionKeyIte.hasNext()){
						  SelectionKey selectionKey = selectionKeyIte.next();
						  selectionKeyIte.remove();
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
		  if(selectionKey.isAcceptable()){
			  try {
				  server = (ServerSocketChannel) selectionKey.channel();
				  channel = server.accept();
				  channel.configureBlocking(false);
				  channel.register(selector, SelectionKey.OP_READ);
			  }
			  catch (IOException e) 
			  {
				  e.printStackTrace();
			  }
		  }
		  else if(selectionKey.isReadable())
		  { //��ȡͨ�����󣬷�����潫ͨ���ڵ����ݶ��뻺���� 
			  channel = (SocketChannel) selectionKey.channel(); 
			  receiveBuffer.clear(); 
			  count = channel.read(receiveBuffer); //����������Ŀͻ������ݲ�Ϊ�� 
			  if(count>0)
			  { 
				  receiveText = new String(receiveBuffer.array(),0,count); 
				  logger1.info("[ϵͳ��Ϣ��ʾ]����������["+receiveText+"]new connect"); }
			  else
			  { 
				  logger1.info("[ϵͳ��Ϣ��ʾ]someone disconnect"); //��⵽�ͻ��˹رգ�������ߣ���ɾ����selectionKey�����¼��������һֱ�յ����selectionKey�Ķ��� 
			  selectionKey.cancel(); 
			  }
			} 
	}
	
	public static void testPath()
	{
		Path path = Paths.get(".\\log\\nio.txt");
		Path path2 = path.normalize();
		logger1.info(path);
		logger1.info(path2);
	}
	public static void main(String[] args) {
		//useNIO.testByteBuffer();
		//useNIO.testSelector();
		useNIO.testPath();
	}

}
