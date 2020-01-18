package designpattern.statepattern.prototype;

public class ConcreteStateB implements State {
    public Context context;

    public ConcreteStateB(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {

    }
}
