package NetworkStudy;
import java.net.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class TcpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Thread thread = new Thread(new Server());
		//thread.start();
		
		try {
		Socket socket = new Socket("192.168.12.177", 20003);
		//��Socket��Ӧ����������װ��BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		wr.write("11");
		
		
		String line = br.readLine();
		System.out.println("Get message form Server1: " + line);
		//�ر����������ر�Socket;
		br.close();
		socket.close();
		}
		catch(IOException e)
		{
			System.out.println("Get message form Server: " + e.getMessage());
		}
	}

}
