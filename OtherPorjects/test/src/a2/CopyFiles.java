package a2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
public class CopyFiles {

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
}
