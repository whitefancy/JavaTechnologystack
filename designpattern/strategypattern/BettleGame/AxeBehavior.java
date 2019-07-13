package designpattern.strategypattern.BettleGame;

public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("斧头砍人最血腥！砍！");
    }
}
