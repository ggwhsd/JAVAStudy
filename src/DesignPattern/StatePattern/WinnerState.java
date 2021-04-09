package DesignPattern.StatePattern;

public class WinnerState implements State {
	private CandyMachine mCandyMachine;
	public WinnerState(CandyMachine candyMachine) {
		this.mCandyMachine = candyMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("请勿投入硬币，我们正在提供糖果");

	}

	@Override
	public void returnCoin() {
		System.out.println("当前没有未使用的硬币，无法退出硬币");

	}

	@Override
	public void turnCrank() {
		System.out.println("我们正在分发糖果，重复扭动无效");

	}

	@Override
	public void dispense() {
		mCandyMachine.releaseCandy();
        if (mCandyMachine.getCount() == 0) {
            mCandyMachine.setState(mCandyMachine.mSoldOutState);
        } else {
            System.out.println("你是幸运儿，再送你一颗糖");
            mCandyMachine.releaseCandy();
            if (mCandyMachine.getCount() > 0) {
                mCandyMachine.setState(mCandyMachine.mOnReadyState);
            } else {
                System.out.println("oh，糖果卖光了");
                mCandyMachine.setState(mCandyMachine.mSoldOutState);
            }
        }

	}

	@Override
	public void printstate() {
		System.out.println("***幸运儿状态***");

	}

}
