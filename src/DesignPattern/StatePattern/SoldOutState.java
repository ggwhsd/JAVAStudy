package DesignPattern.StatePattern;

public class SoldOutState implements State {
	private CandyMachine mCandyMachine;
	public SoldOutState(CandyMachine candyMachine) {
		mCandyMachine = candyMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("糖果机的糖果卖光了，你不能投入硬币");

	}

	@Override
	public void returnCoin() {
		System.out.println("无法退还硬币，你没有投过硬币");
	}

	@Override
	public void turnCrank() {
		System.out.println("你扭动了把手，但是糖果机没有糖");

	}

	@Override
	public void dispense() {


	}

	@Override
	public void printstate() {
		System.out.println("***售罄状态***");

	}

}
