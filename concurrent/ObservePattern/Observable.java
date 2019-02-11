package ObservePattern;

public interface Observable {
	enum Cycle
	{
		STARTED,RUNNING,DONE,ERROR
	}
	Cycle getCycle();
	//为了屏蔽线程的其他的方法
	void start();
	//为了屏蔽线程的其他的方法，只有接口中定义的方法，在实现类中才能使用，因此只能使用start和interrupt方法
	void interrupt();
}


