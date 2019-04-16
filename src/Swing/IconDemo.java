package Swing;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class IconDemo extends JFrame implements Icon {
	 private int width;        // ����ͼ��Ŀ�
	    private int height;        // ����ͼ��ĳ�
	    public IconDemo() {}        // �����޲ι��췽��
	    public IconDemo(int width, int height) {        // �����вι��췽��
	        this.width = width;
	        this.height = height;
	    }
	    @Override
	    public int getIconHeight() {        // ʵ��getIconHeight()����
	        return this.height;
	    }

	    @Override
	    public int getIconWidth() {            // ʵ��getIconWidth()����
	        return this.width;
	    }

	    @Override
	    public void paintIcon(Component arg0, Graphics arg1, int arg2, int arg3) {        // ʵ��paintIcon()����
	        arg1.fillOval(arg2, arg3, width, height);        // ����һ��Բ��
	    }
	    public void init() {    // ����һ����������ʵ�ֽ���
	        IconDemo iconDemo = new IconDemo(15, 15);        // ����ͼ��ĳ��Ϳ�
	        JLabel jb = new JLabel("icon����", iconDemo, SwingConstants.CENTER);    // ���ñ�ǩ�ϵ������ڱ�ǩ���м�
	        
	        Container container = getContentPane();
	        container.add(jb);
	        
	        this.setVisible(true);
	        this.setSize(500, 350);
	        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    }
	public static void main(String[] args) {
		new IconDemo().init();

	}

}
