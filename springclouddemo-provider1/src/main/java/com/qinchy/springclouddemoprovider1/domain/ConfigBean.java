package com.qinchy.springclouddemoprovider1.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
 
@Component
@ConfigurationProperties(prefix = "demo")
@PropertySource(value = {"customize.properties"})
public class ConfigBean {
 
    private String phone;
 
    private String wife;
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public String getWife() {
        return wife;
    }
 
    public void setWife(String wife) {
        this.wife = wife;
    }
}