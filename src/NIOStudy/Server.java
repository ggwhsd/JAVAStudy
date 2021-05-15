package NIOStudy;

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

public class Server {
	public void start() throws IOException
	{
		Selector selector = Selector.open();
		ServerSocketChannel serverSocketChannel = createNIOServerSocketChannel();
		System.out.println("start nio server and bind port 28888");
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		int ready = selector.select();
		while (ready > 0) {
			//System.out.println("ready channel count " + ready);
			Set<SelectionKey> selectionKeySet = selector.selectedKeys();
			for (Iterator<SelectionKey> iterator = selectionKeySet.iterator(); iterator.hasNext(); ) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    //System.out.println("acceptable");
                    acceptHandler(selectionKey);
                } else if (selectionKey.isReadable()) {
                    //System.out.println("readable");
                    try {
                    	readHandler(selectionKey);
                    }
                    catch(IOException err)
                    {
                    	System.out.println(err.getMessage());
                    	SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    	socketChannel.close();
                    }
                }
                iterator.remove();
            }
			ready = selector.select();
		} 
	}

	private ServerSocketChannel createNIOServerSocketChannel() throws IOException {
		
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		System.out.println(ip);
       // serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 28888));
		serverSocketChannel.bind(new InetSocketAddress(ip, 28888));
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
	private void readHandler(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        int num = socketChannel.read(byteBuffer);
        if(num == -1){ // 连接已断开
            System.out.println("client "+socketChannel.getLocalAddress() + " disconnection");
            System.out.println((double)count/1024/1024+"MB");
            selectionKey.cancel();
            socketChannel.close();
            return;
        }
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()) {
        	byteBuffer.get();
        	count++;
        }
    }
	private long  count=0 ;
	public String ip = "";
	public static void main(String[] args) throws IOException{
		
		Server server = new Server();
		server.ip= args[0];
		server.start();
	}
}
