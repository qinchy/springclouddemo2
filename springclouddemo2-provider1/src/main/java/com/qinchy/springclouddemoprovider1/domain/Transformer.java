package com.qinchy.springclouddemoprovider1.domain;

import java.util.ArrayList;
import java.util.LinkedList;

public class Transformer {

    public static void main(String[] args) {
        LinkedList<Integer> integers = base62(10000);
        for (Integer i:integers) {
            Integer i1 = i;
            System.out.println(i1);
        }
    }

    public static LinkedList<Integer> base62(int id) {

        LinkedList<Integer> value = new LinkedList<Integer>();
        while (id > 0) {
            int remainder = id % 62;
            value.add(remainder);
            id = id / 62;
        }

        return value;
    }

    }
