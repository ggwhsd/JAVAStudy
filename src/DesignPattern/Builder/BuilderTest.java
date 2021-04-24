package DesignPattern.Builder;

public class BuilderTest {

	/*
	 * ��������ҪĿ���Ƿ���Ƶ���������Ӷ������һ������ܼ򵥣���Ҫʹ�ý����ߣ����һ�����߶�������������������ܶ࣬���һ��и��ַ�֧�жϣ����ָ��ӵĶ��󣬲���Ҫʹ��ʹ�ô�����ģʽ���ͼ򻯡�
	   �������ʱ�����ɹ���ģʽ����һ����
	   ���ģʽ����������һ�����˼ά��ʵ�ַ�ʽ�������ĳ�ַ�ʽ��ֻҪ�������˼ά���ɡ�
	 */
	public static void main(String[] args) {
		ComputerBuilder cb = new CustomComputerBuilder();
		
		ComputerProduct cp =cb.cpu("h")
		.mem("32g")
		.gpu(true)
		.hardDisk("1T")
		.Build();
		System.out.println(cp.toString());
		
		
		cb = new HighComputerBuilder();
		cp = cb.Build();
		System.out.println(cp.toString());

	}

}
