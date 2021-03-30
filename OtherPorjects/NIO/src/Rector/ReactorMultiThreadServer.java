package Rector;
import java.io.IOException;
import java.net.InetAddress;
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

public class ReactorMultiThreadServer {
	private ThreadPoolExecutor eventHandlerPool = 
			new ThreadPoolExecutor(10, 50, 2, 
					TimeUnit.MINUTES, 
					new ArrayBlockingQueue<Runnable>(200), 
					new ThreadPoolExecutor.CallerRunsPolicy());
	private void start() throws IOException {
		
		Selector selector = Selector.open();
		ServerSocketChannel serverSocketChannel = createNIOServerSocketChannel();
		System.out.println("start nio server and bind port 8888");
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		selector.select();
		for (;;) {
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            for (Iterator<SelectionKey> iterator = selectionKeySet.iterator(); iterator.hasNext(); ) {
                final SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    System.out.println("acceptable");
                    acceptHandler(selectionKey); // 单线程同步处理接收就绪
                } else if (selectionKey.isReadable()) {
                    System.out.println("readable");
                    eventHandlerPool.submit(new Runnable() {
                        @Override
                        public void run() {
                            readHandler(selectionKey);
                        }
                    });
                }
                iterator.remove();
            }
            selector.select();
        }
	}
	
	private ServerSocketChannel createNIOServerSocketChannel() throws IOException {
		
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		
		System.out.println("bind ip addr:"+InetAddress.getLocalHost().getHostAddress());
        serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
        serverSocketChannel.configureBlocking(false);
        return serverSocketChannel;
	}
	//接收新的连接处理
	private void acceptHandler(SelectionKey selectionKey) throws IOException {
        Selector selector = selectionKey.selector();
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("accept client connection " + socketChannel.getLocalAddress());
    }
	//接收数据处理
	private void readHandler(SelectionKey selectionKey) 
	{
		
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        try{

	        int num = socketChannel.read(byteBuffer);
	        if(num == -1){ // 连接已断开
	            System.out.println("client "+socketChannel.getLocalAddress() + " disconnection");
	            socketChannel.close();
	            return;
	        }
	        byteBuffer.flip();
	        while (byteBuffer.hasRemaining()) {
	            byte b = byteBuffer.get();
	            System.out.println((char) b);
	        }
        }catch(Exception err)
        {
        	System.out.println("由于连接关闭导致并发线程读取异常");
        	
        }
    }
	
	public static void main(String[] args) throws IOException {
		ReactorMultiThreadServer  server = new ReactorMultiThreadServer();
        server.start();
    }
	
	
}
