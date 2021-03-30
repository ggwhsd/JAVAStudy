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
		 
	        JSch jsch = new JSch(); // 创建JSch对象  
	        String userName = args[2];// 服务器地址  
	       // String userName = "root";// 用户名  
	       // String password = "dwzq951753";// 密码  
	        String password = args[3];// 密码  
	        String host = args[0];// 服务器地址  
	        if(args.length<4)
	        {
	        	System.out.println("lost argument ip ... example: ip cmd usename password");
	        	return;
	        }
	        int port = 22;// 端口号  
	        String cmd1 = args[1];// 要运行的命令  
	       
	        //String cmd2 = "pwd";
	        Session session = jsch.getSession(userName, host, port); // 根据用户名，主机ip，端口获取一个Session对象  
	        session.setPassword(password); // 设置密码  
	        Properties config = new Properties();  
	        config.put("StrictHostKeyChecking", "no");  
	        session.setConfig(config); // 为Session对象设置properties  
	        int timeout = 3000;  
	        session.setTimeout(timeout); // 设置timeout时间  
	        session.connect(); // 通过Session建立链接  
	        
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
	            System.out.println(buf);// 打印控制台输出  
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
