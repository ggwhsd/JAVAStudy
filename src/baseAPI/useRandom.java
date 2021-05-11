package baseAPI;

import java.util.Random;

public class useRandom {

	public static void main(String[] args) {
	

		Random rd = new Random();//以当前时间作为随机种子生成器
		
		System.out.println(rd.nextInt(100));
		
		
	
	}

}
