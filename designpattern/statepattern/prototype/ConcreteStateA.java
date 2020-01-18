package designpattern.statepattern.prototype;

public class ConcreteStateA implements State {
    public Context context;

    public ConcreteStateA(Context context) {
        this.context = context;
    }

    @Override
    public void handle() {

    }
}
