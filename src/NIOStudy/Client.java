package NIOStudy;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;


public class Client {
	public static void main(String[] args) throws IOException, InterruptedException {
		//´´½¨SocketChannel
		SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("192.168.1.6",28888));

        String message = "today is sunday and we say hello to you ,do you know i miss you.";
        message +=message;
        message +=message;
        message +=message;
        message +=message;
        message +=message;
        message +=message;
        message +=message;
        ByteBuffer byteBuffer = ByteBuffer.allocate(message.getBytes().length);
        byteBuffer.put(message.getBytes());
        int i = 100000;
        System.out.println("send start "+(new Date()).toString());
        while(i>0)
        {
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        i--;
        }

        System.out.println("send end "+(new Date()).toString());
        Thread.sleep(5000);
        socketChannel.close();
    }
}
