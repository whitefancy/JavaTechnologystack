package designpattern.statepattern.winnermachine;

/**
 * 糖果机 状态机
 */
public class GumballMachine {
    //定义每个状态的值
    private State soldOutState;
    private State soldState;
    private State noQuarterState;
    private State hasQuarterState;
    private State winnerState;
    //创建一个实例变量来持有状态变量
    private State state = soldOutState;
    private int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        hasQuarterState = new HasQuarterState(this);
        noQuarterState = new NoQuarterState(this);
        winnerState = new WinnerState(this);
        count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "count=" + count +
                '}';
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the solt...");
        if (count != 0) {
            count = count - 1;
        }
    }

    void refill(int numberGumballs) {
        count = numberGumballs + count;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }
}
