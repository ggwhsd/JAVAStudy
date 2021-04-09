package DesignPattern.StatePattern;

//CandyMachine就如同上下文，所有数据都在这里。状态是基于上下文环境进行转变。
//所有逻辑都在状态中调用
public class CandyMachine {
	//默认为protect，同一个package可以访问。
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
            System.out.println("正在出糖果");
        }

    }

    public int getCount() {
        return count;
    }

    public void printstate() {
        state.printstate();
    }
}
