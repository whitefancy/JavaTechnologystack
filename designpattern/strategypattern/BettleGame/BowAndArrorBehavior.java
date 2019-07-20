package designpattern.strategypattern.BettleGame;

public class BowAndArrorBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("百里挑一者用弓箭射杀！");
    }
}
