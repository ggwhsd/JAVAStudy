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
        this.setVisible(true);        // ���ӻ�
        this.setSize(500, 350);        // ��С
        this.setTitle("����");        // ����
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        // �رշ�ʽ
        
        JLabel jl = new JLabel("չʾһ������");        // ����һ��JLabel��ǩ
        jl.setHorizontalAlignment(SwingConstants.CENTER);        // ʹ��ǩ���־���
        
        Container container = this.getContentPane();        // ��ȡһ������
        container.add(jl);        // ����ǩ���������
        container.setBackground(Color.darkGray);        // ��������������ɫ
    }
};
	

public class SwingJFrame {
	public void CreateJFrame() {
        JFrame jf = new JFrame("��ӭ");        // ʵ����һ��JFrame����
        jf.setVisible(true);        // ���ô������
        jf.setSize(500, 350);        // ���ô����С
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);        // ���ô���رշ�ʽ
    }
	
	
	public static void main(String[] args) {
		
		new SwingJFrame().CreateJFrame();        // ����CreateJFrame()����
		//new JFrameDemo2().init();
	}

}
