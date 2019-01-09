package NetworkStudy;
import java.net.*;
import java.io.*;
public class Server implements Runnable {
	private ServerSocket serverSocket;
	public void run()
	{
		try {
		 serverSocket = new ServerSocket(20003);
	      serverSocket.setSoTimeout(10000);
		System.out.println("create running");
		}
		catch(Exception e)
		{}
		
		while(true)
	      {
	         try
	         {
	            System.out.println("�ȴ�Զ�����ӣ��˿ں�Ϊ��" + serverSocket.getLocalPort() + "...");
	            Socket server = serverSocket.accept();
	            System.out.println("Զ��������ַ��" + server.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(server.getInputStream());
	            System.out.println(in.readUTF());
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.writeUTF("лл�����ң�" + server.getLocalSocketAddress() + "\nGoodbye!");
	            server.close();
	         }catch(SocketTimeoutException s)
	         {
	            System.out.println("Socket timed out!");
	            break;
	         }catch(IOException e)
	         {
	            e.printStackTrace();
	            break;
	         }
	      }
	}
}
