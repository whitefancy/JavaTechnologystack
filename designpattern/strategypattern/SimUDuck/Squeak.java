package designpattern.strategypattern.SimUDuck;

public class Squeak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("吱吱吱~吱吱吱~~~");
    }
}
