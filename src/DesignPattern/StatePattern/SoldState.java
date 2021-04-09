package DesignPattern.StatePattern;

public class SoldState implements State {
	private CandyMachine mCandyMachine;
	public SoldState(CandyMachine candyMachine) {
		mCandyMachine = candyMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("请等待，我们正在为你分发糖果");

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
            if (mCandyMachine.getCount() > 0) {
                mCandyMachine.setState(mCandyMachine.mOnReadyState);
            } else {
            	System.out.println("oh，糖果卖光了");
                mCandyMachine.setState(mCandyMachine.mSoldOutState);
            }
        
	}

	@Override
	public void printstate() {
		System.out.println("***分发糖果状态***");

	}

}
