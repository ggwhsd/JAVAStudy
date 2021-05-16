package NIOStudy.Future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureDemo {

	public static void main(String[] args) {
			//�����̳߳�
			ExecutorService exec=Executors.newCachedThreadPool();
			//�̳߳��ύ�̳���Callable�ӿڵ�������������ͨ��future��ʽֱ�ӻ�ȡ����ֵ
			Future<Result> fu = exec.submit(new TaskWithResult());
			
			try {
				//future.get��ʽ��ȡ�߳�����ִ�н��
				Result result =fu.get(11*1000,TimeUnit.MILLISECONDS);
				System.out.print("�߳�ִ�н��:{"+result.Value+ ":"+ result.Msg+"}");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			} catch (TimeoutException e) {
				e.printStackTrace();
			}

	}

}
