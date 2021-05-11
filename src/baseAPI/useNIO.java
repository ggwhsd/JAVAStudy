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
		
		RandomAccessFile f; //随机读写文件，比如在最后添加数据，用于断点下载文件。
		try {
			//创建文件流
			f = new RandomAccessFile(".\\log\\nio.txt","rw");
			//从文件流中获取channel，以便通过channel方式操作文件
			FileChannel channel = f.getChannel();
			//创建Buffer，分配1024个字节
			ByteBuffer buf = ByteBuffer.allocate(1024); 
			//从channel中读取数据，并写入到buf中。此时position为写入的数据个数，limit为最大容量-1
			int bytes = channel.read(buf);
			while(bytes !=-1)
			{
				//切换buffer状态，从写入状态变为读取状态，此时limit设置为position，而limit再设置为0
				buf.flip();
				logger1.info("position:"+buf.position()+" limit:"+buf.limit());
				//读状态下使用，标记当前position的位置，实际上就是保存position，用于切换为写状态之后继续写入，调用reset。
				buf.mark();
				//是否还有数据没有读
				while(buf.hasRemaining())
				{
					logger1.info((char)buf.get());
					//每次读取之后，position都会+1
					logger1.info("position:"+buf.position()+" limit:"+buf.limit());
				}
				//position又回到mark时候的位置。
				buf.reset();
				logger1.info("after reset position:"+buf.position()+" limit:"+buf.limit());
				//将所有未读的数据拷贝到Buffer起始处。然后将position设到最后一个未读元素正后面。limit属性依然像clear()方法一样，设置成capacity。现在Buffer准备好写数据了，但是不会覆盖未读的数据。
				buf.compact();
				logger1.info("after compact position:"+buf.position()+" limit:"+buf.limit());
				//position将被设回0，limit被设置成 capacity的值。换句话说，Buffer 被清空了。Buffer中的数据并未清除，只是这些标记告诉我们可以从哪里开始往Buffer里写数据。意味着不再有任何标记会告诉你哪些数据被读过，哪些还没有。
				//这个clear，实际上只是标记了一下，内存中数据还在。
				buf.clear();
				logger1.info("after clear position:"+buf.position()+" limit:"+buf.limit());
				bytes = channel.read(buf);
			}
			//关闭文件流
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
			//创建一个ServerSocketChannel
			ServerSocketChannel server =  ServerSocketChannel.open();
			//配置为非阻塞
			server.configureBlocking(false);
			//绑定监听端口
			server.bind(new InetSocketAddress("127.0.0.1", port));
			//创建Selector
			selector = Selector.open();
			//将ServerSocketChannel注册到Selector上，注册选项为接收新连接
			server.register(selector, SelectionKey.OP_ACCEPT);
			logger1.info("[系统消息提示]NIO服务器初始化完毕，监听端口" + port);
			while(true)
			{
				try 
				{
					//select函数会根据所有注册的channel对应的注册选项进行处理；
					//若设定了超时时间，则超时后会直接返回，否则阻塞直到有至少一个channel发生了相关的事件
					selector.select(1000); //可以设置超时时间，防止进程阻塞
					//获取有事件发生的注册选项
					 Set<SelectionKey> selectionKeys = selector.selectedKeys();
					 //遍历这些选项，
					 Iterator<SelectionKey> selectionKeyIte = selectionKeys.iterator();
					 while(selectionKeyIte.hasNext()){
						 //获取一个注册选项
						  SelectionKey selectionKey = selectionKeyIte.next();
						  //删除最近一次获取选项，以便重新进入select()之前清空所有处理过的channel
						  selectionKeyIte.remove();
						  //处理对应channel的业务逻辑，通过selectionKey可以获取对应的channel
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
		  //若selectKey为新连接
		  if(selectionKey.isAcceptable()){
			  try {
				  //获取对应的监听ServerSocketChannel
				  server = (ServerSocketChannel) selectionKey.channel();
				  //接收该ServerSocketChannel上新连接，并赋值给本地channel变量
				  channel = server.accept();
				  //配置该新channel为非阻塞
				  channel.configureBlocking(false);
				  //将该新channel注册到selector中，注册事件为读数据，也就是说，当有数据到来时，该channel为可读。
				  channel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT);
				  
			  }
			  catch (IOException e) 
			  {
				  e.printStackTrace();
			  }
		  }
		  //若selectKey为有新的数据到来
		  else if(selectionKey.isReadable())
		  { //获取通道对象，方便后面将通道内的数据读入缓冲区 
			  channel = (SocketChannel) selectionKey.channel(); 
			  receiveBuffer.clear(); 
			  count = channel.read(receiveBuffer); //如果读出来的客户端数据不为空 
			  if(count>0)
			  { 
				  receiveText = new String(receiveBuffer.array(),0,count); 
				  logger1.info("[系统消息提示]"+channel.getRemoteAddress().toString() +" 接收数据["+receiveText+"]"); 
				  ByteBuffer buf = ByteBuffer.allocate(1024); 
				  buf.put("sendEcho".getBytes());
				  buf.flip();
				  channel.write(buf);
				  logger1.info("[系统消息提示]"+channel.getRemoteAddress().toString() +" 发送数据[sendEcho]"); 
		
				  }
			  else
			  { 
				  logger1.info("[系统消息提示]"+channel.getRemoteAddress().toString() +"someone disconnect"); //检测到客户端关闭（玩家下线），删除该selectionKey监听事件，否则会一直收到这个selectionKey的动作 
				  //在Selector中取消该对channel注册，后续Selector不会对该channel有任务处理
				  selectionKey.cancel(); 
			  }
			}
		  else if(selectionKey.isWritable())
		  {
			  channel = (SocketChannel) selectionKey.channel(); 
			  //logger1.info("[系统消息提示]"+channel.getRemoteAddress().toString() +"someone disconnect"); //检测到客户端关闭（玩家下线），删除该selectionKey监听事件，否则会一直收到这个selectionKey的动作 
			   
		  }
		  else if(selectionKey.isConnectable())
		  {
			  channel = (SocketChannel) selectionKey.channel(); 

			  logger1.info("[系统消息提示]"+channel.getRemoteAddress().toString() +" 发送数据[isConnectable]"); 
		  }
	}
	

	public static void main(String[] args) {
		//useNIO.testByteBuffer();
		useNIO.testSelector();
		
	}

}
