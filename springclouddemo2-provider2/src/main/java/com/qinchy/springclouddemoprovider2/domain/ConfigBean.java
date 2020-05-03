package com.qinchy.springclouddemoprovider2.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
 
@Component
@ConfigurationProperties(prefix = "demo")
@PropertySource(value = {"customize.properties"})
public class ConfigBean {
 
    private Integer age;
 
    private String name;
 
    public Integer getAge() {
        return age;
    }
 
    public void setAge(Integer age) {
        this.age = age;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}