package com.qinchy.springclouddemoprovider1.domain.generic1;

public class Main2 {
    public static void main(String[] args) {
        Pair<? super Manager> pair = new Pair<Employee>(null, null);
        minMaxSal(new Manager[]{new Manager("Jack", 10000.99),
                new Manager("Tom", 10001.01)}, pair);
    }

    public static void minMaxSal(Manager[] mgrs, Pair<? super Manager> pair) {
        if (mgrs == null || mgrs.length == 0) {
            return;
        }

        pair.setFirst(mgrs[0]);
        pair.setSecond(mgrs[1]);

        System.out.println("1111");

    }
}
