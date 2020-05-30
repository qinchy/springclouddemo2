package com.qinchy.springclouddemoprovider1.domain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}


public class Reflections {
    // 初始
    private static final String REGEXP1 = "1(3[4-9]|4[7]|5[012789]|6[5]|7[28]|8[23478]|9[578])((\\d{8})|([ ]\\d{4}[ ]\\d{4})|([-]\\d{4}[-]\\d{4})|([/]\\d{4}[/]\\d{4}))";
    // 改进
    private static final String REGEXP2 = "1(3[4-9]|4[7]|5[012789]|6[5]|7[28]|8[23478]|9[578])((\\d{8})|([ ]\\d{4}){2}|([-]\\d{4}){2}|([/]\\d{4}){2})";

    public static void main(String[] args) {
        User user = new User();
        user.setName("张三");
        Class<? extends User> clazz = user.getClass();
        try {
            Method setAgeMethod = clazz.getDeclaredMethod("setAge", new Class[]{Integer.class});
            setAgeMethod.invoke(user, new Integer[]{20});
            System.out.println(user.getAge());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Method getNameMethod = clazz.getDeclaredMethod("getName");
            String name = (String) getNameMethod.invoke(user);
            System.out.println(name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        String[] mobile = new String[]{"18812345678", "188 1234 5678", "188-1234-5678", "188/1234/5678","188-1234/5678"};

        Pattern pattern = Pattern.compile(REGEXP2);
        for (String str : mobile) {
            Matcher matcher = pattern.matcher(str);
            System.out.println(matcher.find());
        }


    }
}