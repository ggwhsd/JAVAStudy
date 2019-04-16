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
        JLabel jl = new JLabel("这是一个JFrame窗体，旁边是一个图片");
        //URL url = ImageIconDemo.class.getResource("2.jpg");        // 获得图片所在URL
        URL url = new URL("2.jpg");        // 获得图片所在URL
        Icon icon = new ImageIcon(url);        // 实例化Icon对象
        jl.setIcon(icon);        // 为标签设置图片
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setOpaque(true);        // 设置标签为不透明状态
        
        Container container = getContentPane();
        container.add(jl);
        
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 350);
    }
    
    public static void main(String[] args) {
        new ImageIconDemo();
    }

}