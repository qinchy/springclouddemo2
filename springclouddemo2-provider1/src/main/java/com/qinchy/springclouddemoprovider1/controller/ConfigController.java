package com.qinchy.springclouddemoprovider1.controller;


import com.qinchy.springclouddemoprovider1.Constant.SeasonEnum;
import com.qinchy.springclouddemoprovider1.Constant.WeekdayEnum;
import com.qinchy.springclouddemoprovider1.domain.ConfigBean;
import com.qinchy.springclouddemoprovider1.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
public class ConfigController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private Environment environment;

    @Autowired
    private ConfigBean bean;

    @Value("${customize.property}")
    private String property;

    @GetMapping("/config1")
    public String getName1() {
        return ctx.getEnvironment().getProperty("customize.property", String.class);
    }

    @GetMapping("/config2")
    public String getName2() {
        return environment.getProperty("customize.property");
    }

    @GetMapping("/config3")
    public String getName3() {
        if (1 == SeasonEnum.SPRING.getSeq()) {
            Objects.equals("aa", "aa");
            logger.info(" SPRING VALUE = " + SeasonEnum.SPRING.getSeq());
        }

        Integer a = 99;
        Integer b = new Integer(99);
        logger.info(" a == b?" + (a == b));

        // IntegerCache类
        Integer c = 129;
        Integer d = new Integer(129);
        logger.info("c == d?" + (c == d));
        logger.info("c equals d?" + Objects.equals(c, d));

        WeekdayEnum.MONDAY.setValue(0);
        logger.info("MONDAY VALUE = " + WeekdayEnum.MONDAY.getValue());

        return property;
    }

    @GetMapping("/config4")
    public String getName4() {
        return bean.getPhone();
    }

    @GetMapping("/floatcompare1")
    public boolean compare1() {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        float diff = 1e-6f;
        return Math.abs(a - b) < diff;
    }

    @GetMapping("/floatcompare2")
    public boolean compare2() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");

        BigDecimal x = a.subtract(b);
        BigDecimal y = b.subtract(c);

        return x.equals(y);
    }

    /**
     * 禁止使用构造方法 BigDecimal(double)的方式把 double 值转化为 BigDecimal 对象
     * 优先推荐入参为 String 的构造方法，
     * 或使用 BigDecimal 的 valueOf 方法，此方法内部其实执行了Double 的 toString，而 Double 的 toString 按 double 的实际能表达的精度对尾数进行了截断
     *
     * @return
     */
    @GetMapping("/floatcompare3")
    public boolean compare3() {
        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = BigDecimal.valueOf(0.1);

        return a.equals(b);
    }

    @GetMapping("/lengthofyear")
    public int lengthofyear() {
        LocalDate now = LocalDate.now();
        int days = now.lengthOfYear();
        logger.info(now.getYear() + " has " + days + " days ");

        LocalDate localDate = LocalDate.of(2020, 2, 29);
        logger.info(localDate.getYear() + localDate.lengthOfYear() + " days ");

        LocalDate localDate1 = localDate.minusYears(1);
        System.out.println(localDate1);

        return days;
    }

    @GetMapping("/stream")
    public String stream() {
        System.out.println("对象的排序");
        Stream.of(new Person(1, "qinchy1", "1"),
                new Person(2, "qinchy2", "2"),
                new Person(3, "qinchy3", "3"))
                .filter(a-> a.getName().contains("qinchy"))
                .sorted(Person::compareTo)
                .collect(Collectors.toList())
                .stream().forEach(System.out::println);

        String[] arrays = new String[]{"aa","bb","cc","dd"};

        System.out.println("合并所有元素");
        System.out.println(Stream.of(arrays).collect(Collectors.joining()));
        System.out.println(Stream.of(arrays).reduce((str1, str2) -> str1 + str2).get());
        System.out.println("collect 收集到List中");
        System.out.println(Stream.of(arrays).collect(Collectors.toList()).size());
        System.out.println("collect 收集到Set中");
        System.out.println(Stream.of(arrays).collect(Collectors.toSet()).size());

        System.out.println("limit 提取子流");
        Stream.of(arrays).limit(1).forEach(s -> System.out.println(s));

        System.out.println("skip 跳过");
        Stream.of(arrays).skip(1).forEach(s -> System.out.println(s));

        System.out.println("peek产生相同的流，支持每个元素调用一个函数");
        Stream.of(arrays).peek(str -> System.out.println("item:"+str));

        System.out.println("sorted 排序");
        Stream.of(arrays).sorted(Comparator.comparing(String::length).reversed());

        System.out.println("parallel转为并行流,如果希望顺序执行并行流，请使用forEachOrdered方法，谨慎使用");
        Stream.of(arrays).parallel().forEachOrdered(s -> System.out.println(Thread.currentThread().getName()));

        System.out.println("只获取a开头的");
        Arrays.stream(Stream.of(arrays).filter(str -> str.startsWith("a")).toArray(String[]::new)).forEach(s -> System.out.println(s));

        System.out.println("对每个元素大写转换");
        Stream.of(arrays).map(String::toUpperCase).forEach(s -> System.out.println(s));

        Stream<String> arrayStream2 = Arrays.stream(arrays);
        System.out.println(arrayStream2.collect(Collectors.joining()));

        System.out.println("对元素去重");
        Stream.of("a", "b", "c", "d", "a")
                .distinct().forEach(s -> System.out.println(s));

        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");

        List<String> list2 = new ArrayList<>();
        list2.add("cc");
        list2.add("dd");
        System.out.println("合并两个list");
        Stream.of(list1,list2).flatMap(str -> str.stream()).collect(Collectors.toList()).forEach(s -> System.out.println(s));

        System.out.println("generator生成无限长度的stream");
        Stream.generate(Math::random).limit(10).forEach(s -> System.out.println(s));

        System.out.println("iterate 也是生成无限长度的Stream，其元素的生成是重复对给定的种子值调用函数来生成的");
        Stream.iterate(1, item -> item + 1).limit(10).forEach(s -> System.out.println(s));

        System.out.println("min 取最小值");
        System.out.println(IntStream.of(1, 2, 3, 4).min().getAsInt());
        Stream.of("a", "b", "c", "d", "a").min(String::compareTo).get();

        System.out.println("max 取最小值");
        System.out.println(IntStream.of(1, 2, 3, 4).max().getAsInt());
        Stream.of("a", "b", "c", "d", "a").max(String::compareTo).get();

        System.out.println("count 计算总量");
        Stream.of("a", "b", "c", "d", "a").count();

        //anyMatch 判断流中是否含有匹配元素
        boolean hasMatch1 = Stream.of("a", "b", "c", "d", "a").anyMatch(str -> str.startsWith("a"));
        System.out.println("判断流中是否含有匹配元素 " + hasMatch1);

        //allMatch 判断流中是否全部匹配
        boolean hasMatch2 = Stream.of("a", "b", "c", "d", "a").allMatch(str -> str.startsWith("a"));
        System.out.println("判断流中是否全部匹配 " + hasMatch2);

        //noneMatch 判断流中是否全部不匹配
        boolean hasMatch3 = Stream.of("a", "b", "c", "d", "a").noneMatch(str -> str.startsWith("a"));
        System.out.println("判断流中是否全部不匹配 " + hasMatch3);

        //findFirst 找到第一个就返回
        System.out.println(Stream.of("a", "b", "c", "d", "a").filter(str -> str.startsWith("a")).findFirst().get());

        //findAny 找到任意一个就返回
        System.out.println(Stream.of("a", "b", "c", "d", "a").filter(str -> str.startsWith("a")).findAny().get());

        return "Success";
    }
}
