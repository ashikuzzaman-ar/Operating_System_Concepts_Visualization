package com.studevs.main;

import com.studevs.scheduling.rr.RoundRobin;

/**
 *
 * @author ashik
 */
public class Main {

    public static void main(String[] args) {

//        new Thread(new ProcessInitializer()).start();
//        new Thread(new SJF()).start();
//        Thread r1 = new Thread(new Reader(1, 5000, 3000));
//        Thread r2 = new Thread(new Reader(2, 3000, 5000));
//        Thread r3 = new Thread(new Reader(3, 4000, 4000));
//
//        Thread w1 = new Thread(new Writer(1, 5000, 3000));
//        Thread w2 = new Thread(new Writer(2, 3000, 5000));
//
//        w1.start();
//        r1.start();
//        w2.start();
//        r2.start();
//        r3.start();
        new Thread(new com.studevs.scheduling.rr.ProcessInitializer()).start();
        new Thread(new RoundRobin(2 * 1000)).start();
    }
}
