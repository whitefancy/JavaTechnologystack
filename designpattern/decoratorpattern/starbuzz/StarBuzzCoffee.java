package designpattern.decoratorpattern.starbuzz;

public class StarBuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage1 = new Espresso(Size.venti);
        System.out.println(beverage1);

        Beverage beverage = new DarkRoast(Size.tall);
        beverage = new Mocha(beverage);
        beverage = new Mocha(beverage);
        beverage = new Whip(beverage);
        System.out.println(beverage);

        beverage = new HouseBlend(Size.grande);
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        beverage = new Whip(beverage);
        System.out.println(beverage);
    }
}
