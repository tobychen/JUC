package com.mashibing.juc.c_000;

public class T05_ThreadJoin {

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());

            for(int i=0; i<10; i++) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"===="+i);
            }
        }
    }

    public static void main(String[] args) {
        Thread [] threads=new Thread[10];
        for(int i=0;i<threads.length;i++){
            threads[i]=new MyThread();
        }

        for(int i=0;i<threads.length;i++){
            threads[i].start();
        }

        try {
            for(int i=0;i<threads.length;i++){
                System.out.println("start join==========="+i);
                threads[i].join();
                System.out.println("end join==========="+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
