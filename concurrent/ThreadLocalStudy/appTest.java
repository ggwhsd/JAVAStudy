package ThreadLocalStudy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * ����1��
 * ThreadLocal ��������ÿ���̶߳���Ķ���Ϊÿ���̶߳�����һ��������
 * ����ÿ���̶߳������޸��Լ���ӵ�еĸ���, 
 * ������Ӱ�������̵߳ĸ�����ȷ�����̰߳�ȫ��
 * ���磺���ֳ���ͨ�����ڱ����̲߳���ȫ�Ĺ����࣬���͵���Ҫʹ�õ������ SimpleDateFormat
 * ����2��
 * ThreadLocal ����ÿ���߳�����Ҫ����������Ϣ���Ա㹩��������������ػ�ȡ����Ϣ�ĳ�����
 * ÿ���̻߳�ȡ������Ϣ���ܶ��ǲ�һ���ģ�ǰ��ִ�еķ�����������Ϣ��
 * ������������ͨ��ThreadLocal ֱ�ӻ�ȡ���������˴��Σ�������ȫ�ֱ����ĸ��ÿ���߳��Լ�������ȫ�ֱ�����
 * https://www.cnblogs.com/zz-ksw/p/12684877.html
 * */
public class appTest {
	static ThreadLocal<String> localNotThreadSafeVar = new ThreadLocal<>();
	static void print(String str) {
		System.out.println(str + " :" + localNotThreadSafeVar.get());
		localNotThreadSafeVar.remove();
	}
	
	//����ʹ�÷�ʽʾ��
	static void TestSimpleString()
	{
		Thread t1  = new Thread(new Runnable() {
			@Override
			 public void run() {
				localNotThreadSafeVar.set("localNotThreadSafeVar 1");
				print(""+Thread.currentThread().getId());
				System.out.println("after remove : " + localNotThreadSafeVar.get());
			}
		});
		Thread t2  = new Thread(new Runnable() {
			@Override
			public void run() {
				localNotThreadSafeVar.set("localNotThreadSafeVar 2");
				print(""+Thread.currentThread().getId());
				System.out.println("after remove : " + localNotThreadSafeVar.get());
			}
		});
		t1.start();
		t2.start();
	}
	
	//��������
	static void TestSimpleDateFormat()
	{
		for (int i = 0; i < 100000; i++) {
            int finalI = i;
            threadPool.submit(() -> {
                String data = new appTest().date(finalI);
                System.out.println(Thread.currentThread().getId()+data);
            });
        }
        threadPool.shutdown();
        
        
	}
	
	
	
	public static ExecutorService threadPool = Executors.newFixedThreadPool(16);
	
	//SimpleDateFormat���̰߳�ȫ
	public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("mm:ss"));

	private String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat dateFormat = dateFormatThreadLocal.get();
        return dateFormat.format(date);
    }

	
	public static void main(String[] args) {
		
		TestSimpleDateFormat();
	}

}
