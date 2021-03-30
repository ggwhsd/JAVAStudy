import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;


//��Ҫ����
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
		open=new JButton("ѡ��ctp��־�ļ�");
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
		jfc.setCurrentDirectory(new File("C:\\Users\\gugw\\Desktop\\�½��ļ���"));
		jfc.showDialog(new JLabel(), "ѡ��");
		File file=jfc.getSelectedFile();
		if(file == null) 
			return;
		if(file.isDirectory()){
			System.out.println("�ļ���:"+file.getAbsolutePath());
		}else if(file.isFile()){
			System.out.println("�ļ�:"+file.getAbsolutePath());
			System.out.println("�ļ�2:"+file.getPath());
			System.out.println("�ļ�3:"+file.getAbsoluteFile());
			System.out.println("�ļ�3:"+file.getParent());	
		}
		selectedFile = file.getAbsolutePath();
		selectedPath = file.getParent();
		
		Date date=new Date(); 
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddhhmmss"); 
		Analysis an = new Analysis();
		an.Deal(selectedFile, selectedPath+ File.separatorChar+df.format(date)+"out.txt");
		open.setText("�ļ���"+selectedPath+ File.separatorChar+df.format(date)+"out.txt");

	}

}
