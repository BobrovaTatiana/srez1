package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.StrictMath.round;

/**
 * Created by Tanusha on 09/02/2017.
 */
public class ShowMsg implements Runnable {
    //public int delay;
    public Times times;
    private int stopTimerAfter;
    ArrayList<Integer> masInt = new ArrayList<Integer>();


    public ShowMsg(Times times, int stopTimerAfter) {
        //this.delay = delay;
        this.times = times;
        this.stopTimerAfter = stopTimerAfter;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (times) {
                try {
                    int timeInt = times.getTime();
                    int k = times.getK();

                    masInt.add(k);
                    Set<Integer> s = new HashSet<Integer>();
                    for (int i : masInt) s.add(i);
                    int distinctCount = s.size();

                    if (distinctCount == 10) return;

                    if((timeInt % 5 == 0) && (timeInt != 0)) {
                        System.out.println("Количество уникальных чисел " + (distinctCount-1));
                    }
                    times.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
