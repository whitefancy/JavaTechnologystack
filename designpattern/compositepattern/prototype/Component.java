package designpattern.compositepattern.prototype;

/**
 * 组件：可以分为组合和叶节点
 */
public interface Component {
    void operation();

    void add(Component component);

    void remove(Component component);

    Component getChild(int index);
}
