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


public class useNIO {

	private static Logger logger1 = Logger.getLogger(useNIO.class);
	public static void testByteBuffer()
	{
		
		RandomAccessFile f;
		try {
			//创建文件流
			f = new RandomAccessFile(".\\log\\nio.txt","rw");
			//从文件流中获取channel
			FileChannel channel = f.getChannel();
			//分配1024个字节
			ByteBuffer buf = ByteBuffer.allocate(1024); 
			int bytes = channel.read(buf);
			while(bytes !=-1)
			{
				//切换buffer状态，从写入状态变为读取
				buf.flip();
				logger1.info("position:"+buf.position()+" limit:"+buf.limit());
				//标记当前position的位置，用于之后的reset
				buf.mark();
				while(buf.hasRemaining())
				{
					logger1.info((char)buf.get());
					logger1.info("position:"+buf.position()+" limit:"+buf.limit());
				}
				//position又回到mark时候的位置。
				buf.reset();
				logger1.info("after reset position:"+buf.position()+" limit:"+buf.limit());
				//将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。limit属性依然像clear()方法一样，设置成capacity。现在Buffer准备好写数据了，但是不会覆盖未读的数据。
				buf.compact();
				logger1.info("after compact position:"+buf.position()+" limit:"+buf.limit());
				//position将被设回0，limit被设置成 capacity的值。换句话说，Buffer 被清空了。Buffer中的数据并未清除，只是这些标记告诉我们可以从哪里开始往Buffer里写数据。意味着不再有任何标记会告诉你哪些数据被读过，哪些还没有。
				buf.clear();
				logger1.info("after clear position:"+buf.position()+" limit:"+buf.limit());
				bytes = channel.read(buf);
			}
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
			logger1.info("[系统消息提示]NIO服务器初始化完毕，监听端口" + port);
			while(true)
			{
				try 
				{
					selector.select(1000); //可以设置超时时间，防止进程阻塞
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
		  { //获取通道对象，方便后面将通道内的数据读入缓冲区 
			  channel = (SocketChannel) selectionKey.channel(); 
			  receiveBuffer.clear(); 
			  count = channel.read(receiveBuffer); //如果读出来的客户端数据不为空 
			  if(count>0)
			  { 
				  receiveText = new String(receiveBuffer.array(),0,count); 
				  logger1.info("[系统消息提示]服务器发现["+receiveText+"]new connect"); }
			  else
			  { 
				  logger1.info("[系统消息提示]someone disconnect"); //检测到客户端关闭（玩家下线），删除该selectionKey监听事件，否则会一直收到这个selectionKey的动作 
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
