package NIOStudy.Future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureDemo {

	public static void main(String[] args) {
			//创建线程池
			ExecutorService exec=Executors.newCachedThreadPool();
			//线程池提交继承了Callable接口的任务，这样可以通过future方式直接获取返回值
			Future<Result> fu = exec.submit(new TaskWithResult());
			
			try {
				//future.get方式获取线程任务执行结果
				Result result =fu.get(11*1000,TimeUnit.MILLISECONDS);
				System.out.print("线程执行结果:{"+result.Value+ ":"+ result.Msg+"}");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}

	}

}
