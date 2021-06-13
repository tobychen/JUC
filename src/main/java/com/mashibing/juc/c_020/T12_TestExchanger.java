package com.mashibing.juc.c_020;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class T12_TestExchanger {

    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(()->{
            String s = "T1";
            try {
                System.out.println("start T1");
                s = exchanger.exchange(s);
                System.out.println("end exchange T1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t1").start();


        new Thread(()->{
            String s = "T2";
            try {
                System.out.println("start T2");
                TimeUnit.SECONDS.sleep(2);
                s = exchanger.exchange(s);
                System.out.println("end exchange T2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();


    }
}
