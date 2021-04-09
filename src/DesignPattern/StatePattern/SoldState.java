package DesignPattern.StatePattern;

public class SoldState implements State {
	private CandyMachine mCandyMachine;
	public SoldState(CandyMachine candyMachine) {
		mCandyMachine = candyMachine;
	}

	@Override
	public void insertCoin() {
		System.out.println("��ȴ�����������Ϊ��ַ��ǹ�");

	}

	@Override
	public void returnCoin() {
		System.out.println("��ǰû��δʹ�õ�Ӳ�ң��޷��˳�Ӳ��");

	}

	@Override
	public void turnCrank() {
		System.out.println("�������ڷַ��ǹ����ظ�Ť����Ч");

	}

	@Override
	public void dispense() {

            mCandyMachine.releaseCandy();
            if (mCandyMachine.getCount() > 0) {
                mCandyMachine.setState(mCandyMachine.mOnReadyState);
            } else {
            	System.out.println("oh���ǹ�������");
                mCandyMachine.setState(mCandyMachine.mSoldOutState);
            }
        
	}

	@Override
	public void printstate() {
		System.out.println("***�ַ��ǹ�״̬***");

	}

}
