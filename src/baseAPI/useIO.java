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
	 * FileOutputStream是文件输出字节流，用于将数据通过字节流方式写入到文件中。
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
	 * FileWriter 文件字符输出流，用于将字符串通过字符方式写入到文件中
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
	 * 除了文件字节流、文件字符流，还可以将数据直接操作于内存，因此就有了内存字节流，内存中都是字节，没有字符。
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

/*
 * 管道字节流的使用，同一个进程类的不同线程或者模块通信的一种方式，比socket效率高，但是只能同一个进程内。
 */
class PipeSend implements Runnable
{
	private PipedOutputStream pos  = null;
	public PipeSend()
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

class PipeReceive implements Runnable
{
	private PipedInputStream pis = null;
	public PipeReceive() 
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
		PipeSend s = new PipeSend();
		PipeReceive r = new PipeReceive();
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

/*
 * BufferReader和BufferWriter，字符缓冲，用于缓冲读写，提高读写效率。
 * 只能接收和输出字符流。如果遇到字节流，想使用的话，可以使用InputStreamReader提供字节流到字符流的转换,以及OutputStreamWriter，这两个转换类内部都有缓冲。
 */
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
	public static void testBufferWriter2()
	{
		
		try {
			BufferedWriter out =new BufferedWriter(new OutputStreamWriter(System.out));
			out.write("123321123355555", 0, 10);
			 out.write("\r\n");
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
};

/*
 * Scan获取输入。不过，也可以使用BufferReader配合System.in。
 */
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

/*
 * 文件、目录的大小、复制等。
 */
class useFile
{
	public static void testPath()
	{
		Path path = Paths.get(".\\log\\nio.txt");
		Path path2 = path.normalize();
		System.out.println(path);
		System.out.println(path2);
	}
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

//复制目录，并且筛选原目录下后缀位java的文件，将其改为.jad
class CopyFiles {

	public void CopyDir(String str_srcDir, String str_dstDir) throws IOException
	{
		File srcDir = new File(str_srcDir);
		if((srcDir.exists()&&srcDir.isDirectory())==false)
		{
			System.out.println("目录不存在");
			return;
		}
		File[] files = srcDir.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				
				return name.endsWith("java");
			}});
		
		System.out.println("文件个数:"+files.length);
		File dstDir = new File(str_dstDir);
		if(dstDir.exists()==false)
			dstDir.mkdir();
		for(File f:files)
		{
			FileInputStream fis = new FileInputStream(f);
			String dstFileName = f.getName().replaceAll("\\.java$", ".jad");
			FileOutputStream fos = new FileOutputStream(new File(dstDir,dstFileName));
			try {
				copy(fis,fos);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			fis.close();
			fos.close();
		}
	}
	
	private void copy(InputStream ips, OutputStream ops) throws Exception
	{
		int len = 0;
		byte[] buf = new byte[1024];
		while((len = ips.read(buf))!=-1)
		{
			ops.write(buf,0,len);
		}
	}
	
	public static void testCopyFiles()
	{
		CopyFiles cf =new CopyFiles();
		try {
			cf.CopyDir("C:\\Users\\a\\eclipse-workspace\\test\\src\\a1", "C:\\Users\\a\\eclipse-workspace\\test\\src\\a2\\dstFiles");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}

class FileManager {
	String[] words = null;
	int pos = 0;
	public FileManager(String filename, char[] seperators) throws Exception
	{
		
		File f = new File(filename);
		InputStreamReader isr = new InputStreamReader(new FileInputStream(filename),"utf-8");
		BufferedReader fr = new BufferedReader(isr);
		
		System.out.println("file.length:"+f.length());
		char[] buf = new char[(int)f.length()];
		int len = fr.read(buf);
		String results = new String(buf,0,len);
		String regex = null;
		if(seperators.length>1)
		{
			regex = ""+seperators[0]+"|"+seperators[1];
		}
		else
		{
			regex = ""+seperators[0];
		}
		words = results.split(regex);		
	}
	
	public String nextWord()
	{
		if(pos == words.length)
		{
			return null;
		}
		return words[pos++];
	}
}
class FileMerge {
	public FileMerge()
	{
		
	}
	public void Merge(String filename,String seperators,
			String filename2,String seperators2,
			String filename3)
	{
		try {
			FileManager f1 = new FileManager(filename,seperators.toCharArray());
			FileManager f2 = new FileManager(filename2,seperators.toCharArray());
			//默认gbk编码写入
			FileWriter f3 = new FileWriter(filename3);
			//BufferWriter bw = new BufferWriter(new OutputStreamWriter(new FileOutputStream(filename3)),"utf-8")
			String aWord = null;
			String bWord = null;
			while((aWord=f1.nextWord())!=null)
			{
				f3.write(aWord+"\n");
				bWord = f2.nextWord();
				if(bWord!=null)
				{
					f3.write(bWord+"\n");
				}
			}
			
			while((bWord=f2.nextWord())!=null)
			{
				f3.write(bWord+"\n");
			}
			f3.close();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
	
	}
}

public class useIO {
	
	public static void UsePrintWriter()
	{
		String str = "printWriter";  //用法和BufferWriter差不多。
		//字符文本
		PrintWriter pw;
		try {
			pw = new PrintWriter("2.txt","utf-8");
			pw.write(str);
			pw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
	}
	
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
		//useFile.testFile();
		//useBuffer.testBufferWriter2();
		//CopyFiles.testCopyFiles();
		
	}
}





