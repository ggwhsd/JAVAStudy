package Thread_03;

/*
 * volatile的关键字
 * synchronized的关键字
 */
public class violateTest {

	public static void main(String[] args) {
		violateStudy[] mythreadArray = new violateStudy[100];
		for (int i=0; i<100; i++)
		{
			mythreadArray[i] = new violateStudy();
		}
		for (int i=0; i< 100; i++)
		{
			mythreadArray[i].start();
		}
		
		PrintString p = new PrintString();
		Thread print = new Thread(p,"testTurnDownThread");
		print.start();
		try {
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			
		}
		p.setContinuePrint(false);
		
		
	}
}
