package concurrent1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toy mytoy = new toy();
		boy myboy = new boy(mytoy);
		boy youboy = new boy(mytoy);
		myboy.setName("myboy");
		youboy.setName("youboy");
		myboy.start();
		youboy.start();
	}

}
