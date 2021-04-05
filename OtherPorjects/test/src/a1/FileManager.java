package a1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

public class FileManager {
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
