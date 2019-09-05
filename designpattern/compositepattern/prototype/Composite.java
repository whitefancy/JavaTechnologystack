package designpattern.compositepattern.prototype;

public interface Composite extends Component {
    @Override
    void operation();

    @Override
    void add(Component component);

    @Override
    void remove(Component component);

    @Override
    Component getChild(int index);
}
