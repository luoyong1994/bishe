package com.ynet.fullview.exchange;

import java.util.concurrent.Exchanger;

public class ThreadExchanger extends Thread{
    private Exchanger<String> exchanger;

    public ThreadExchanger(Exchanger<String> exchanger){
        this.exchanger = exchanger;
    }
    @Override
    public void run() {
        try {
            String ThreadName = Thread.currentThread().getName();
            String declare = ThreadName+"我得到线程为："+exchanger.exchange("我是线程"+ThreadName+"的俘虏");
            System.out.println(declare);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
