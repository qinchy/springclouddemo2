package com.qinchy.springclouddemoprovider2.controller;


import com.qinchy.springclouddemoprovider2.domain.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

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
        return property;
    }

    @GetMapping("/config4")
    public String getName4() {
        return bean.getName();
    }

}
