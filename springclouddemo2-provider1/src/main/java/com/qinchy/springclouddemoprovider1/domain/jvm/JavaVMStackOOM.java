package com.qinchy.springclouddemoprovider1.domain.jvm;

/**
 * VM Args:-Xss2M
 */
public class JavaVMStackOOM {
    private void dontStop(){
        while (true) {

        }
    }

    public void stackLeakByThread(){
        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
