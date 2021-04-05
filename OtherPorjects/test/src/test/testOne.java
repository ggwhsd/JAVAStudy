package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import a1.FileMerge;
import a2.CopyFiles;
import a3.TrimString;
import a4.BTree;
import a5.SortName;
import a6.DiGui;
import a7.RMB;




public class testOne {
	private int j;
	private Lock lock = new ReentrantLock();

	private static void UseFileOutputStream()
	{
		String str = "中国人";
		//二进制
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("1.txt");
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		try {
			fos.write(str.getBytes("UTF-8"));
			fos.close();
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private static void UseFileInputStream()
	{
		FileInputStream fr;
		try {
			fr = new FileInputStream("1.txt");
			byte[] buf = new byte[1024];
			int len = 0;
			try {
				len = fr.read(buf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String myStr=null;
			try {
				myStr = new String(buf,0,len,"UTF-8");
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
			System.out.print(myStr);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	private static void UsePrintWriter()
	{
		String str = "中国人";
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
	
	private static void UseFileReader()
	{
		//字符文本
		FileReader fr;
		try {
			fr = new FileReader("1.txt");
			char[] buf = new char[1024];
			int len = 0;
			try {
				len = fr.read(buf);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			String myStr = new String(buf, 0, len);
			System.out.println(myStr);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private static void UseBufferedReader()
	{
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream("1.txt"),"UTF-8")
					);
			String myStr=null;
			try {
				myStr = br.readLine();
				br.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			System.out.println(myStr);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
	private static void test_a2()
	{
		CopyFiles cf =new CopyFiles();
		try {
			cf.CopyDir("C:\\Users\\a\\eclipse-workspace\\test\\src\\a1", "C:\\Users\\a\\eclipse-workspace\\test\\src\\a2\\dstFiles");
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	
	private static void test_a3()
	{
		TrimString ts =new TrimString();
		try {
			ts.GetStringByN("中国China", 6);
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
	}
	
	private static void test_a4()
	{
		BTree bt = new BTree();
		System.out.println();
		bt.PreList();
		System.out.println();
		bt.MiddList();
		System.out.println();
		bt.AfterList();
		System.out.println();
	}
	
	private static void test_a5()
	{
		SortName sn =new SortName();
		try {
			sn.Deal();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	private static void test_a6()
	{
		DiGui dg = new DiGui();
		dg.calcShow();
	}
	private static void test_a7()
	{
RMB rmb = new RMB();
System.out.println(rmb.ConvertToString(123456));
	}
	
	public static void main(String[] args) {
		test_a7();
	}
	
	
	
	

}


