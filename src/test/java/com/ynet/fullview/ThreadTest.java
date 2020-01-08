package com.ynet.fullview;

import java.util.concurrent.Semaphore;

public class ThreadTest {
    public static void main(String[] args) {
        ControllServiceBySemaphore serviceBySemaphore = new ControllServiceBySemaphore(1);
        for(int i=0;i<5;i++){
            ThreadService threadService = new ThreadService(serviceBySemaphore);
            threadService.start();
        }
        System.out.println("线程初始化完毕");
    }
}
