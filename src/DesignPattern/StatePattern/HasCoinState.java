package DesignPattern.StatePattern;

import java.util.Random;

/*
 * CandyMachine�н������Ѿ���Ӳ�ҵ�״̬��
 * ��ʱ���������Ӳ�ң�����ʾ�޷�����
 */
public class HasCoinState implements State {

	private CandyMachine mCandyMachine;
	
	public HasCoinState(CandyMachine candyMachine) {
		this.mCandyMachine = candyMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("�Ѿ�����Ӳ�ң��㲻���ٲ���Ӳ��");
	}

	@Override
	public void returnCoin() {
		System.out.println("Ӳ���˻�");
		//״̬�ı�
        mCandyMachine.setState(mCandyMachine.mOnReadyState);
	}

	@Override
	public void turnCrank() {
		System.out.println("Ť��������...");
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
		System.out.println("***�Ѿ�Ͷ��Ӳ��***");

	}

}
