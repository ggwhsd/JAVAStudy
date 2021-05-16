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
 * future��ʹ�÷�������C++11�е�future�������ƣ����ڷ����ȡ�߳�ִ�з����ķ���ֵ
 * */
public class TaskWithResult implements Callable<Result> {
	
	public Result call() throws Exception {
		int i = 10;
		while(i>0)
		{
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + "ִ��1��");
			i--;
		}
		
		return new Result(1,"No Error") ;
	}
}






