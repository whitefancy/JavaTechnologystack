package designpattern.singletonpattern;

public class ChocolateBoiler {
    private static ChocolateBoiler uniqueBoiler;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    /**
     * 全局访问点 需要实例，向类查询，它会返回单个实例
     * 延迟实例化对资源敏感的对象很重要
     *
     * @return
     */
    public static synchronized ChocolateBoiler getInstance() {
        if (ChocolateBoiler.uniqueBoiler == null) {
            ChocolateBoiler.uniqueBoiler = new ChocolateBoiler();
        }
        return ChocolateBoiler.uniqueBoiler;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            //todo 在锅炉里填满巧克力和牛奶的混合物
        }
    }

    public void boil() {
        if (!isEmpty() && isBoiled()) {
            //todo 排出煮沸的巧克力和牛奶
            empty = true;
        }
    }

    public void drain() {
        if (!isBoiled() && !isBoiled()) {
            //todo 将炉内物煮沸
            boiled = true;
        }
    }

    private boolean isEmpty() {
        return empty;
    }

    private boolean isBoiled() {
        return boiled;
    }
}
