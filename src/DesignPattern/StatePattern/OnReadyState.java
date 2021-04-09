package DesignPattern.StatePattern;

public class OnReadyState implements State {
	private CandyMachine mCandyMachine;
	public OnReadyState(CandyMachine candyMachine) {
		this.mCandyMachine = candyMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("插入一个硬币，你可以扭动把手了");
        mCandyMachine.setState(mCandyMachine.mHasCoin);
	}

	@Override
	public void returnCoin() {
		System.out.println("没有硬币可以退");

	}

	@Override
	public void turnCrank() {
		System.out.println("你扭动了把手，但是你并没有投入硬币，所以无效操作");

	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printstate() {
		System.out.println("***糖果机待机准备状态，您可以投入硬币***");

	}

}
