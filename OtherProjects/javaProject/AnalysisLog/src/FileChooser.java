import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;


//主要窗口
public class FileChooser extends JFrame implements ActionListener{
	
	private JButton open=null;
	private String selectedFile;
	private String selectedPath;
	
	public String getSelectedPath() {
		return selectedPath;
	}
	
	public String getSelectedFile()
	{
		return selectedFile;
	}

	public FileChooser(){
		open=new JButton("选择ctp日志文件");
		this.add(open);
		this.setBounds(400, 200, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		open.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JFileChooser jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_ONLY );
		jfc.setCurrentDirectory(new File("C:\\Users\\gugw\\Desktop\\新建文件夹"));
		jfc.showDialog(new JLabel(), "选择");
		File file=jfc.getSelectedFile();
		if(file == null) 
			return;
		if(file.isDirectory()){
			System.out.println("文件夹:"+file.getAbsolutePath());
		}else if(file.isFile()){
			System.out.println("文件:"+file.getAbsolutePath());
			System.out.println("文件2:"+file.getPath());
			System.out.println("文件3:"+file.getAbsoluteFile());
			System.out.println("文件3:"+file.getParent());	
		}
		selectedFile = file.getAbsolutePath();
		selectedPath = file.getParent();
		
		Date date=new Date(); 
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss"); 
		Analysis an = new Analysis();
		an.Deal(selectedFile, selectedPath+ File.separatorChar+df.format(date)+"out.txt");
		open.setText("文件在"+selectedPath+ File.separatorChar+df.format(date)+"out.txt");

	}

}
