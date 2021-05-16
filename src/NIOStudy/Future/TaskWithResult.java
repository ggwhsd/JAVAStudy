package NIOStudy.Future;

import java.util.concurrent.Callable;


class Result
{
	public Result(int value, String msg)
	{
		this.Value = value;
		this.Msg = msg;
	}
	public int Value;
	public String Msg;
}
/*
 * future的使用方法，和C++11中的future功能相似，用于方便获取线程执行方法的返回值
 * */
public class TaskWithResult implements Callable<Result> {
	
	public Result call() throws Exception {
		int i = 10;
		while(i>0)
		{
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "执行1次");
			i--;
		}
		
		return new Result(1,"No Error") ;
	}
}






