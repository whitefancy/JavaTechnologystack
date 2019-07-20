package designpattern.strategypattern.BettleGame;

abstract class Character {
    WeaponBehavior weapon;
    abstract void fight();
    private void setWeapon(WeaponBehavior w){
        this.weapon = w;
    }
}
