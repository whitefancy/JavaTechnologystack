package designpattern.factorypattern.pizzashop;

/**
 * 新对象只做一件事，就是帮客户创建比萨
 * 这样orderPizza就不需要知道希腊比萨或者蛤蜊比萨，只关心得到一个比萨，开始装盘出售
 * <p>
 * 利用静态方法定义一个工厂，常被称为静态工厂，
 * 优点 不需要实例化对象 缺点 不能通过继承改变创建方法的行为
 */
class SimplePizzaFactory {
    /*
    简单工厂 其实不是一个设计模式，反而像是一种编程习惯
    在设计模式中，实现一个接口，泛指 实现某个超类型（可以是类或者接口）的某个方法
     */
    static Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }

    private static class CheesePizza extends Pizza {
    }

    private static class PepperoniPizza extends Pizza {
    }

    private static class ClamPizza extends Pizza {
    }

    private static class VeggiePizza extends Pizza {
        VeggiePizza() {
            name = "Veggie Pizza";
            dough = "Thin Crust Dough";
            sause = "Marinara Sauce";
            toppings.add("Grated Reggiano Cheese");
        }
    }
}
