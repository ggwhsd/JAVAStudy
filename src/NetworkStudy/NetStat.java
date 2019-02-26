package NetworkStudy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
public class NetStat {
	public boolean isConnect(){
    	boolean connect = false;
    	Runtime runtime = Runtime.getRuntime();
    	Process process;
		try {
			process = runtime.exec("ping " + "www.baidu.com");
			InputStream is = process.getInputStream(); 
	        InputStreamReader isr = new InputStreamReader(is); 
	        BufferedReader br = new BufferedReader(isr); 
	        String line = null; 
	        StringBuffer sb = new StringBuffer(); 
	        while ((line = br.readLine()) != null) { 
	            sb.append(line+"\r\n"); 
	        } 
	        System.out.println("return:"+sb);  
	        is.close(); 
	        isr.close(); 
	        br.close(); 
 
	        if (null != sb && !sb.toString().equals("")) { 
	            String logString = ""; 
	            if (sb.toString().indexOf("TTL") > 0) { 
	                // ���糩ͨ  
	            	connect = true;
	            } else { 
	                // ���粻��ͨ  
	            	connect = false;
	            } 
	        } 
		} catch (IOException e) {
			e.printStackTrace();
		} 
        return connect;
    }

	public boolean isExistTCPLink()
	{
		
		boolean connect = false;
    	Runtime runtime = Runtime.getRuntime();
    	Process process;
		try {
			process = runtime.exec("netstat -anp | grep 20010 | grep -v LISTEN | wc -l");
			InputStream is = process.getInputStream(); 
	        InputStreamReader isr = new InputStreamReader(is); 
	        BufferedReader br = new BufferedReader(isr); 
	        String line = null; 
	        while (true) { 
	        	line = br.readLine();
	        	if(line!=null && line!="")
	            	break; 	
	        } 
	        int num = Integer.parseInt(line);
	        System.out.println("return:"+num);  
	        is.close(); 
	        isr.close(); 
	        br.close(); 
 
	      if(num>0)
	    	  connect = true;
	      else
	    	  connect=false;
		} catch (IOException e) {
			e.printStackTrace();
		} 
        return connect;
	}
	
	public static void main(String[] args) {
		NetStat netState = new NetStat();
		//System.out.println(netState.isConnect());
		System.out.println(netState.isExistTCPLink());
	}

}
