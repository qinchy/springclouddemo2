package com.qinchy.springclouddemoprovider1.domain.generic1;

class Employee {
    private String name;  
    private double salary;  
      
    public Employee(String n, double s) {  
        name = n;  
        salary = s;  
    }  
      
    public String getName() {  
        return name;  
    }  
  
    public double getSalary() {  
        return salary;  
    }  
}  