package com.qinchy.springclouddemoprovider1.domain.generic3;

public class Main1 {

    // super:下界通配符
    public static void main(String[] args) {

        // 红苹果盘可以放Apple
        Plate<? super RedApple> p1 = new Plate<Food>(new Apple("red", 500f));
        System.out.println(p1);

        // 绿苹果盘可以放Apple
        Plate<? super GreenApple> p2 = new Plate<Food>(new Apple("red", 500f));
        System.out.println(p1);

        // 红苹果盘可以放Beef
        Plate<? super RedApple> p3 = new Plate<Food>(new Beef("red", 500.0));
        System.out.println(p3);

        // 绿苹果盘可以放pork
        Plate<? super GreenApple> p4 = new Plate<Food>(new Pork("red", 500.0));
        System.out.println(p4);

        // 牛肉盘可以放水果（红苹果，绿苹果）
        Plate<? super Beef> p5 = new Plate<Food>(new RedApple("red", 500f));
        System.out.println(p2);

        Plate<? super Beef> p6 = new Plate<Food>(new GreenApple("green", 500f));
        System.out.println(p2);

        // 猪肉盘可以放水果（红苹果，绿苹果）
        Plate<? super Pork> p7 = new Plate<Food>(new RedApple("red", 500f));
        System.out.println(p7);

        Plate<? super Pork> p8 = new Plate<Food>(new GreenApple("red", 500f));
        System.out.println(p8);

        // 食物盘能放水果吗？不行，报错
//        Plate<? super Food> p9 = new Plate<Fruit>(new RedApple("red", 500f));

        // 食物盘能放肉吗？不行，报错
//        Plate<? super Food> p10 = new Plate<Meat>(new Beef("red", 500.0));
    }
}
