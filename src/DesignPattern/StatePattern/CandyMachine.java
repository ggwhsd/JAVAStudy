package DesignPattern.StatePattern;

//CandyMachine����ͬ�����ģ��������ݶ������״̬�ǻ��������Ļ�������ת�䡣
//�����߼�����״̬�е���
public class CandyMachine {
	//Ĭ��Ϊprotect��ͬһ��package���Է��ʡ�
	State mSoldOutState;
    State mOnReadyState;
    State mHasCoin;
    State mSoldState;
    State mWinnerState;
    
    private State state;
    //the number of cander in the CandyMachine
    private int count = 0;
    public CandyMachine(int count) {
    	this.count = count;
    	mSoldOutState = new SoldOutState(this);
    	mOnReadyState = new OnReadyState(this);
        mHasCoin = new HasCoinState(this);
        mSoldState = new SoldState(this);
        mWinnerState = new WinnerState(this);
        if (count > 0) {
            state = mOnReadyState;
        } else {
            state = mSoldOutState;
        }
    }
	public void setState(State mOnReadyState2) {
		state = mOnReadyState2;
		
	}
	public void insertCoin() {
        state.insertCoin();
    }

    public void returnCoin() {
        state.returnCoin();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void releaseCandy() {

        if (count > 0) {
            count = count - 1;
            System.out.println("���ڳ��ǹ�");
        }

    }

    public int getCount() {
        return count;
    }

    public void printstate() {
        state.printstate();
    }
}
