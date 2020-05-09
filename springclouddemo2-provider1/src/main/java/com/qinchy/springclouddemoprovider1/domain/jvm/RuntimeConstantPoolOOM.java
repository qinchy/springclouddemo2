package com.qinchy.springclouddemoprovider1.domain.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Xargs:-XX:PermSize=10M -XX:MaxPersize=10M
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 10M的PerSize在integer范围内足够产生OOM了
        int i =0;
        while (true){
            list.add(String.valueOf(i++).concat("aaaaaa").intern());
        }
    }
}
