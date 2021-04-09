package DesignPattern.StatePattern;

import java.util.Random;

/*
 * CandyMachine中进行勒已经有硬币的状态，
 * 此时，如果插入硬币，将提示无法插入
 */
public class HasCoinState implements State {

	private CandyMachine mCandyMachine;
	
	public HasCoinState(CandyMachine candyMachine) {
		this.mCandyMachine = candyMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("已经存在硬币，你不能再插入硬币");
	}

	@Override
	public void returnCoin() {
		System.out.println("硬币退还");
		//状态改变
        mCandyMachine.setState(mCandyMachine.mOnReadyState);
	}

	@Override
	public void turnCrank() {
		System.out.println("扭动把手中...");
        Random ranwinner=new Random();
        int winner=ranwinner.nextInt(10);
        if(winner==0)
        {
            mCandyMachine.setState(mCandyMachine.mWinnerState);

        }else
        {
            mCandyMachine.setState(mCandyMachine.mSoldState);

        }

	}

	@Override
	public void dispense() {
		

	}

	@Override
	public void printstate() {
		System.out.println("***已经投入硬币***");

	}

}
