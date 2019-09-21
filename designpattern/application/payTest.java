package designpattern.application;

import java.time.LocalDateTime;

/**
 * 下单支付 的风险控制
 * 风险：
 * 实际支付金额大于用户看到的金额
 * 实际支付的账户不是之前申请的账户
 * 用户支付一笔，实际支付了两笔
 * 用过滤器，如果不符合规则，返回{null,错误信息}，符合规则 返回{object，null}
 * 因为有远程服务，所以过滤规则分为异步和同步两类。
 */
public class payTest {
    public static void main(String[] args) {
        PayOrder order1 = new OrderA(3, 3, 1, 111);
        order1 = new CheckFilterA(order1).check();
        payTest.submit(order1);

        order1 = new OrderA(3, 4, 2, 111);
        order1 = new CheckFilterA(order1).check();
        payTest.submit(order1);

        order1 = new OrderA(300, 300, 2, 111);
        order1 = new CheckFilterA(order1).check();
        order1 = new CheckFilterB(order1).check();
        payTest.submit(order1);

        order1 = new OrderA(-300, -300, 2, 111);
        order1 = new CheckFilterA(order1).check();
        order1 = new CheckFilterB(order1).check();
        payTest.submit(order1);
    }

    private static void submit(PayOrder order1) {
        System.out.println("时间：" + LocalDateTime.now());
        if (order1.errMsg == null) {
            System.out.println(order1.usrId + "通过" + order1.account + "账户花费了" + order1.resCost + "元。");
        } else {
            System.out.println(order1.errMsg);
        }
    }
}

abstract class PayOrder {
    String errMsg;
    int reqCost;
    int resCost;
    int account;
    int usrId;
}

class OrderA extends PayOrder {

    OrderA(int reqCost, int resCost, int account, int userId) {
        this.reqCost = reqCost;
        this.resCost = resCost;
        this.account = account;
        usrId = userId;
    }
}

abstract class CheckFilter extends PayOrder {
    public abstract PayOrder check();
}

class CheckFilterA extends CheckFilter {
    private PayOrder order;

    CheckFilterA(PayOrder order) {
        this.order = order;

    }

    /**
     * 检查金额是否一致
     *
     * @return
     */
    @Override
    public PayOrder check() {
        if (check1().errMsg != null) {
            return order;
        }
        if (order.reqCost != order.resCost) {
            return order;
        }
        order.errMsg = "金额不一致，订单取消！";
        return order;
    }

    /*
    功能扩展
     */
    private PayOrder check1() {
        if (order.reqCost > 0) {
            return order;
        }
        order.errMsg = "金额不能为负数，订单取消！";
        return order;
    }
}

class CheckFilterB extends CheckFilter {
    private PayOrder order;

    CheckFilterB(PayOrder order) {
        this.order = order;

    }

    /**
     * 检查账户有没有钱
     * 异步 耗时
     *
     * @return
     */
    @Override
    public PayOrder check() {
        Bank bank = Bank.getInstance();
        String msg = bank.transfer(order.account, order.resCost);
        if (msg == null) {
            return order;
        }
        order.errMsg = "余额不足，订单取消！";
        return order;
    }
}

class Bank {
    private volatile static Bank uniqueInstance;
    private double[] accounts = new double[4];

    private Bank() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = 200;
        }
    }

    static Bank getInstance() {
        if (Bank.uniqueInstance == null) {
            synchronized (Bank.class) {
                if (Bank.uniqueInstance == null) {
                    Bank.uniqueInstance = new Bank();
                }
            }
        }
        return Bank.uniqueInstance;
    }

    synchronized String transfer(int account, double amount) {
        if (accounts[account] < amount) {
            return "余额不足";
        } else {
            accounts[account] -= amount;
            return null;
        }
    }
}