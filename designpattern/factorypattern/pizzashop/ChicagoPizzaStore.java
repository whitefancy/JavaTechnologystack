package designpattern.factorypattern.pizzashop;

class ChicagoPizzaStore extends PizzaStore {
    /**
     * 继承自PizzaStore的连锁店，可以使用自定义的Pizza生产方式，也可以使用工厂类的方法
     *
     * @param type
     * @return
     */
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new ChicagoCheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoPepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ChicagoClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new SimplePizzaFactory().createPizza(type);
        }
        return pizza;
    }

    private class ChicagoCheesePizza extends Pizza {
        ChicagoCheesePizza() {
            name = "Chicago Style Deep Dish Cheese Pizza";
            dough = "Extra Thick Crust Dough";
            sause = "Plum Tomato Sauce";
            toppings.add("Shredded Mozzarella Cheese");
        }

        @Override
        void cut() {
            System.out.println("Cutting the pizza into square slices");
        }
    }

    private class ChicagoClamPizza extends Pizza {
    }

    private class ChicagoPepperoniPizza extends Pizza {
    }
}
