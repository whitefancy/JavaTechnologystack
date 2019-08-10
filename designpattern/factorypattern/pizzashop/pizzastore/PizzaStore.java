package designpattern.factorypattern.pizzashop.pizzastore;


import designpattern.factorypattern.pizzashop.pizza.Pizza;

abstract class PizzaStore {


    /**
     * 将orderPizza声明成 final，防止子类覆盖这个方法
     * 为了使所有的加盟店对订单的处理能够一致
     * 这里，orderPizza并不知道有哪些类参与了pizza的制作，只知道装盘，这就是解耦。
     *
     * @param type
     * @return
     */
    Pizza orderPizza(String type) {
/*
超类从来不管细节，通过实例化正确的比萨类，子类会自行照料一切
 */
        Pizza pizza;
        /*
        最好将创建对象移到orderPizza()之外，
       由新对象专职创建pizza
       这个新对象称为 工厂
         */
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * 父类里的工厂方法， 用来处理对象的创建
     * 并将这样的行为，封装在子类里
     * 工厂方法是抽象的，所以依赖子类来处理对象的创建
     * 工厂方法必须返回一个产品，超类中的方法，通常使用到工厂方法的返回值
     * 工厂方法将客户（也就是超类中的方法），和实际创建的 具体产品的代码 分隔开来
     * 工厂方法可能需要参数来指定所要的产品
     *
     * @param type
     * @return
     */
    abstract Pizza createPizza(String type);
}
