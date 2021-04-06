package DesignPattern.ObservePattern;

import java.util.concurrent.TimeUnit;

//一个异步任务的实例，通过观察者模式来通知任务状态。
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
		//任务的生命周期接口
		final TaskLifecycle<String> lifecycle = new TaskLifecycle.EmptyLifecycle<String>()
		{
			@Override
			public void onStart(Thread thread)
			{
				System.out.println("task is start " );
			}
			@Override
			public void onFinish(Thread thread, String result)
			{
				System.out.println("the result is "+ result);
			}
		};
		Task<String> task1 = ()->{ try
			{
				TimeUnit.SECONDS.sleep(10);
				
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(" finished done.");
			return "Hello Observer";
		};
		Observable observableThread = new ObservableThread<>(lifecycle, task1);
		observableThread.start();
	}

}
