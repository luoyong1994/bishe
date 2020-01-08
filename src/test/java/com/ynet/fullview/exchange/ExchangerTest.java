package com.ynet.fullview.exchange;

import java.util.concurrent.Exchanger;

public class ExchangerTest {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<String>();
        Thread[] threads = new Thread[2];
        for(int i=0;i<threads.length;i++){
            threads[i]=new ThreadExchanger(exchanger);
        }
        for(int i=0;i<threads.length;i++){
            threads[i].start();
        }
    }
}
