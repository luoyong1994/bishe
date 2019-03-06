package com.ynet.fullview;

import java.util.concurrent.Semaphore;

public class ThreadService extends Thread {
    private ControllServiceBySemaphore controllServiceBySemaphore;
    public ThreadService(ControllServiceBySemaphore controllServiceBySemaphore){
        this.controllServiceBySemaphore= controllServiceBySemaphore;
    }
    @Override
    public void run() {
        controllServiceBySemaphore.serviceControll();
    }
}
