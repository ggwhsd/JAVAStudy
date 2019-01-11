package baseAPI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;



class  useByteStream
{
	/**
	 * 使用文件输出字节流
	 * 
	 */
	public static void testFileOutputStream()
	{
		OutputStream out = null;
		try
		{
			File f = new File(".\\log\\test.txt");
			//out = new FileOutputStream(f);
			out = new FileOutputStream(f,true); //追加方式记录到文件
			String str = "Hello World!!!";
			byte b[] = str.getBytes();
			out.write(b);
			out.close();
		}
		catch(FileNotFoundException e)
		{
			
		}
		catch(IOException e)
		{
			
		}
	}
	
	/**
	 * 使用文件输入字节流
	 */
	public static void testFileInputStream()
	{
		InputStream out = null;
		try
		{
			File f = new File(".\\log\\test.txt");
			out = new FileInputStream(f); 
			String str = "Hello World!!!";
			byte b[] = new byte[1000];
			int len = out.read(b);
			System.out.println(new String(b,0, len) );
			out.close();
		}
		catch(FileNotFoundException e)
		{
			
		}
		catch(IOException e)
		{
			
		}
	}
};

class useCharStream
{
	/**
	 * 使用文件字符输出流
	 */
	public static void testFileWriter()
	{
		Writer w = null;
		try
		{
			File f = new File(".\\log\\test2.txt");
			w = new FileWriter(f,true); //追加方式
			w.write("hello world\r\n");
			w.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 使用文件字符输入流
	 */
	public static void testFileReader()
	{
		Reader w = null;
		try
		{
			File f = new File(".\\log\\test2.txt");
			w = new FileReader(f); 
			char c[] = new char[1024];
			w.read(c);
			System.out.println(c);
			w.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
};

class useMemoryStream
{
	/**
	 * 使用内存操作流,字节
	 */
	public static void testByteArray()
	{
		String str = "Hello world";
		ByteArrayInputStream bis = null;
		ByteArrayOutputStream bos = null;
		
		bis = new ByteArrayInputStream(str.getBytes());
		bos = new ByteArrayOutputStream();
		int temp =0;
		while((temp=bis.read())!=-1)
		{
			char c = (char)temp;
			bos.write(Character.toUpperCase(c));
		}
		String newStr = bos.toString();
		try
		{
			bis.close();
			bos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println(newStr);
	}
};

class Send implements Runnable
{
	private PipedOutputStream pos  = null;
	public Send()
	{
		this.pos = new PipedOutputStream();
	}
	public void run()
	{
		String str = "Hello world!!!";
		try
		{
			try
			{
				Thread.sleep(2000);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			this.pos.write(str.getBytes());
			System.out.println("thread:"+Thread.currentThread().getId()+",Send string:"+str);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		try
		{
			this.pos.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public PipedOutputStream getPos()
	{
		return this.pos;
	}
};

class Receive implements Runnable
{
	private PipedInputStream pis = null;
	public Receive() 
	{
		this.pis = new PipedInputStream();
	}
	public void run()
	{
		byte b[] = new byte[1024];
		int len =0;
		try
		{

			len = this.pis.read(b); //阻塞方式
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			pis.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("thread:"+Thread.currentThread().getId()+",receive:"+new String(b,0,len));
		
	}
	
	public PipedInputStream getPis()
	{
		return this.pis;
	}
};

class pipedTest
{
	public void pipedStream()
	{
		Send s = new Send();
		Receive r = new Receive();
		try {
			s.getPos().connect(r.getPis());
		}
		catch(IOException e)
		{

			e.printStackTrace();
		}
		
		new Thread(r).start();
	
		new Thread(s).start();
		
	}
};

class useBuffer
{
	public static void testBufferReader()
	{
		BufferedReader buf = null;
		//此处用到了字节流转字符流的类InputStreamReader，这是因为BufferedReader只能接收字符流
		buf = new BufferedReader(new InputStreamReader(System.in));
		String str =null;
		try
		{
			str = buf.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("输出的内容为："+str);
		
	}
	public static void testBufferWriter()
	{
		File f = new File(".\\log\\test2.txt");
		try {
			BufferedWriter out =new BufferedWriter(new FileWriter(f));
			out.write("123321123355555", 0, 10);
			 out.write("\r\n");
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
};


class useScan
{
	public static void testScan()
	{
		Scanner scan = new Scanner(System.in);
		//以回车作为输入的结束符号，否则默认是空格
		scan.useDelimiter("\r\n");
		if(scan.hasNextInt()==true) 
		{
			int str = scan.nextInt();
			System.out.println("int "+str);
		}
		else
		{
			String str = scan.next();
			System.out.println("string "+str);
		}
		
	}
};

class useFile
{
	public static void testFile()
	{
		
		File file = new File(".\\log\\nio.txt");
		boolean fileExists = file.exists();
		System.out.println("文件是否存在："+fileExists);
		long length = file.length();
		System.out.println("文件长度："+length);
		File file1 = new File(".\\log\\deletenio.txt");
	
	   try {
			Files.copy(file.toPath(), file1.toPath());
			 System.out.println("复制文件");
		} catch (IOException e) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		boolean success = file.renameTo(new File(".\\log\\newnio.txt"));
		System.out.println("改名："+length);
		
		
	    
	    boolean isDirectory = file.isDirectory();
	    System.out.println("是否为目录："+isDirectory);
	    
	  
	    success = file1.delete();
	    System.out.println("删除文件："+success);
	    
	    file = new File(".\\log");
	    String[] fileNames = file.list();
	    File[] files = file.listFiles();
	    for(int i=0 ;i< fileNames.length; i++)
	    {
	    	System.out.println("文件："+fileNames[i]);
	    }
	    for(int i=0 ;i< files.length; i++)
	    {
	    	System.out.println("文件："+files[i]+" 是否为目录"+files[i].isDirectory());
	    }
	   
	}
};

public class useIO {
	public static void main(String[] args) {
		//useByteStream.testFileOutputStream();
		//useByteStream.testFileInputStream();
		//useCharStream.testFileWriter();
		//useCharStream.testFileReader();
		//useMemoryStream.testByteArray();
		//pipedTest p = new pipedTest();p.pipedStream();
		//useBuffer.testBufferReader();
		//useScan.testScan();
		//useBuffer.testBufferWriter();
		useFile.testFile();
	}
}





