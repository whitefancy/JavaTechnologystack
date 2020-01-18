package designpattern.proxypattern;

/**
 * 糖果机 状态机
 */
public class GumballMachine {
    //定义每个状态的值
    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;
    //创建一个实例变量来持有状态变量
    int state = GumballMachine.SOLD_OUT;
    int count = 0;
    String location;

    public GumballMachine(int count, String location) {
        this.count = count;
        this.location = location;
    }

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = GumballMachine.NO_QUARTER;
        }
    }

    public String getLocation() {
        return location;
    }

    /**
     * 退币
     */
    public void ejectQuarter() {
        if (state == GumballMachine.HAS_QUARTER) {
            System.out.println("Quarter returned");
            state = GumballMachine.NO_QUARTER;
        } else if (state == GumballMachine.SOLD_OUT) {
            System.out.println("You can't eject,you haven't inserted a quarter yet");
        } else if (state == GumballMachine.SOLD) {
            System.out.println("Sorry, you already turned the crank");//已经转动曲柄，就不能退钱了。
        } else if (state == GumballMachine.NO_QUARTER) {
            System.out.println("You haven't insert a quarter");
        }
    }

    /**
     * 转动曲柄
     */
    public void turnCrank() {
        if (state == GumballMachine.HAS_QUARTER) {
            System.out.println("You turned...");
            state = GumballMachine.SOLD;
            dispense();
        } else if (state == GumballMachine.SOLD_OUT) {
            System.out.println("You turned, but there are no gumballs");
        } else if (state == GumballMachine.SOLD) {
            System.out.println("Turning twice doesn't get you another gumball!");
        } else if (state == GumballMachine.NO_QUARTER) {
            System.out.println("You turned but there's no quarter");
        }
    }

    /**
     * 发放糖果
     */
    private void dispense() {
        if (state == GumballMachine.HAS_QUARTER) {
            System.out.println("No gumball dispensed");
        } else if (state == GumballMachine.SOLD_OUT) {
            System.out.println("No gumball dispensed");
        } else if (state == GumballMachine.SOLD) {
            System.out.println("A gumball comes rolling out the slot");
            count = count - 1;
            if (count == 0) {
                System.out.println("Oops,out of gumballs!");
                state = GumballMachine.SOLD_OUT;
            } else {
                state = GumballMachine.NO_QUARTER;
            }
        } else if (state == GumballMachine.NO_QUARTER) {
            System.out.println("You need to pay first");
        }
    }

    public void insertQuarter() {
        if (state == GumballMachine.HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
        } else if (state == GumballMachine.SOLD_OUT) {
            System.out.println("You can't insert a quarter,the machine is sold out");
        } else if (state == GumballMachine.SOLD) {
            System.out.println("Please wait,we're already giving you a gumball");
        } else if (state == GumballMachine.NO_QUARTER) {
            state = GumballMachine.HAS_QUARTER;
            System.out.println("You inserted a quarter");
        }
    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
