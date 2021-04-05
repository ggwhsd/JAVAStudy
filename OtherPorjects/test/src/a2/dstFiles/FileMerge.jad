package a1;

import java.io.FileWriter;
import java.io.IOException;

public class FileMerge {
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
			//ƒ¨»œgbk±‡¬Î–¥»Î
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
