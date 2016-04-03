package com.studevs.main;

import com.studevs.scheduling.ProcessInitializer;
import com.studevs.scheduling.SJF;

/**
 *
 * @author ashik
 */
public class Main {

    public static void main(String[] args) {

        Thread pi = new Thread(new ProcessInitializer());
        Thread sjf = new Thread(new SJF());
        pi.start();
        sjf.start();
    }
}
