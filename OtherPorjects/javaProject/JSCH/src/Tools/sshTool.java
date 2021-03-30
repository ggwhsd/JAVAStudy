package Tools;
import java.io.BufferedReader;  
import java.io.InputStream;  
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.nio.charset.Charset;  
import java.util.Properties;  
  
import com.jcraft.jsch.ChannelExec;  
import com.jcraft.jsch.JSch;  
import com.jcraft.jsch.Session;  

public class sshTool {
	 public static void main(String[] args) throws Exception {  
		 
	        JSch jsch = new JSch(); // ����JSch����  
	        String userName = args[2];// ��������ַ  
	       // String userName = "root";// �û���  
	       // String password = "dwzq951753";// ����  
	        String password = args[3];// ����  
	        String host = args[0];// ��������ַ  
	        if(args.length<4)
	        {
	        	System.out.println("lost argument ip ... example: ip cmd usename password");
	        	return;
	        }
	        int port = 22;// �˿ں�  
	        String cmd1 = args[1];// Ҫ���е�����  
	       
	        //String cmd2 = "pwd";
	        Session session = jsch.getSession(userName, host, port); // �����û���������ip���˿ڻ�ȡһ��Session����  
	        session.setPassword(password); // ��������  
	        Properties config = new Properties();  
	        config.put("StrictHostKeyChecking", "no");  
	        session.setConfig(config); // ΪSession��������properties  
	        int timeout = 3000;  
	        session.setTimeout(timeout); // ����timeoutʱ��  
	        session.connect(); // ͨ��Session��������  
	        
	        exec(cmd1,session);
	        Thread.sleep(1000);
	        //exec(cmd2,session);
	        session.disconnect();
	       
	    }  
	 
	 public static void exec(String cmd, Session session) 
	 {
		 ChannelExec channelExec = null;
		 BufferedReader reader = null;
		 InputStream in = null;
		 try {
			channelExec =(ChannelExec) session.openChannel("exec");  
	        channelExec.setCommand(cmd);  
	        channelExec.setInputStream(null);  
	        channelExec.setErrStream(System.err);  
	        channelExec.connect();  
	        in = channelExec.getInputStream();  
	        reader = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));  
	        String buf = null;  
	        StringBuffer sb = new StringBuffer();  
	        while ((buf = reader.readLine()) != null) {  
	            sb.append(buf);  
	            System.out.println(buf);// ��ӡ����̨���  
	        }  
	        reader.close();
	        
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 
		 }
		 finally {
		   
	      channelExec.disconnect();
		 }
	        
	 }
	
		
}
