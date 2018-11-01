package ThreadPoolTest2;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Date;
import java.util.concurrent.*;

public class MyThreadFactoryB implements ThreadFactory{
	public Thread newThread(Runnable r){
		Thread newThread = new Thread(r);
		newThread.setName("my new name is "+ new Date());
		//自定义线程的默认异常处理
		newThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler(){
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("自定义处理异常启用："+ t.getName() + " "+ e.getMessage() );
				//e.printStackTrace();
			}
		});
		return newThread;
	}
}
