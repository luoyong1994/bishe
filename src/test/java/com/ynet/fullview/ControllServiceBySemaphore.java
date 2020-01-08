package com.ynet.fullview;

import java.util.concurrent.Semaphore;

public class ControllServiceBySemaphore {
    private Semaphore semaphore;
    public ControllServiceBySemaphore(int permit){
        this.semaphore = new Semaphore(permit);
    }

    public void serviceControll(){
        try {
            semaphore.acquire();
            System.out.println("Name:"+Thread.currentThread().getName());
            System.out.println("Time:"+System.currentTimeMillis());
            Thread.sleep(100);
            System.out.println("Time:"+System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
