package com.company;

public class Main {
    public static void main(String[] args) {
        Times times = new Times();
        int stopTimer = 100;
        Thread thread1 = new Thread(new StopWatch(times, stopTimer));
        Thread thread2 = new Thread(new ShowMsg(times, stopTimer));

        thread1.start();
        thread2.start();
    }
}