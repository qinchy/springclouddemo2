package com.qinchy.springclouddemoprovider2.controller;


import com.qinchy.springclouddemoprovider2.Constant.SeasonEnum;
import com.qinchy.springclouddemoprovider2.Constant.WeekdayEnum;
import com.qinchy.springclouddemoprovider2.domain.ConfigBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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
        logger.info("MONDAY VALUE = "+WeekdayEnum.MONDAY.getValue());

        return property;
    }

    @GetMapping("/config4")
    public String getName4() {
        return bean.getPhone();
    }

}
