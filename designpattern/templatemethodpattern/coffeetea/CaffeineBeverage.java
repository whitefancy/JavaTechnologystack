package designpattern.templatemethodpattern.coffeetea;

/**
 * 咖啡因饮料
 */
abstract class CaffeineBeverage {
    void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 钩子方法，缺省实现，子类可以选择覆盖或者保持如此
     *
     * @return
     */
    public boolean customerWantsCondiments() {
        return true;
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    private void boilWater() {
        System.out.println("Boiling water");
    }


    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
