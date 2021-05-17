package NIOStudy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServerNoSelect {
	//多线程
	private ThreadPoolExecutor eventHandlerPool = new ThreadPoolExecutor(10, 50, 2, 
			TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(200), new ThreadPoolExecutor.CallerRunsPolicy());
	
	public void start() throws IOException
	{
		Selector selector = Selector.open();
		ServerSocketChannel serverSocketChannel = createNIOServerSocketChannel();
		System.out.println("start nio No select read server and bind port 28888");
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		int ready = selector.select();
		while (ready > 0) {
			
			Set<SelectionKey> selectionKeySet = selector.selectedKeys();
			for (Iterator<SelectionKey> iterator = selectionKeySet.iterator(); iterator.hasNext(); ) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    acceptHandler(selectionKey);
                } 
                
                iterator.remove(); //用完需要删除，下次select时会重新添入新的触发key
            }
			ready = selector.select();
		} 
	}

	private ServerSocketChannel createNIOServerSocketChannel() throws IOException {
		
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		System.out.println(ip);
      
		serverSocketChannel.bind(new InetSocketAddress(ip, 28888));
		serverSocketChannel.configureBlocking(false);
        return serverSocketChannel;
	}
	//接收新的连接处理
	private void acceptHandler(SelectionKey selectionKey) throws IOException {

        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);

        eventHandlerPool.submit(new Runnable() {
            @Override
            public void run() {
            	try {
					readThread(socketChannel);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
            }
        });
        
        System.out.println("accept client connection " + socketChannel.getLocalAddress());
    }
	//每个线程处理一个socketChannel,采用轮询方式，直到socket释放
	private void readThread(SocketChannel socketchannel) throws IOException 
	{
	    long  count=0 ;
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		while(true)
		{
			int num = socketchannel.read(byteBuffer);
			if(num == -1){ // 连接已断开
	            System.out.println("client "+ socketchannel.getRemoteAddress() + " disconnection");
	            System.out.println((double)count/1024/1024+"MB");
	            socketchannel.close();
	            break;
	        }
	        byteBuffer.flip();
	        while (byteBuffer.hasRemaining()) {
	        	byteBuffer.get();
	        	count++;
	        }
	        byteBuffer.clear();
		}
	}
	
	

	public String ip = "";
	public static void main(String[] args) throws IOException{
		
		ServerNoSelect server = new ServerNoSelect();
		server.ip= args[0];
		server.start();
	}
}
