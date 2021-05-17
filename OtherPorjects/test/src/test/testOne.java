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


