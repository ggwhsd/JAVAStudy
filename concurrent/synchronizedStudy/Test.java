package synchronizedStudy;

public class Test {

	public static void main(String[] args) {
		toy mytoy = new toy();
		boy myboy = new boy(mytoy);
		boy youboy = new boy(mytoy);
		myboy.setName("myboy");
		youboy.setName("youboy");
		myboy.start();
		youboy.start();
	}

}
