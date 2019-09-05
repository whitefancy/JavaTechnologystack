package designpattern.templatemethodpattern.coffeetea;

public class StarbazzTest {
    public static void main(String[] args) {
        new Coffee().prepareRecipe();
        new Tea().prepareRecipe();
        new CoffeeWithHook().prepareRecipe();
    }
}
