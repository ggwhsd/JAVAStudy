package Swing;

import java.awt.Container;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ImageIconDemo extends JFrame {
    
    public ImageIconDemo() throws Exception {
        JLabel jl = new JLabel("����һ��JFrame���壬�Ա���һ��ͼƬ");
        //URL url = ImageIconDemo.class.getResource("2.jpg");        // ���ͼƬ����URL
        URL url = new URL("2.jpg");        // ���ͼƬ����URL
        Icon icon = new ImageIcon(url);        // ʵ����Icon����
        jl.setIcon(icon);        // Ϊ��ǩ����ͼƬ
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setOpaque(true);        // ���ñ�ǩΪ��͸��״̬
        
        Container container = getContentPane();
        container.add(jl);
        
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 350);
    }
    
    public static void main(String[] args) {
        try {
			new ImageIconDemo();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
