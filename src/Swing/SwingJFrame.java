package Swing;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

class JFrameDemo2 extends JFrame
{
	public void init() {
        this.setVisible(true);        // 可视化
        this.setSize(500, 350);        // 大小
        this.setTitle("标题");        // 标题
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        // 关闭方式
        
        JLabel jl = new JLabel("展示一个窗体");        // 创建一个JLabel标签
        jl.setHorizontalAlignment(SwingConstants.CENTER);        // 使标签文字居中
        
        Container container = this.getContentPane();        // 获取一个容器
        container.add(jl);        // 将标签添加至容器
        container.setBackground(Color.darkGray);        // 设置容器背景颜色
    }
};
	

public class SwingJFrame {
	public void CreateJFrame() {
        JFrame jf = new JFrame("欢迎");        // 实例化一个JFrame对象
        jf.setVisible(true);        // 设置窗体可视
        jf.setSize(500, 350);        // 设置窗体大小
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        // 设置窗体关闭方式
    }
	
	
	public static void main(String[] args) {
		
		new SwingJFrame().CreateJFrame();        // 调用CreateJFrame()方法
		//new JFrameDemo2().init();
	}

}
