package Swing;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
public class SwingJDialog  extends JDialog {
	 public SwingJDialog() {
	        super(new MyJFrame(), "����һ��JDialog����", true); // ʵ����һ��JDialog�����ָ���丸���塢���ڱ��������
	        Container container = this.getContentPane();
	        container.add(new JLabel("http://www.cnblogs.com/adamjwh/"));
	        this.setSize(500, 350);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingJDialog();
	}

	
}

//�����ⲿ�����ݰ����������������в�������
	class MyJFrame extends JFrame {
	 public MyJFrame() {
	     this.setVisible(true);
	     this.setSize(700, 500);
	     this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	     
	     Container container = this.getContentPane();
	     container.setLayout(null);
	     
	     JButton jb = new JButton("��������Ի���");        // ������ť
	     jb.setBounds(30, 30, 200, 50);        // ��ťλ�ü���С
	     jb.addActionListener(new ActionListener() {        // �����������ڼ�������¼�
	         @Override
	         public void actionPerformed(ActionEvent e) {
	             new SwingJDialog().setVisible(true);
	         }
	     });
	     container.add(jb);
	 }
	}
