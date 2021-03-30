package futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class TaskWithResult implements Callable<String>
{
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		return "OK";
	}
}


public class CallableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService exec=Executors.newCachedThreadPool();
		Future<String> fu = exec.submit(new TaskWithResult());
		try {
			String result =fu.get(11*1000,TimeUnit.MILLISECONDS);
			System.out.print("½á¹û:"+result);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
