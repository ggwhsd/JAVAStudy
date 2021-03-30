package Client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
	public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(),8888));

        String message = "today is sunday";
        ByteBuffer byteBuffer = ByteBuffer.allocate(message.getBytes().length);
        byteBuffer.put(message.getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        Thread.sleep(5000);
        socketChannel.close();
    }
}
