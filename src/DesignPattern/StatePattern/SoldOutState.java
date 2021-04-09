package DesignPattern.StatePattern;

public class SoldOutState implements State {
	private CandyMachine mCandyMachine;
	public SoldOutState(CandyMachine candyMachine) {
		mCandyMachine = candyMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("�ǹ������ǹ������ˣ��㲻��Ͷ��Ӳ��");

	}

	@Override
	public void returnCoin() {
		System.out.println("�޷��˻�Ӳ�ң���û��Ͷ��Ӳ��");
	}

	@Override
	public void turnCrank() {
		System.out.println("��Ť���˰��֣������ǹ���û����");

	}

	@Override
	public void dispense() {


	}

	@Override
	public void printstate() {
		System.out.println("***����״̬***");

	}

}
