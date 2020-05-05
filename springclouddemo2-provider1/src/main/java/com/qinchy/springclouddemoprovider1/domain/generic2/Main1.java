package com.qinchy.springclouddemoprovider1.domain.generic2;

public class Main1 {

    // extends:上界通配符
    public static void main(String[] args) {

        // 水果盘可以放Apple
        Plate<? extends Fruit> p1 = new Plate<Apple>(new Apple("red", 500f));
        System.out.println(p1);

        // 水果盘可以放Banana
        Plate<? extends Fruit> p2 = new Plate<Banana>(new Banana("red", 500f));
        System.out.println(p1);

        // 肉盘可以放Beef
        Plate<? extends Meat> p3 = new Plate<Beef>(new Beef("red", 500.0));
        System.out.println(p3);

        // 肉盘可以放Beef
        Plate<? extends Meat> p4 = new Plate<Pork>(new Pork("red", 500.0));
        System.out.println(p4);

        // 食物盘可以放水果（红苹果，绿苹果）
        Plate<? extends Food> p5 = new Plate<Food>(new RedApple("red", 500f));
        System.out.println(p2);

        Plate<? extends Food> p6 = new Plate<Food>(new GreenApple("green", 500f));
        System.out.println(p2);

        // 食物盘可以放肉（牛肉和猪肉）
        Plate<? extends Food> p7 = new Plate<Food>(new Beef("red", 500.0));
        System.out.println(p7);

        Plate<? extends Food> p8 = new Plate<Food>(new Pork("red", 500.0));
        System.out.println(p8);

        // 水果盘能放肉吗？不行，如下报错
//        Plate<? extends Fruit> p9 = new Plate<Meat>(new Beef("red", 500.0));

        // 肉盘能放水果吗？不行，如下报错
//        Plate<? extends Meat> p10 = new Plate<Fruit>(new RedApple("red", 500f));
    }
}
