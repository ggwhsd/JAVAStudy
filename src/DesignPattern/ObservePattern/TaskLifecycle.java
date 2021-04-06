package DesignPattern.ObservePattern;

public interface TaskLifecycle <T>{
	void onStart(Thread thread);
	void OnRunning(Thread thread);
	void onFinish(Thread thread, T result);
	void onError(Thread thread, Exception e);

	//绌哄疄鐜�
class EmptyLifecycle<T> implements TaskLifecycle<T>
{
	@Override
	public void onStart(Thread thread)
	{
		
	}
	@Override
	public void OnRunning(Thread thread)
	{
		
	}
	@Override 
	public void onFinish(Thread thread, T result)
	{
		
	}
	@Override
	public void onError(Thread thread, Exception e)
	{
		
	}
	
	
	
}

}