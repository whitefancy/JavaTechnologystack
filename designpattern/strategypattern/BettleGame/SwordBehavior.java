package designpattern.strategypattern.BettleGame;

public class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("宝剑挥舞，帅帅杀人！");
    }
}
