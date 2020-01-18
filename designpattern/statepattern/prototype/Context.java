package designpattern.statepattern.prototype;

public class Context {
    State state;
    State stateA;
    State stateB;

    public Context() {
        stateA = new ConcreteStateA(this);
        stateB = new ConcreteStateB(this);
        state = stateA;
    }

    public void request() {
        state.handle();
    }
}
