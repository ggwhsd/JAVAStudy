package DesignPattern.StatePattern;

public class OnReadyState implements State {
	private CandyMachine mCandyMachine;
	public OnReadyState(CandyMachine candyMachine) {
		this.mCandyMachine = candyMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("����һ��Ӳ�ң������Ť��������");
        mCandyMachine.setState(mCandyMachine.mHasCoin);
	}

	@Override
	public void returnCoin() {
		System.out.println("û��Ӳ�ҿ�����");

	}

	@Override
	public void turnCrank() {
		System.out.println("��Ť���˰��֣������㲢û��Ͷ��Ӳ�ң�������Ч����");

	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub

	}

	@Override
	public void printstate() {
		System.out.println("***�ǹ�������׼��״̬��������Ͷ��Ӳ��***");

	}

}
