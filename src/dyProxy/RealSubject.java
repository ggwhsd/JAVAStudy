package dyProxy;

public class RealSubject implements Subject {

		public void request()
		{
			System.out.println("form realsubject");
		}
		public void show()
		{
			System.out.println("show realsubject");
		}
}
