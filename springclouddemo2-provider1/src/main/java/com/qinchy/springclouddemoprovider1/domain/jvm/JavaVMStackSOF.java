package com.qinchy.springclouddemoprovider1.domain.jvm;

/**
 * VM Args; -Xss28k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLength(){
        stackLength++;
        stackLength();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLength();
        }catch (Throwable e){
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
