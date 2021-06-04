package ThreadLocalStudy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 场景1：
 * ThreadLocal 用作保存每个线程独享的对象，为每个线程都创建一个副本，
 * 这样每个线程都可以修改自己所拥有的副本, 
 * 而不会影响其他线程的副本，确保了线程安全。
 * 比如：这种场景通常用于保存线程不安全的工具类，典型的需要使用的类就是 SimpleDateFormat
 * 场景2：
 * ThreadLocal 用作每个线程内需要独立保存信息，以便供其他方法更方便地获取该信息的场景。
 * 每个线程获取到的信息可能都是不一样的，前面执行的方法保存了信息后，
 * 后续方法可以通过ThreadLocal 直接获取到，避免了传参，类似于全局变量的概念。每个线程自己独立的全局变量。
 * https://www.cnblogs.com/zz-ksw/p/12684877.html
 * */
public class appTest {
	static ThreadLocal<String> localNotThreadSafeVar = new ThreadLocal<>();
	static void print(String str) {
		System.out.println(str + " :" + localNotThreadSafeVar.get());
		localNotThreadSafeVar.remove();
	}
	
	//基本使用方式示例
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
	
	//常见场景
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
	
	//SimpleDateFormat非线程安全
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
