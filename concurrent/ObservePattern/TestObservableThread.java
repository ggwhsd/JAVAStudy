package ObservePattern;

import java.util.concurrent.TimeUnit;

public class TestObservableThread {

	/*public static void main(String[] args) {
		Observable observableThread = new ObservableThread<>(() ->
		{
			try
			{
				TimeUnit.SECONDS.sleep(10);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(" finished done.");
			return  null;
		});
		observableThread.start();
	}*/
	
	public static void main(String[] args) {
		final TaskLifecycle<String> lifecycle = new TaskLifecycle.EmptyLifecycle<String>()
		{
			public void onFinish(Thread thread, String result)
			{
				System.out.println("the result is "+ result);
			}
		};
		
		Observable observableThread = new ObservableThread<>(lifecycle, () -> {
			try
			{
				TimeUnit.SECONDS.sleep(10);
				
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(" finished done.");
			return "Hello Observer";
			
		});
	}

}
