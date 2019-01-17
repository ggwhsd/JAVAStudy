package Thread_03;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
/*
 * ThreadGroup也可以设置为Deamon()为true，表示如果active的线程数量为0时，自动销毁ThreadGroup对象。
 * ThreadGroup也可以设置interrupt(),该方法表示会设置该group下的所有Thread的interrupte标志为true。
 */
public class ThreadGroupStudy {

	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("group1");
		
		//lambda表达式方式创建线程对象，java1.8的新特性
		Thread thread = new Thread(group,()->
		 {
			while(true)
			{
				try
				{
					TimeUnit.SECONDS.sleep(1);
					
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		},"thread"
		 );
		
		thread.setDaemon(true);
		thread.start();
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		Optional.of("active count ="+mainGroup.activeCount()).ifPresent(System.out::print);
		System.out.println("active group count ="+mainGroup.activeGroupCount());
		System.out.println("getMaxPriority="+mainGroup.getMaxPriority() 
		+"\ngetName ="+mainGroup.getName()
		+"\ngetParent="+mainGroup.getParent());
		mainGroup.list();
		System.out.println("---------------");
		System.out.println("parentOf ="+mainGroup.parentOf(mainGroup));
	}

}
