package baseAPI;

public class useMath {

	public static void main(String[] args) {
		System.out.println("平方根："+Math.sqrt(9.0));
		System.out.println("两数谁大："+Math.max(100.0, 101.0));
		System.out.println("两数谁小："+Math.min(100.0, 101.0));
		System.out.println("2的3次方："+Math.pow(2, 3));
		System.out.println("四舍五入："+Math.round(9.4));
		System.out.println("9.4向小取整floor："+Math.floor(9.4));
		System.out.println("9.4向大取整ceil："+Math.ceil(9.4));
		System.out.println("-9.4向小取整floor："+Math.floor(-9.4));
		System.out.println("-9.4向大取整ceil："+Math.ceil(-9.4));
	}

}
